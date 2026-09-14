package com.bcopstein.ex1biblioeca;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class LivrosRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Livro> livroRowMapper = new RowMapper<>() {
        @Override
        public Livro mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Livro(rs.getLong("id"), rs.getString("titulo"),
                    rs.getString("autor"), rs.getInt("ano"));
        }
    };

    @PostConstruct
    public void init() {
        // Inicializa com dados padrão se o banco estiver vazio
        if (livroRepository.count() == 0) {
            livroRepository.save(new Livro(10, "Introdução ao Java", "Huguinho Pato", 2022));
            livroRepository.save(new Livro(20, "Introdução ao Spring-Boot", "Zezinho Pato", 2020));
            livroRepository.save(new Livro(15, "Principios SOLID", "Luizinho Pato", 2023));
            livroRepository.save(new Livro(17, "Padroes de Projeto", "Lala Pato", 2019));
            livroRepository.save(new Livro(25, "Usando JPA", "Lala Pato", 2026));
        }
    }

    @Autowired
    public LivrosRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        criarTabelaSeNecessario();
    }

    private void criarTabelaSeNecessario() {
        jdbcTemplate.execute("""
                    CREATE TABLE IF NOT EXISTS livros (
                        id BIGINT PRIMARY KEY,
                        titulo VARCHAR(255) NOT NULL,
                        autor VARCHAR(255) NOT NULL,
                        ano INT NOT NULL)
                """);
    }

    public int count() {
        // SELECT COUNT
    }

    public void save(Livro livro) {
        int atualizados = jdbcTemplate.update(
                "UPDATE livros SET titulo = ?, autor = ?, ano = ? WHERE id = ?",
                livro.getTitulo(), livro.getAutor(), livro.getAno(), livro.getId());
        if (atualizados == 0) {
            jdbcTemplate.update(
                    "INSERT INTO livros (id, titulo, autor, ano) VALUES (?, ?, ?, ?)",
                    livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getAno());
        }
    }

    public List<Livro> findAll() {
        return jdbcTemplate.query(
                "SELECT id, titulo, autor, ano FROM livros",
                livroRowMapper);
    }

    public List<Livro> findByAutor(String autor) {
        return jdbcTemplate.query(
                "SELECT id, titulo, autor, ano FROM livros WHERE autor = ?",
                livroRowMapper, autor);
    }

    public boolean existsById(int id) {

    }

    public void deleteById(int id) {

    }
}
