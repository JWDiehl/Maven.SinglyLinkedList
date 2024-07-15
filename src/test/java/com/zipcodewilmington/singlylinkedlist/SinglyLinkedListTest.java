package com.zipcodewilmington.singlylinkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by leon on 1/10/18.
 */

public class SinglyLinkedListTest {

    private SinglyLinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new SinglyLinkedList<>();
    }

    //add -- add an element to the list
    @Test
    public void testAddAndGet() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
    }

    //remove -- remove an element (specified by numeric index) from the list
    @Test
    public void testRemove() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(1);
        assertEquals(2, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(3), list.get(1));
    }

    //contains -- returns true if the element is in the list, false otherwise
    @Test
    public void testContains() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.contains(1));
        assertFalse(list.contains(88));
    }

    //find -- returns the element's index if it is in the list, -1 otherwise
    @Test
    public void testFind() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.find(2));
        assertEquals(-1, list.find(88));
    }

    //size -- returns the current size of the list
    @Test
    public void testSize() {
        assertEquals(0, list.size());

        list.add(1);
        assertEquals(1, list.size());

        list.add(2);
        list.add(3);
        assertEquals(3, list.size());

        list.remove(0);
        assertEquals(2, list.size());

        list.remove(1);
        assertEquals(1, list.size());
    }

    //get -- returns the element at the specified index
    @Test
    public void testGet() {
        list.add(88);
        list.add(89);
        list.add(90);

        assertEquals(Integer.valueOf(88), list.get(0));
        assertEquals(Integer.valueOf(89), list.get(1));
        assertEquals(Integer.valueOf(90), list.get(2));
    }

    //copy -- returns a new linked list containing the same values (look up deep versus shallow copy)
    @Test
    public void testCopy() {
        list.add(1);
        list.add(2);
        list.add(3);

        SinglyLinkedList<Integer> newList = list.copy();

        assertEquals(list.size(), newList.size());
        assertEquals(list.get(0), newList.get(0));
        assertEquals(list.get(1), newList.get(1));
        assertEquals(list.get(2), newList.get(2));

        //Ensure they are seperate instances
        assertNotSame(list, newList);
        assertNotSame(list.head, newList.head);

    }

    //sort -- sorts the list using your algorithm of choice.
    // You must perform the sorting yourself (no fair using someone else's library)
    @Test
    public void testSort() {
        list.add(88);
        list.add(21);
        list.add(55);
        list.add(2);
        list.add(91);

        list.sort();

        assertEquals(Integer.valueOf(2), list.get(0));
        assertEquals(Integer.valueOf(21), list.get(1));
        assertEquals(Integer.valueOf(55), list.get(2));
        assertEquals(Integer.valueOf(88), list.get(3));
        assertEquals(Integer.valueOf(91), list.get(4));
    }
}