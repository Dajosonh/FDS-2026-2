import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VendasEmMemoria implements VendasFachada {
    private List<Oferta> ofertas;

    public VendasEmMemoria() {
        ofertas = new ArrayList<>();

        Produto caneta = new Produto(1, "Caneta", 1.55);
        Produto borracha = new Produto(2, "Borracha", 1.15);
        Produto caderno = new Produto(3, "Caderno", 32.99);

        Kit kitEscolar = new Kit(4, "Kit Escolar");
        kitEscolar.adicionar(caneta);
        kitEscolar.adicionar(borracha);
        kitEscolar.adicionar(caderno);

        ofertas.add(caneta);
        ofertas.add(borracha);
        ofertas.add(caderno);
        ofertas.add(kitEscolar);
    }

    @Override
    public Venda iniciarVenda() {
        return new Venda(LocalDateTime.now());
    }

    @Override
    public void registrarVenda(Venda umaVenda, int codigoProduto, int quantidade) {
        Oferta oferta = ofertas.stream()
                .filter(o -> o.getId() == codigoProduto)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Oferta nao encontrada"));
        umaVenda.registrarVenda(oferta, quantidade);
    }

    @Override
    public String emitirComprovante(Venda umaVenda) {
        return umaVenda.emitirComprovante();
    }

    @Override
    public List<Oferta> buscarProdutos() {
        return Collections.unmodifiableList(ofertas);
    }

}
