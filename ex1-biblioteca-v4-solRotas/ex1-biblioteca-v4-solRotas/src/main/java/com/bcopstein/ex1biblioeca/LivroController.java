package com.bcopstein.ex1biblioeca;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class LivroController {

    private final Acervo acervo;

    public LivroController(Acervo acervo) {
        this.acervo = acervo;
    }

    @GetMapping("")
    public String mensagemDeBemVindo() {
        return "Bem vindo a biblioteca central!";
    }

    @GetMapping("/livros")
    public List<Livro> getListaLivros() {
        return acervo.todosOsLivros();
    }

    @PostMapping("/novolivro")
    public boolean cadastraLivroNovo(@RequestBody Livro livro) {
        acervo.adicionaLivro(livro);
        return true;
    }

    @GetMapping("/livrosporano")
    public List<Livro> getLivrosPorAno(
            @RequestParam int ano) {

        return acervo.livrosPorAno(ano);
    }

    @GetMapping("/desatualizados/{ano}")
    public List<Livro> getLivrosDesatualizados(
            @PathVariable int ano) {

        return acervo.livrosDesatualizados(ano);
    }

    @PostMapping("/atualiza")
    public boolean atualizaLivro(
            @RequestBody Livro livroAtualizado) {

        return acervo.atualizaLivro(livroAtualizado);
    }
}
