public abstract class LoggerDecorator implements Logger {
    protected Logger loggerWrappeado;

    public LoggerDecorator(Logger logger) {
        this.loggerWrappeado = logger;
    }

    @Override
    public void log(String m) {
        loggerWrappeado.log(m);
    }
}