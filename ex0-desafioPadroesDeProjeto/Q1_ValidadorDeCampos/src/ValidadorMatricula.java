public class ValidadorMatricula implements EstrategiaValidacao {

    private final EstrategiaValidacao validadorInteiro = new ValidadorInteiro();

    @Override
    public boolean valida(String valor) {

        if (!validadorInteiro.valida(valor)) {
            return false;
        }

        int sum = 0;

        for (int i = 0; i < valor.length() - 1; i++) {
            sum += Character.getNumericValue(valor.charAt(i));
        }

        int verificador = sum % 10;

        return verificador == Character.getNumericValue(valor.charAt(valor.length() - 1));
    }
}
