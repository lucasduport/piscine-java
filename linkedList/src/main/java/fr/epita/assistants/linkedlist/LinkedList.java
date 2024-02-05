package fr.epita.assistants.linkedlist;

import java.util.List;

public class LinkedList<T extends Comparable<T>> {
    private List<T> list;
    /**
     * Initializes the list
     **/
    public LinkedList() {
        list = new java.util.LinkedList<>();
    }

    /**
     * Inserts the specified element into the list.
     * The elements must be sorted in ascending order.
     * null elements should be at the end of the list.
     *
     * @param e Element to be inserted
     **/
    public void insert(T elt) {
        if (elt == null)
        {
            list.add(null);
            return;
        }

        boolean added = false;
        for (int i = 0; i < list.size(); i++) {
            if (elt.compareTo(list.get(i)) > 0) {
                list.add(i, elt);
                added = true;
                break;
            }
        }
        if (!added)
            list.add(elt);
    }

    /**
     * Returns the n-th element in the list.
     *
     * @param i Index
     * @return The element at the given index
     * @throws IndexOutOfBoundsException if there is no element at this
     *                                   index.
     **/
    public T get(int i) {
        return list.get(i);
    }

    /**
     * Removes the first occurrence of the specified element in the list.
     *
     * @param e Element to remove
     * @return returns the element that has been removed or null
     **/
    public T remove(T elt) {
        if(list.remove(elt))
            return elt;
        return null;
    }

    /**
     * Returns the size of the list.
     *
     * @return Number of elements in the list
     **/
    public int size() {
        return list.size();
    }

    /**
     * Removes all elements from the list.
     **/
    public void clear() {
        list.clear();
    }
}
