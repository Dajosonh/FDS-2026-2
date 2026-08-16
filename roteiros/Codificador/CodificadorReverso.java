import java.time.LocalDate;

public class CodificadorReverso implements Codificador {
    public String getNome() {
        return "Codificador Reverso";
    }

    public LocalDate getDataCriacao() {
        return LocalDate.of(2026, 8, 16);
    }

    public int getNivelSeguranca() {
        return 1;
    }

    public String codifica(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public String decodifica(String str) {

        // Parte do Davi

        return null;

    }
}
