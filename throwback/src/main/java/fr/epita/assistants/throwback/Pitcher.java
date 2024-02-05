package fr.epita.assistants.throwback;

public class Pitcher {
    public static void throwException(String message) throws
            LongStringException, ShortStringException,
            PositiveIntegerException, NegativeIntegerException,
            UnknownException
    {
        try
        {
            int a = Integer.parseInt(message);
            if ( a >= 0)
                throw new PositiveIntegerException(a);
            else
                throw new NegativeIntegerException(a);
        }
        catch (NumberFormatException e
        )
        {
            if (!message.matches("[A-Za-z ,.']*"))
                throw new UnknownException();
            else if (message.length() >= 100)
                throw new LongStringException(message);
            else
                throw new ShortStringException(message);
        }
    }
}
