package fr.epita.assistants.throwback;

public class Pitcher {
    public static void throwException(String message) throws
            LongStringException, ShortStringException,
            PositiveIntegerException, NegativeIntegerException,
            UnknownException
    {

            if (message.matches("-[0-9]*"))
                throw new NegativeIntegerException(message);
            else if (message.matches("[0-9]*"))
                throw new PositiveIntegerException(message);
            else if (!message.matches("[A-Za-z ,.']*"))
                throw new UnknownException(message);
            else if (message.length() >= 100)
                throw new LongStringException(message);
            else
                throw new ShortStringException(message);
    }
}
