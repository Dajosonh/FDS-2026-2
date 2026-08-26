public class App {
    public static void main(String[] args) {
        String email = "bernardo.copstein@pucrs.br";

        var validador = new Validador(
                new ValidadorEmail());

        if (validador.valida(email)) {
            System.out.println(email + " é um email válido!");
        } else {
            System.out.println(email + " não é um email válido!");
        }
    }
}
