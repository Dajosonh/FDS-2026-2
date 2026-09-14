package com.bcopstein.ex1biblioeca;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class AutorController {

    private final Acervo acervo;
    private final EstatisticaAutor estatisticaAutor;

    public AutorController(
            Acervo acervo,
            EstatisticaAutor estatisticaAutor) {

        this.acervo = acervo;
        this.estatisticaAutor = estatisticaAutor;
    }

    @GetMapping("/autores")
    public List<String> getListaAutores() {
        return acervo.todosOsAutores();
    }

    @GetMapping("/livrosautor")
    public List<Livro> getLivrosDoAutor(
            @RequestParam String autor) {

        estatisticaAutor.registraConsulta(autor);

        return acervo.livrosDoAutor(autor);
    }

    @GetMapping("/livrosautor/{autor}/ano/{ano}")
    public List<Livro> getLivrosDoAutorNoAno(
            @PathVariable String autor,
            @PathVariable int ano) {

        estatisticaAutor.registraConsulta(autor);

        return acervo.livrosDoAutorNoAno(autor, ano);
    }

    @GetMapping("/autores/estatisticas")
    public Map<String, Integer> getEstatisticas() {
        return estatisticaAutor.getEstatisticas();
    }

    @GetMapping("/autores/maisconsultado")
    public String getMaisConsultado() {
        return estatisticaAutor.getMaisConsultado();
    }

    @GetMapping("/autores/menosconsultado")
    public String getMenosConsultado() {
        return estatisticaAutor.getMenosConsultado();
    }
}
