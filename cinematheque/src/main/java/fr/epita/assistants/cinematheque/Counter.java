package fr.epita.assistants.cinematheque;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

public class Counter implements PropertyChangeListener {
    private int count = 0;
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Stock.Operation o = (Stock.Operation)  evt.getNewValue();
        if (o ==  Stock.Operation.Add)
            count++;
        else if (o ==  Stock.Operation.Delete)
            count--;
        else if (o !=  Stock.Operation.Sort)
            throw new IllegalArgumentException("Invalid property change name");
    }

    public Counter() {
        count = 0;
    }

    public int getCount() {
        return count;
    }
}
