public class LogMaiusculas extends LoggerDecorator {
    public LogMaiusculas(Logger logger) {
        super(logger);
    }

    @Override
    public void log(String m) {
        super.log(m.toUpperCase());
    }
}