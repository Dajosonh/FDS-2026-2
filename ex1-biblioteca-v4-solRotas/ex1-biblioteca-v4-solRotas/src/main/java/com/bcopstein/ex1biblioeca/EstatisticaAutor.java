package com.bcopstein.ex1biblioeca;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class EstatisticaAutor {

    private final Map<String, Integer> consultas;

    public EstatisticaAutor() {
        consultas = new HashMap<>();
    }

    public void registraConsulta(String autor) {
        autor = autor.trim();

        consultas.put(
                autor,
                consultas.getOrDefault(autor, 0) + 1);
    }

    public Map<String, Integer> getEstatisticas() {
        return consultas;
    }

    public String getMaisConsultado() {

        if (consultas.isEmpty()) {
            return "Nenhum autor foi consultado";
        }

        return consultas.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }

    public String getMenosConsultado() {

        if (consultas.isEmpty()) {
            return "Nenhum autor foi consultado";
        }

        return consultas.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }
}
