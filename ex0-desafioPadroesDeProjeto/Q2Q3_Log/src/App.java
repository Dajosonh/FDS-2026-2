public class App {
    public static void main(String[] args) {
        
        LogSimples logBase = LogSimples.getInstancia();

        Logger logAlerta1 = new LogNivel1(new LogColchetes(logBase));
        Logger logAlarme23 = new LogNivel2(new LogColchetes(logBase));
        Logger logPanico = new LogNivel2(new LogColchetes(new LogMaiusculas(logBase)));

        logAlerta1.log("Mensagem de alerta 1");
        logAlarme23.log("Mensagem de alarme 23");
        logPanico.log("Mensagem de PANICO!!");

        for (String m : logBase) {
            System.out.println(m);
        }
    }
}