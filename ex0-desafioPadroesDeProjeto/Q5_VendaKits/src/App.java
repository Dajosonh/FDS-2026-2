import java.util.List;

public class App {
    public static void main(String[] args) {
        VendasFachada proc = new VendasEmMemoria();
        List<Oferta> ofertas = proc.buscarProdutos();

        // Exibir ofertas disponíveis
        System.out.println("=== OFERTAS DISPONÍVEIS ===");
        for (Oferta oferta : ofertas) {
            if (oferta instanceof Kit) {
                System.out.printf("KIT #%d: %s (%.2f)%n", oferta.getId(), oferta.getNome(), oferta.getPreco());
            } else {
                System.out.printf("PROD #%d: %s (%.2f)%n", oferta.getId(), oferta.getNome(), oferta.getPreco());
            }
        }

        System.out.println("\n=== VENDA 1: Produtos Individuais ===");
        Venda venda1 = proc.iniciarVenda();
        proc.registrarVenda(venda1, ofertas.get(0).getId(), 2); // 2x Caneta
        proc.registrarVenda(venda1, ofertas.get(1).getId(), 1); // 1x Borracha
        System.out.println(proc.emitirComprovante(venda1));

        System.out.println("\n=== VENDA 2: Com Kit ===");
        Venda venda2 = proc.iniciarVenda();
        proc.registrarVenda(venda2, ofertas.get(3).getId(), 1); // 1x Kit Escolar (composite)
        System.out.println(proc.emitirComprovante(venda2));
    }
}
