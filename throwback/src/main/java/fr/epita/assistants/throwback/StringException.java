package fr.epita.assistants.throwback;

public class StringException extends Exception{
    public StringException(String message)
    {
        super("StringException: " + message + " (length: "+ message.length() + ")");
    }
}
