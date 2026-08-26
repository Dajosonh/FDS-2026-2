public class App {
    public static void main(String[] args) {

        Dado d6 = new Dado(6);
        Dado d20 = new Dado(20);
        d6.rolar();
        d20.rolar();
        System.out.println("D6: " + d6.getValor());
        System.out.println("D20: " + d20.getValor());

        System.out.println("\n=== D6 decorado com histórico ===");
        Dado d6ComHistorico = new Dado(d6, 5);
        System.out.println(d6ComHistorico);

        for (int i = 1; i <= 8; i++) {
            d6ComHistorico.rolar();
            System.out.println("Jogada " + i + ": " + d6ComHistorico.getValor()
                    + "   últimas 5: " + d6ComHistorico.getUltimasJogadas());
        }


        System.out.println("Histórico do d6 puro: " + d6.getUltimasJogadas());

        System.out.println("\n=== D20 com duas janelas ===");
        Dado curto = new Dado(new Dado(20), 3);
        Dado longo = new Dado(curto, 10);
        for (int i = 0; i < 6; i++) {
            longo.rolar();
        }
        System.out.println("Últimas 10: " + longo.getUltimasJogadas());
        System.out.println("Últimas 3:  " + curto.getUltimasJogadas());
    }
}
