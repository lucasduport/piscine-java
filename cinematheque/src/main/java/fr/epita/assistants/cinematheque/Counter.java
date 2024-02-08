package fr.epita.assistants.cinematheque;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

public class Counter implements PropertyChangeListener {
    private int counter = 0;
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (Objects.equals(evt.getPropertyName(), Stock.Operation.Add.toString()))
            counter++;
        else if (Objects.equals(evt.getPropertyName(), Stock.Operation.Delete.toString()))
            counter--;
        else if (!Objects.equals(evt.getPropertyName(), Stock.Operation.Sort.toString()))
            throw new IllegalArgumentException("Invalid property change name");
    }

    public Counter() {
        counter = 0;
    }

    public int getCounter() {
        return counter;
    }
}
