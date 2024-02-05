package fr.epita.assistants.throwback;

public class PositiveIntegerException extends IntegerException {
    public PositiveIntegerException(int nb)
    {
        super("PositiveIntegerException: ", nb);
    }
}
