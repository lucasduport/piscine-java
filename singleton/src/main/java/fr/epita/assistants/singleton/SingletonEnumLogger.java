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
            this._error++;
        else if(level == Level.WARN)
            this._warn++;
        else if(level == Level.INFO)
            this._info++;
        System.err.println(Logger.getFormattedLog(level, message));
    }

    @Override
    public int getInfoCounter() {
        return this._info;
    }

    @Override
    public int getWarnCounter() {
        return this._warn;
    }

    @Override
    public int getErrorCounter() {
        return this._error;
    }

    @Override
    public void reset() {
        this._info = this._warn = this._error = 0;
    }
}
