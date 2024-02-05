package fr.epita.assistants.linkedlist;
;
public class LinkedList<T extends Comparable<T>> {
    private Element first;
    /**
     * Initializes the list
     **/

    private class Element{
        public T _value;
        public Element _next;

        public Element(T value)
        {
            _next = null;
            _value = value;
        }
    }
    public LinkedList() {
        first = null;
    }

    /**
     * Inserts the specified element into the list.
     * The elements must be sorted in ascending order.
     * null elements should be at the end of the list.
     *
     * @param e Element to be inserted
     **/
    public void insert(T elt) {
        if (first == null) {
            first = new Element(elt);
            return;
        }
        Element newElt = new Element(elt);
        Element i = first;
        if (elt.compareTo(first._value) < 0) {
            newElt._next = first;
            first = newElt;
            return;
        }
        for (; i._next != null && (elt==null || elt.compareTo(i._value) > 0); i = i._next) {
            continue;
        }

        newElt._next = i._next;
        i._next = newElt;
    }

    /**
     * Returns the n-th element in the list.
     *
     * @param i Index
     * @return The element at the given index
     * @throws IndexOutOfBoundsException if there is no element at this
     *                                   index.
     **/
    public T get(int i) throws IndexOutOfBoundsException{
        int j = 0;
        Element k = first;
        for ( ; j < i && k != null; k = k._next)
            j++;
        if(k != null)
            return k._value;
        throw new IndexOutOfBoundsException("");
    }

    /**
     * Removes the first occurrence of the specified element in the list.
     *
     * @param e Element to remove
     * @return returns the element that has been removed or null
     **/
    public T remove(T elt) {
        Element k = first;
        if (k == null)
            return null;
        if (k._value == elt) {
            T tmp = first._value;
            first = first._next;
            return tmp;
        }
        for (; k._next != null && elt.compareTo(k._next._value) != 0; k = k._next)
        {
            continue;
        }
        if (k._next == null)
            return null;
        T ret = k._next._value;
        k._next = k._next._next;
        return ret;
    }

    /**
     * Returns the size of the list.
     *
     * @return Number of elements in the list
     **/
    public int size() {
        int j = 0;
        Element k = first;
        for ( ;k != null; k = k._next)
            j++;
        return j;
    }

    /**
     * Removes all elements from the list.
     **/
    public void clear() {
        first = null;
    }
}
