package fr.epita.assistants.exceptions;

public class InvalidMajorException extends Exception{
    public InvalidMajorException(String name)
    {
        super("InvalidMajorException: "+name);
    }
}
