import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FonteDeDados {

    public interface Observador {
        void atualiza(Integer valor);
    }

    private List<Integer> lst;
    private List<Observador> observadores;

    public FonteDeDados() {
        lst = new LinkedList<>();
        observadores = new ArrayList<>();
    }

    public void registra(Observador observador) {
        if (observador != null && !observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    public void remove(Observador observador) {
        observadores.remove(observador);
    }

    public void notifica(Integer valor) {
        for (Observador observador : new ArrayList<>(observadores)) {
            observador.atualiza(valor);
        }
    }

    public void add(Integer value) {
        if (value == null || value < 0) throw new IllegalArgumentException("Valor invalido");
        lst.add(value);
        notifica(value);
    }

    public int quantidade() {
        return lst.size();
    }

    public List<Integer> getValores() {
        return new ArrayList<>(lst);
    }
}
