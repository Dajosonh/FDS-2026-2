package com.bcopstein.ex1biblioeca;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class Acervo {
    private final List<Livro> livros;

    public Acervo() {
        livros = new LinkedList<>();

        livros.add(new Livro(100, "Aprendendo Spring-Boot",
                "Huguinho Pato", 2020));

        livros.add(new Livro(120, "Aprendendo Java",
                "Zezinho Pato", 2015));

        livros.add(new Livro(140, "Aprendendo Outra coisa",
                "Luizinho Pato", 2023));

        livros.add(new Livro(140, "Aprendendo Uma coisa nova",
                "Huguinho Pato", 2023));

        livros.add(new Livro(140, "Aprendendo Outra coisa nova",
                "Huguinho Pato", 2023));
    }

    public List<Livro> todosOsLivros() {
        return livros;
    }

    public List<String> todosOsAutores() {
        return livros.stream()
                .map(Livro::getAutor)
                .distinct()
                .toList();
    }

    public List<Livro> livrosDoAutor(String autor) {
        return livros.stream()
                .filter(livro -> livro.getAutor().equals(autor.trim()))
                .toList();
    }

    public void adicionaLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> livrosPorAno(int ano) {
        return livros.stream()
                .filter(livro -> livro.getAno() == ano)
                .toList();
    }

    public List<Livro> livrosDesatualizados(int ano) {
        return livros.stream()
                .filter(livro -> livro.getAno() < ano)
                .toList();
    }

    public List<Livro> livrosDoAutorNoAno(
            String autor, int ano) {

        return livros.stream()
                .filter(livro -> livro.getAutor().equals(autor.trim()))
                .filter(livro -> livro.getAno() == ano)
                .toList();
    }

    public boolean atualizaLivro(Livro livroAtualizado) {

        Optional<Livro> livroOp = livros.stream()
                .filter(livro -> livro.getId() == livroAtualizado.getId())
                .findFirst();

        if (livroOp.isEmpty()) {
            return false;
        }

        livros.remove(livroOp.get());
        livros.add(livroAtualizado);

        return true;
    }
}
