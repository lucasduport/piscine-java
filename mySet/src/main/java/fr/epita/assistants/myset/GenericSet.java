package fr.epita.assistants.myset;

import java.util.ArrayList;

public class GenericSet<T extends Comparable<T>>
{
    private ArrayList<T> base_ = new ArrayList<T>();
    public void insert(T i)
    {
        int j = 0;
        for (; j < base_.size() && i.compareTo(base_.get(j)) > 0; j++) {
            continue;
        }
        base_.add(j,i);

    }
    public void remove(T i)
    {
        base_.remove(i);
    }
    public boolean has(T i)
    {
        return base_.contains(i);
    }
    public boolean isEmpty()
    {
        return base_.isEmpty();
    }
    public T min()
    {
        return base_.get(0);
    }
    public T max()
    {
        return base_.get(base_.size() - 1);
    }
    public int size()
    {
        return base_.size();
    }
    public static <T extends Comparable<T>> GenericSet<T> intersection(GenericSet<T> a, GenericSet<T> b)
    {
        GenericSet<T> ret = new GenericSet();
        for (T v: a.base_) {
            if (b.has(v))
                ret.insert(v);

        }
        return ret;
    }

    public static <T extends Comparable<T>> GenericSet<T>  union(GenericSet<T>  a, GenericSet<T>  b)
    {
        GenericSet<T>  ret = new GenericSet();
        for (T v: a.base_) {
            ret.insert(v);
        }
        for (T v: b.base_) {
            if (! ret.has(v))
                ret.insert(v);
        }
        return ret;
    }

}