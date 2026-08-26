import java.util.ArrayList;
import java.util.List;

public class VisualizadorDeMedia implements FonteDeDados.Observador {

    private List<Integer> valores;
    private boolean ativo = true;

    public VisualizadorDeMedia(List<Integer> valores) {
        this.valores = new ArrayList<>(valores);
    }

    public void defineValores(List<Integer> valores) {
        this.valores = new ArrayList<>(valores);
    }

    public void acrescentaValor(Integer valor) {
        this.valores.add(valor);
    }

    public void ativa() {
        this.ativo = true;
    }

    public void desativa() {
        this.ativo = false;
    }

    public boolean estaAtivo() {
        return ativo;
    }

    @Override
    public void atualiza(Integer valor) {
        if (!ativo) return;
        acrescentaValor(valor);
        exibeMedia();
    }

    public void exibeMedia() {
        double media = valores.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("Media: " + media + ", quantidade de elementos analisados: " + valores.size());
    }
}
