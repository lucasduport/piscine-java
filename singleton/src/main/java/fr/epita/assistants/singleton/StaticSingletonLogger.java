package fr.epita.assistants.singleton;

import fr.epita.assistants.logger.Logger;

public class StaticSingletonLogger implements Logger {

    private StaticSingletonLogger()
    {}

    private static class SingletonHolder
    {
        private final static StaticSingletonLogger instance = new StaticSingletonLogger();
    }

    public static StaticSingletonLogger getInstance()
    {
        return SingletonHolder.instance;
    }

    private int _error = 0;
    private int _warn = 0;

    private int _info = 0;

    @Override
    public void log(Level level, String message) {
        if (level == Level.ERROR)
            getInstance()._info++;
        else if(level == Level.WARN)
            getInstance()._warn++;
        else if(level == Level.INFO)
            getInstance()._info++;
        System.err.println(Logger.getFormattedLog(level, message));
    }

    @Override
    public int getInfoCounter() {
        return getInstance()._info;
    }

    @Override
    public int getWarnCounter() {
        return getInstance()._warn;
    }

    @Override
    public int getErrorCounter() {
        return getInstance()._error;
    }

    @Override
    public void reset() {
        getInstance()._info = getInstance()._warn = getInstance()._error = 0;
    }
}
