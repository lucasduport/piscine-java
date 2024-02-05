package fr.epita.assistants.singleton;

import fr.epita.assistants.logger.Logger;

public enum SingletonEnumLogger implements Logger {
    INSTANCE;
    private int _info;
    private int _warn;
    private int _error;
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
