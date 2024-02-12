package fr.epita.assistants.cinematheque;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Logger implements PropertyChangeListener {
    private PrintStream output;

    private String get_message(Stock.Operation o )
    {
        if (o ==  Stock.Operation.Add)
            return "An element has been added.";
        else if (o ==  Stock.Operation.Delete)
            return "An element has been removed.";
        return "A sorting has occured.";
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue().getClass() != Stock.Operation.class)
            throw new IllegalArgumentException();
        Stock.Operation o = (Stock.Operation) evt.getNewValue();
        String pattern = "dd/MM/yyyy|HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        output.println("[" + date + "] "+ get_message(o));
    }

    public Logger(PrintStream output) {
        this.output = output;
    }
}
