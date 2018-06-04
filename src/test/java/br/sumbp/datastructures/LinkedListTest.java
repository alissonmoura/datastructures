package br.sumbp.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void getTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(0);
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        assertEquals((Integer)2, linkedList.get(2));
    }

    @Test
    void sizeTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(0);
        linkedList.append(1);
        linkedList.append(2);
        assertEquals(3, linkedList.size());
    }

    @Test
    void getOutOfBoundsHighFailTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(0);
        linkedList.append(1);
        linkedList.append(2);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.get(3);
        });
    }

    @Test
    void getOutOfBoundsLowFailTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(0);
        linkedList.append(1);
        linkedList.append(2);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.get(-1);
        });
    }

    @Test
    void getOutOfBoundsHighPassTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(0);
        linkedList.append(1);
        linkedList.append(2);
        assertEquals((Integer)0, linkedList.get(0));
    }

    @Test
    void getOutOfBoundsLowPassTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(0);
        linkedList.append(1);
        linkedList.append(2);
        assertEquals((Integer)2, linkedList.get(2));
    }

    @Test
    void getByElementTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(0);
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        assertEquals((Integer)2, linkedList.get((Integer)2));
    }

    @Test
    void getByElementWhenNullTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(0);
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        assertEquals(null, linkedList.get((Integer)4));
    }

    @Test
    void removeAtTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(0);
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        assertEquals(4, linkedList.size());
        linkedList.remove(2);
        assertEquals(3, linkedList.size());
        assertEquals((Integer)3, linkedList.get(2));
    }

    @Test
    void removeAtFirstTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(0);
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        assertEquals(4, linkedList.size());
        linkedList.remove(0);
        assertEquals(3, linkedList.size());
        assertEquals((Integer)1, linkedList.get(0));
    }

    @Test
    void removeAtLastTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(0);
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        assertEquals(4, linkedList.size());
        linkedList.remove(linkedList.size() - 1);
        assertEquals(3, linkedList.size());
        assertEquals((Integer)2, linkedList.get(linkedList.size() - 1));
    }

    @Test
    void removeAtOneNodeTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(0);
        assertEquals(1, linkedList.size());
        linkedList.remove(linkedList.size() - 1);
        assertEquals(0, linkedList.size());
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.get(linkedList.size() - 1);
        });
    }
}