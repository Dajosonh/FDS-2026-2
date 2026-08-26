import java.util.ArrayList;
import java.util.List;

public class Kit implements Oferta {
    private int id;
    private String nome;
    private List<Oferta> itens = new ArrayList<>();

    public Kit(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public void adicionar(Oferta oferta) {
        itens.add(oferta);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        double total = 0;

        for (Oferta item : itens) {
            total += item.getPreco();
        }

        return total;
    }
}
