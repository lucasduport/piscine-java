package fr.epita.assistants.throwback;

public class NegativeIntegerException extends IntegerException{

    public NegativeIntegerException(String msg)
    {
        super("NegativeIntegerException: " + msg);
    }
}
