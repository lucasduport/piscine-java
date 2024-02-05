package fr.epita.assistants.singleton;

import fr.epita.assistants.logger.Logger;

public class StaticSingletonLogger implements Logger {
    public static final StaticSingletonLogger INSTANCE = new StaticSingletonLogger();

    private StaticSingletonLogger()
    {
    }
    @Override
    public void log(Level level, String message) {
        System.err.println(Logger.getFormattedLog(level, message));
    }

    @Override
    public int getInfoCounter() {
        return INSTANCE.getInfoCounter();
    }

    @Override
    public int getWarnCounter() {
        return INSTANCE.getWarnCounter();
    }

    @Override
    public int getErrorCounter() {
        return INSTANCE.getErrorCounter();
    }

    @Override
    public void reset() {
        INSTANCE.reset();
    }
}
