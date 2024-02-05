package fr.epita.assistants.singleton;

import fr.epita.assistants.logger.Logger;

public class StaticSingletonLogger implements Logger {
    public static class InstanceHolder{
        private static StaticSingletonLogger _INSTANCE;
        public InstanceHolder(StaticSingletonLogger s)
        {
            _INSTANCE = s;
        }

        public static StaticSingletonLogger getInstance()
        {
            return _INSTANCE;
        }
    }
    {
        new InstanceHolder(this);
    }

    private int _info;
    private int _warn;
    private int _error;

    private StaticSingletonLogger()
    {
    }
    @Override
    public void log(Level level, String message) {
        if (level == Level.ERROR)
            _error++;
        else if(level == Level.WARN)
            _warn++;
        else if(level == Level.INFO)
            _info++;
        System.err.println(Logger.getFormattedLog(level, message));
    }

    @Override
    public int getInfoCounter() {
        return _info;
    }

    @Override
    public int getWarnCounter() {
        return _warn;
    }

    @Override
    public int getErrorCounter() {
        return _error;
    }

    @Override
    public void reset() {
        _info = _warn = _error = 0;
    }
}
