package fr.epita.assistants.cinematheque;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListStock<T> extends Stock<T>{
    private List<T> items;
    public ListStock()
    {
        items = new ArrayList<>();
    }
    public ListStock(List<T> items)
    {
        for (int i = 0; i < items.size(); i++) {
            for (int j = 0; j < items.size(); j++) {
                if (j != i)
                {
                    if (items.get(i).equals(j))
                        throw new IllegalArgumentException();
                }
            }
        }
        this.items = items;
    }
    @Override
    public boolean add(T t) {
        this.property.firePropertyChange(String.valueOf(Operation.Add), this.items, t);
        return items.add(t);
    }

    @Override
    public boolean remove(T t) {
        List<T> save = items.subList(0, items.size());
        if (items.remove(t))
            return false;
        this.property.firePropertyChange(String.valueOf(Operation.Delete), save, this.items);
        return true;
    }

    @Override
    public boolean contains(T t) {
        return items.contains(t);
    }

    @Override
    public Collection<? extends T> list() {
        return items;
    }

    @Override
    public boolean sort(Comparator<? super T> cmp) {
        List<T> save = items.subList(0, items.size());
        this.items = items
                .stream()
                .sorted(
                        cmp
        ).toList();
        boolean changed = false;
        for (int i = 0; i < save.size() ; i++) {
            if (!items.get(i).equals(save.get(i))) {
                changed = true;
                break;
            }
        }
        if (changed)
            this.property.firePropertyChange(String.valueOf(Operation.Sort), save, this.items);
        return changed;
    }

    @Override
    public Stock<T> filter(Predicate<? super T> p) {
        if (p == null)
            throw new IllegalArgumentException();
        List<T> save = items.subList(0, items.size());
        this.items = items
                .stream()
                .filter(p)
                .collect(Collectors.toList());
        if (this.items.size() != save.size())
            this.property.firePropertyChange(String.valueOf(Operation.Delete), save, this.items);
        return this;
    }

    public void addPropertyChangeListener(Operation op, PropertyChangeListener listener) {
        this.property.addPropertyChangeListener(String.valueOf(op), listener);
    }
}