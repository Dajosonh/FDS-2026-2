public class Validador {

    private EstrategiaValidacao estrategia;

    public Validador(EstrategiaValidacao estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(EstrategiaValidacao estrategia) {
        this.estrategia = estrategia;
    }

    public boolean valida(String valor) {
        return estrategia.valida(valor);
    }
}
