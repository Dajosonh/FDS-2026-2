public class LogColchetes extends LoggerDecorator {
    public LogColchetes(Logger logger) {
        super(logger);
    }

    @Override
    public void log(String m) {
        super.log("[" + m + "]");
    }
}