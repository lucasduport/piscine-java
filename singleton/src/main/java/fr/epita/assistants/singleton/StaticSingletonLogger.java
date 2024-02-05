package fr.epita.assistants.singleton;

import fr.epita.assistants.logger.Logger;

public class StaticSingletonLogger implements Logger {

    private StaticSingletonLogger()
    {}

    private static class InstanceHolder
    {
        static int _error = 0;
        static int _warn = 0;

        static int _info = 0;
        private final static StaticSingletonLogger instance = new StaticSingletonLogger();
    }

    public static StaticSingletonLogger getInstance()
    {
        return InstanceHolder.instance;
    }

    @Override
    public void log(Level level, String message) {
        if (level == Level.ERROR)
            InstanceHolder._error++;
        else if(level == Level.WARN)
            InstanceHolder._warn++;
        else if(level == Level.INFO)
            InstanceHolder._info++;
        System.err.println(Logger.getFormattedLog(level, message));
    }

    @Override
    public int getInfoCounter() {
        return InstanceHolder._info;
    }

    @Override
    public int getWarnCounter() {
        return InstanceHolder._warn;
    }

    @Override
    public int getErrorCounter() {
        return InstanceHolder._error;
    }

    @Override
    public void reset() {
        InstanceHolder._info = InstanceHolder._warn = InstanceHolder._error = 0;
    }
}
