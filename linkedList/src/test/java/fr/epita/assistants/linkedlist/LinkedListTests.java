package fr.epita.assistants.linkedlist;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTests {
    @Test
    @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testInsertOne() {
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(12);
        assertEquals(Integer.valueOf(12), list.get(0), "Invalid element");
    }

    @Test
    @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testGetFail() {
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(3);
        list.insert(5);
        list.insert(2);
        list.insert(5);
        list.insert(2);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(6));
    }

    @Test
    @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testRemoveNotPresent() {
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        assertNull(list.remove(12), "Invalid return value of remove()");
    }

    @Test
    @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void insertAndRemove() {
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        assertEquals(list.get(0), 1);
        assertEquals(list.get(2), 3);
        assertEquals(list.get(3), 4);

        list.remove(1);
        list.remove(2);
        list.remove(3);

        assertEquals(list.remove(4), 4);

        assertEquals(list.size(), 0);
    }
    // add your own tests here
}
