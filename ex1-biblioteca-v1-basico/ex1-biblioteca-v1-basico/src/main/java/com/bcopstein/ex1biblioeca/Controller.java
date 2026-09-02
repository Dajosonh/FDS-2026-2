package com.bcopstein.ex1biblioeca;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final List<Livro> livros;

    public Controller() {
        livros = new ArrayList<>();
        livros.add(new Livro(1, "A Metamorfose", "Franz Kafka", 1915));
        livros.add(new Livro(2, "Declínio de um Homem", "Osamu Dazai", 1948));
        livros.add(new Livro(3, "O Estrangeiro", "Albert Camus", 1942));
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
}
