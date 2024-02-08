package fr.epita.assistants.cinematheque;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

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
        String pattern = "dd/MM/yyyy HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        output.println("[" + date + "] "+ get_message(o));
    }

    public Logger(PrintStream output) {
        this.output = output;
    }
}
