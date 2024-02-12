package fr.epita.assistants.cinematheque;

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
        List<T> s = new ArrayList<>();
        items.forEach(
                i -> {
                    if (s.contains(i))
                        throw new IllegalArgumentException();
                    s.add(i);
                }
        );
        this.items = s;
    }

    @Override
    public boolean add(T t) {
        if (t == null ||  items.contains(t) )
            return false;
        items.add(t);
        this.property.firePropertyChange("Operation", null, Operation.Add);
        return true;
    }

    @Override
    public boolean remove(T t) {
        if (!items.remove(t))
            return false;
        this.property.firePropertyChange("Operation", null, Operation.Delete);
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
        if (cmp == null)
            return false;
        List<T> save ;
        try {
            save = items
                    .stream()
                    .sorted(
                            cmp
                    ).toList();
        }
        catch (Exception e) {
            return false;
        }
        boolean changed = false;
        for (int i = 0; i < save.size() ; i++) {
            if (!items.get(i).equals(save.get(i))) {
                changed = true;
                break;
            }
        }
        if (changed)
        {
            this.property.firePropertyChange("Operation", null, "heyt");
            this.items = save;
        }
        return changed;
    }

    @Override
    public Stock<T> filter(Predicate<? super T> p) {
        if (p == null)
            throw new IllegalArgumentException();
        List<T> save = items
                .stream()
                .filter(p)
                .toList();
        return new ListStock<>(save);
    }
}