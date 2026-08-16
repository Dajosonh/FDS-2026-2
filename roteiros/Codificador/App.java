public class App {
    public static void main(String[] args) {
        String texto = "Hello World"; // Pode mudar dps pq to sem ideia

        Codificador[] codificadores = {
                new CodificadorCesar(),
                new CodificadorReverso()
        };

        for (Codificador cod : codificadores) {
            System.out.println("Codificador: " + cod.getNome());
            System.out.println("Versao: " + cod.getDataCriacao());
            System.out.println("Nivel de seguranca: " + cod.getNivelSeguranca());
            System.out.println("Texto original: " + texto);
            System.out.println("Texto codificado: " + cod.codifica(texto));
            System.out.println("Texto decodificado: " + cod.decodifica(cod.codifica(texto)));
            System.out.println();
        }
    }
}

// public class App {
// public static void main(String[] args) throws Exception {
// Codificador cod = new CodificadorCesar();

// System.out.println("Codificador: " + cod.getNome());
// System.out.println("Versao: " + cod.getDataCriacao());
// System.out.println("Nivel de segurança: " + cod.getNivelSeguranca());

// String texto = "Este e o string a ser codificado";
// String codificado = cod.codifica(texto);
// String decodificado = cod.decodifica(codificado);

// System.out.println("Texto original: " + texto);
// System.out.println("Texto codificado: " + codificado);
// System.out.println("Texto decodificado: " + decodificado);
// }
// }
