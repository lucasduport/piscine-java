package fr.epita.assistants.cinematheque;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.PrintStream;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Logger implements PropertyChangeListener {
    private PrintStream output;

    private String get_message(String propertyName) throws IllegalArgumentException
    {
        if (Objects.equals(propertyName, Stock.Operation.Add.toString()))
            return "An element has been added.";
        else if (Objects.equals(propertyName, Stock.Operation.Delete.toString()))
            return "An element has been removed.";
        else if (Objects.equals(propertyName, Stock.Operation.Sort.toString()))
            return "A sorting has occured.";

        throw new IllegalArgumentException();
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LocalDate n = LocalDate.now();
        System.out.println("[" + n.toString().replace(" ", "|") + "] "+ get_message(evt.toString()));
    }

    public Logger(PrintStream output) {
        this.output = output;
    }
}
