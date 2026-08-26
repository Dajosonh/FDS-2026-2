import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LogSimples implements Logger, Iterable<String> {

    private static LogSimples instancia;
    private List<String> mensagens;

    private LogSimples() {
        mensagens = new LinkedList<>();
    }

    public static LogSimples getInstancia() {
        if (instancia == null) {
            instancia = new LogSimples();
        }
        return instancia;
    }

    @Override
    public void log(String m) {
        String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String logM = dataHora + " : " + m;
        mensagens.add(logM);
    }

    @Override
    public Iterator<String> iterator() {
        return mensagens.iterator();
    }
}