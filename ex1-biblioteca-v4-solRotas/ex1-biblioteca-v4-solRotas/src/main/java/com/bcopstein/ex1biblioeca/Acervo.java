package com.bcopstein.ex1biblioeca;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Acervo {

    private final LivrosRepository livroRepository;

    public Acervo(LivrosRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @PostConstruct
    public void init() {
        if (livroRepository.count() == 0) {
            livroRepository.save(new Livro(10, "Introdução ao Java", "Huguinho Pato", 2022));
            livroRepository.save(new Livro(20, "Introdução ao Spring-Boot", "Zezinho Pato", 2020));
            livroRepository.save(new Livro(15, "Principios SOLID", "Luizinho Pato", 2023));
            livroRepository.save(new Livro(17, "Padroes de Projeto", "Lala Pato", 2019));
            livroRepository.save(new Livro(25, "Usando JPA", "Lala Pato", 2026));
        }
    }

    public List<Livro> todosOsLivros() {
        return livroRepository.findAll();
    }

    public List<String> todosOsTitulos() {
        return livroRepository.findAll().stream()
                .map(Livro::getTitulo)
                .toList();
    }

    public List<String> todosOsAutores() {
        return livroRepository.findAll().stream()
                .map(Livro::getAutor)
                .distinct()
                .toList();
    }

    public List<Livro> livrosDoAutor(String autor) {
        return livroRepository.findByAutor(autor.trim());
    }

    public void adicionaLivro(Livro livro) {
        livroRepository.save(livro);
    }

    public List<Livro> livrosPorAno(int ano) {
        return livroRepository.findAll().stream()
                .filter(livro -> livro.getAno() == ano)
                .toList();
    }

    public List<Livro> livrosDesatualizados(int ano) {
        return livroRepository.findAll().stream()
                .filter(livro -> livro.getAno() < ano)
                .toList();
    }

    public List<Livro> livrosDoAutorNoAno(String autor, int ano) {
        return livroRepository.findByAutor(autor.trim()).stream()
                .filter(livro -> livro.getAno() == ano)
                .toList();
    }

    public boolean atualizaLivro(long codigo, Livro novosDados) {
        if (!livroRepository.existsById(codigo)) {
            return false;
        }

        livroRepository.save(new Livro(
                codigo,
                novosDados.getTitulo(),
                novosDados.getAutor(),
                novosDados.getAno()));
        return true;
    }

    public boolean removeLivro(long codigo) {
        if (!livroRepository.existsById(codigo)) {
            return false;
        }

        livroRepository.deleteById(codigo);
        return true;
    }
}
