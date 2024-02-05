package fr.epita.assistants.myset;

import java.util.ArrayList;

public class IntegerSet
{
    private ArrayList<Integer> base_ = new ArrayList<Integer>();
    public void insert(Integer i)
    {
        int j = 0;
        for (; j < base_.size() && i > base_.get(j) ; j++) {
            continue;
        }
        base_.add(j,i);

    }
    public void remove(Integer i)
    {
        base_.remove(i);
    }
    public boolean has(Integer i)
    {
        return base_.contains(i);
    }
    public boolean isEmpty()
    {
        return base_.isEmpty();
    }
    public Integer min()
    {
        return base_.get(0);
    }
    public Integer max()
    {
        return base_.get(base_.size() - 1);
    }
    public int size()
    {
        return base_.size();
    }
    public static IntegerSet intersection(IntegerSet a, IntegerSet b)
    {
        IntegerSet ret = new IntegerSet();
        for (Integer v: a.base_) {
            if (b.has(v))
                ret.insert(v);

        }
        return ret;
    }
    public static IntegerSet union(IntegerSet a, IntegerSet b)
    {
        IntegerSet ret = new IntegerSet();
        for (Integer v: a.base_) {
            ret.insert(v);
        }
        for (Integer v: b.base_) {
            if (! ret.has(v))
                ret.insert(v);
        }
        return ret;
    }

}
