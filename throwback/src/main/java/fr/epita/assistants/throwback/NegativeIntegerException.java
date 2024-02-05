package fr.epita.assistants.throwback;

public class NegativeIntegerException extends IntegerException{

    public NegativeIntegerException(int nb)
    {
        super("NegativeIntegerException: ", nb);
    }
}
