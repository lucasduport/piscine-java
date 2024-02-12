package fr.epita.assistants.cinematheque;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

public class Counter implements PropertyChangeListener {
    private int count = 0;
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (!Objects.equals(evt.getPropertyName(), "Operation") || evt.getNewValue() == null || evt.getNewValue().getClass() != Stock.Operation.class)
            throw new IllegalArgumentException("Invalid property change name");
        if (evt.getNewValue() == Stock.Operation.Add)
            count++;
        else if (evt.getNewValue() == Stock.Operation.Delete)
            count--;
        else if (evt.getNewValue() != Stock.Operation.Sort)
            throw new IllegalArgumentException("Invalid property change name");
    }

    public Counter() {
        count = 0;
    }

    public int getCount() {
        return count;
    }
}
