package fr.epita.assistants.cinematheque;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.PrintStream;
import java.time.LocalDate;

public class Logger implements PropertyChangeListener {
    private PrintStream output;

    private String get_message(Stock.Operation o ) throws IllegalArgumentException
    {
        if (o ==  Stock.Operation.Add)
            return "An element has been added.";
        else if (o ==  Stock.Operation.Delete)
            return "An element has been removed.";
        else if (o ==  Stock.Operation.Sort)
            return "A sorting has occured.";

        throw new IllegalArgumentException();
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LocalDate n = LocalDate.now();
        Stock.Operation o = (Stock.Operation) evt.getNewValue();
        output.println("[" + n.toString().replace(" ", "|") + "] "+ get_message(o));
    }

    public Logger(PrintStream output) {
        this.output = output;
    }
}
