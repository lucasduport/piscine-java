package fr.epita.assistants.myset;

import java.util.ArrayList;

public class GenericSet<T extends Comparable<T>>
{
    private ArrayList<T> _base = new ArrayList<T>();
    public void insert(T i)
    {
        int j = 0;
        for (; j < _base.size() && i.compareTo(_base.get(j)) < 0; j++) {
            continue;
        }
        _base.add(j,i);

    }
    public void remove(T i)
    {
        _base.remove(i);
    }
    public boolean has(T i)
    {
        return _base.contains(i);
    }
    public boolean isEmpty()
    {
        return _base.isEmpty();
    }
    public T min()
    {
        return _base.get(0);
    }
    public T max()
    {
        return _base.get(_base.size() - 1);
    }
    public int size()
    {
        return _base.size();
    }
    public static <T extends Comparable<T>> GenericSet<T> intersection(GenericSet<T> a, GenericSet<T> b)
    {
        GenericSet<T> ret = new GenericSet();
        for (T v: a._base) {
            if (b.has(v))
                ret.insert(v);

        }
        return ret;
    }

    public static <T extends Comparable<T>> GenericSet<T>  union(GenericSet<T>  a, GenericSet<T>  b)
    {
        GenericSet<T>  ret = new GenericSet();
        for (T v: a._base) {
            ret.insert(v);
        }
        for (T v: b._base) {
            if (! ret.has(v))
                ret.insert(v);
        }
        return ret;
    }

}