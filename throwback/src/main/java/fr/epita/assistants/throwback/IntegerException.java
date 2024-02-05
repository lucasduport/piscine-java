package fr.epita.assistants.throwback;

public class IntegerException extends Exception{
    public IntegerException(String message, int nb)
    {
        super("IntegerException: " + message + nb);
    }
}
