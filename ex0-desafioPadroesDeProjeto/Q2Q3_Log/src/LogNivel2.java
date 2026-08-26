public class LogNivel2 extends LoggerDecorator {
    public LogNivel2(Logger logger) {
        super(logger);
    }

    @Override
    public void log(String m) {
        super.log("NIVEL 2 " + m);
    }
}