import java.util.ArrayList;
import java.util.List;

public class VisualizadorDeSomatorio implements FonteDeDados.Observador {

    private List<Integer> valores;
    private boolean ativo = true;

    public VisualizadorDeSomatorio(List<Integer> valores) {
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
        exibeSomatorio();
    }

    public void exibeSomatorio() {
        int soma = valores.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Somatorio: " + soma + ", quantidade de elementos analisados: " + valores.size());
    }
}
