import java.util.List;

public class App {
    public static void main(String[] args) {
        VendasFachada proc = new VendasEmMemoria();
        List<Oferta> ofertas = proc.buscarProdutos();
        Venda venda = proc.iniciarVenda();

        proc.registrarVenda(venda, ofertas.get(0).getId(), 2);
        proc.registrarVenda(venda, ofertas.get(3).getId(), 1);

        System.out.println(proc.emitirComprovante(venda));
    }
}
