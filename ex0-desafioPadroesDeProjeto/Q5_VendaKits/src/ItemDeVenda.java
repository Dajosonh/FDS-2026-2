public class ItemDeVenda {
    private Oferta oferta;
    private int quantidade;

    public ItemDeVenda(Oferta oferta, int quantidade) {
        this.oferta = oferta;
        this.quantidade = quantidade;
    }

    public double getSubTotal() {
        return oferta.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return String.format(
                "%d %s %d x %.2f = %.2f%n",
                oferta.getId(),
                oferta.getNome(),
                quantidade,
                oferta.getPreco(),
                getSubTotal());
    }
}
