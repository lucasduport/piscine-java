package fr.epita.assistants.myset;

import java.util.ArrayList;

public class IntegerSet
{
    private ArrayList<Integer> _base = new ArrayList<Integer>();
    public void insert(Integer i)
    {
        int j = 0;
        for (; j < _base.size() && i < _base.get(j) ; j++) {
            continue;
        }
        _base.add(j,i);

    }
    public void remove(Integer i)
    {
        _base.remove(i);
    }
    public boolean has(Integer i)
    {
        return _base.contains(i);
    }
    public boolean isEmpty()
    {
        return _base.isEmpty();
    }
    public Integer min()
    {
        return _base.get(0);
    }
    public Integer max()
    {
        return _base.get(_base.size() - 1);
    }
    public int size()
    {
        return _base.size();
    }
    public static IntegerSet intersection(IntegerSet a, IntegerSet b)
    {
        IntegerSet ret = new IntegerSet();
        for (Integer v: a._base) {
            if (b.has(v))
                ret.insert(v);

        }
        return ret;
    }
    public static IntegerSet union(IntegerSet a, IntegerSet b)
    {
        IntegerSet ret = new IntegerSet();
        for (Integer v: a._base) {
            ret.insert(v);
        }
        for (Integer v: b._base) {
            if (! ret.has(v))
                ret.insert(v);
        }
        return ret;
    }

}
