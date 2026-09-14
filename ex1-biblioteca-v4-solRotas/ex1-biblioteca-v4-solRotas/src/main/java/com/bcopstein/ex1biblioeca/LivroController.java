package com.bcopstein.ex1biblioeca;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/titulos")
    public List<String> getListaTitulos() {
        return acervo.todosOsTitulos();
    }

    @PostMapping("/livros")
    public ResponseEntity<Livro> cadastraLivroNovo(@RequestBody Livro livro) {
        acervo.adicionaLivro(livro);
        return ResponseEntity
                .created(URI.create("/livros/" + livro.getId()))
                .body(livro);
    }

    @GetMapping("/livrosporano")
    public List<Livro> getLivrosPorAno(@RequestParam int ano) {
        return acervo.livrosPorAno(ano);
    }

    @GetMapping("/desatualizados/{ano}")
    public List<Livro> getLivrosDesatualizados(@PathVariable int ano) {
        return acervo.livrosDesatualizados(ano);
    }

    @PutMapping("/livros/{codigo}")
    public ResponseEntity<Livro> atualizaLivro(
            @PathVariable long codigo,
            @RequestBody Livro novosDados) {

        if (!acervo.atualizaLivro(codigo, novosDados)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new Livro(
                codigo,
                novosDados.getTitulo(),
                novosDados.getAutor(),
                novosDados.getAno()));
    }

    @DeleteMapping("/livros/{codigo}")
    public ResponseEntity<Void> removeLivro(@PathVariable long codigo) {
        if (!acervo.removeLivro(codigo)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
