public class LogNivel1 extends LoggerDecorator {
    public LogNivel1(Logger logger) {
        super(logger);
    }

    @Override
    public void log(String m) {
        super.log("NIVEL 1 " + m);
    }
}