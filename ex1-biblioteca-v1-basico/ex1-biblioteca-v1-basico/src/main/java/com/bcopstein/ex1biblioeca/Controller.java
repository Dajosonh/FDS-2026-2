package com.bcopstein.ex1biblioeca;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final List<Livro> livros;

    public Controller() {
        livros = Arrays.asList(
                new Livro(1, "Dom Casmurro", "Machado de Assis", 1899),
                new Livro(2, "O Cortico", "Aluisio Azevedo", 1890),
                new Livro(3, "Memorias Postumas de Bras Cubas", "Machado de Assis", 1881));
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String mensagemDeBemVindo() {
        return "Bem vindo a biblioteca central!";
    }

    @GetMapping("/livros")
    @CrossOrigin(origins = "*")
    public List<Livro> listaLivros() {
        return livros;
    }

    @GetMapping("/titulos")
    @CrossOrigin(origins = "*")
    public List<String> listaTitulos() {
        return livros.stream()
                .map(Livro::getTitulo)
                .collect(Collectors.toList());
    }

    @GetMapping("/autores")
    @CrossOrigin(origins = "*")
    public List<String> listaAutores() {
        return livros.stream()
                .map(Livro::getAutor)
                .distinct()
                .collect(Collectors.toList());
    }
}