import java.time.LocalDate;

public class CodificadorCesar implements Codificador {
    private static final int deslocamento = 3;

    public String getNome() {
        return "Codificador Cesar";
    }

    public LocalDate getDataCriacao() {
        return LocalDate.of(2025, 03, 16);
    }

    public int getNivelSeguranca() {
        return 2;
    }

    public String codifica(String str) {
        StringBuilder encoded = new StringBuilder();

        for (char c : str.toCharArray()) {
            encoded.append((char) (c + deslocamento));
        }

        return encoded.toString();
    }

    public String decodifica(String str) {
        StringBuilder encoded = new StringBuilder();

        for (char c : str.toCharArray()) {
            encoded.append((char) (c - deslocamento));
        }

        return encoded.toString();
    }
}
