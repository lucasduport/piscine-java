package fr.epita.assistants.throwback;

public class LongStringException extends StringException {
    public LongStringException(String message)
    {
        super("LongStringException: "+message);
    }
}
