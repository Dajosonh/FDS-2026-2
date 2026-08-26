import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dado {
    private int lados;
    private int valorJogada;
    private final Random random;

    // campos usados só quando o objeto é decorador
    private final Dado interno;
    private final List<Integer> ultimasJogadas;
    private final int limite;

    // construtor original: dado simples
    public Dado(int lados) {
        this.lados = lados;
        this.random = new Random();
        this.interno = null;
        this.ultimasJogadas = null;
        this.limite = 0;
    }

    // decorador com as 5 últimas jogadas
    public Dado(Dado interno) {
        this(interno, 5);
    }

    // decorador com as N últimas jogadas
    public Dado(Dado interno, int limite) {
        if (interno == null) {
            throw new IllegalArgumentException("O dado a ser decorado não pode ser nulo.");
        }
        this.lados = interno.lados;   // acesso direto: é a mesma classe
        this.random = null;
        this.interno = interno;
        this.ultimasJogadas = new ArrayList<>();
        this.limite = limite;
    }

    public void rolar() {
        if (interno == null) {                 // dado simples: sorteia
            valorJogada = random.nextInt(lados) + 1;
            return;
        }
        interno.rolar();                       // decorador: delega
        valorJogada = interno.getValor();      // lê o resultado
        ultimasJogadas.add(valorJogada);       // e acrescenta a responsabilidade nova
        if (ultimasJogadas.size() > limite) {
            ultimasJogadas.remove(0);          // descarta a mais antiga
        }
    }

    public int getValor() {
        return valorJogada;
    }

    public List<Integer> getUltimasJogadas() {
        if (interno == null) {
            return new ArrayList<>();          // dado simples não guarda nada
        }
        return new ArrayList<>(ultimasJogadas);
    }

    public int getLados() {
        return lados;
    }

    @Override
    public String toString() {
        if (interno == null) {
            return "Dado simples de " + lados + " lados";
        }
        return "Dado com histórico das " + limite + " últimas jogadas sobre [" + interno + "]";
    }
}
