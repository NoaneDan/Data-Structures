package com.personal.projects.list.implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.personal.projects.list.List;

import org.junit.Test;

public class DoublyLinkedListTest {

    @Test
    public void testCreate() {

        List<Integer> list = new DoublyLinkedList<>();

        assertEquals(0, list.size());
        assertTrue(list.empty());
    }

    @Test
    public void testPushPopFront() {

        List<Integer> list = new DoublyLinkedList<>();

        list.pushFront(10);
        assertEquals(1, list.size());
        assertFalse(list.empty());
        assertEquals(10, (int) list.valueAt(0));

        list.pushFront(9);
        assertEquals(2, list.size());
        assertEquals(9, (int) list.valueAt(0));
        assertEquals(10, (int) list.valueAt(1));

        int value = list.popFront();
        assertEquals(9, value);
        assertEquals(1, list.size());
        assertEquals(10, (int) list.valueAt(0));

        value = list.popFront();
        assertEquals(10, value);
        assertEquals(0, list.size());
        try {
            list.valueAt(0);
        }
        catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testPushPopBack() {

        List<Integer> list = new DoublyLinkedList<>();

        list.pushBack(10);
        assertEquals(1, list.size());
        assertFalse(list.empty());
        assertEquals(10, (int) list.valueAt(0));

        list.pushBack(9);
        assertEquals(2, list.size());
        assertEquals(10, (int) list.valueAt(0));
        assertEquals(9, (int) list.valueAt(1));

        int value = list.popBack();
        assertEquals(9, value);
        assertEquals(1, list.size());
        assertEquals(10, (int) list.valueAt(0));

        value = list.popBack();
        assertEquals(10, value);
        assertEquals(0, list.size());
        try {
            list.valueAt(0);
        }
        catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testFrontBack() {

        List<Integer> list = new DoublyLinkedList<>();

        list.pushBack(10);
        assertEquals(10, (int) list.front());
        assertEquals(10, (int) list.back());

        list.pushBack(9);
        assertEquals(10, (int) list.front());
        assertEquals(9, (int) list.back());

        list.pushFront(8);
        assertEquals(8, (int) list.front());
        assertEquals(9, (int) list.back());
    }

    @Test
    public void testInsertErase() {

        List<Integer> list = new DoublyLinkedList<>();

        list.insert(0, 10);
        assertEquals(1, list.size());
        assertEquals(10, (int) list.valueAt(0));

        list.insert(1, 9);
        assertEquals(2, list.size());
        assertEquals(9, (int) list.valueAt(1));
        assertEquals(10, (int) list.front());
        assertEquals(9, (int) list.back());

        list.insert(1, 8);
        assertEquals(3, list.size());
        assertEquals(8, (int) list.valueAt(1));
        assertEquals(10, (int) list.front());
        assertEquals(9, (int) list.back());

        list.insert(1, 7);
        list.erase(2);
        assertEquals(3, list.size());
        assertEquals(10, (int) list.front());
        assertEquals(9, (int) list.back());

        list.erase(0);
        assertEquals(2, list.size());
        assertEquals(7, (int) list.front());
        assertEquals(9, (int) list.back());
        
        list.erase(0);
        assertEquals(1, list.size());
        assertEquals(9, (int) list.valueAt(0));
    }

    @Test
    public void testNthValueFromEnd() {

        List<Integer> list = new DoublyLinkedList<>();

        list.pushBack(10);
        assertEquals(10, (int) list.nthValueFromEnd(1));

        list.pushBack(9);
        assertEquals(9, (int) list.nthValueFromEnd(1));
        assertEquals(10, (int) list.nthValueFromEnd(2));

        try {
            list.nthValueFromEnd(10);
        }
        catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testReverse() {

        List<Integer> list = new DoublyLinkedList<>();

        list.pushBack(10);
        list.reverse();
        assertEquals(1, list.size());
        assertEquals(10, (int) list.front());
        assertEquals(10, (int) list.back());

        list.pushBack(9);
        list.pushBack(8);
        list.pushBack(7);
        list.reverse();
        assertEquals(7, (int) list.valueAt(0));
        assertEquals(8, (int) list.valueAt(1));
        assertEquals(9, (int) list.valueAt(2));
        assertEquals(10, (int) list.valueAt(3));
        assertEquals(7, (int) list.front());
        assertEquals(10, (int) list.back());
    }

    @Test
    public void testRemoveValue() {

        List<Integer> list = new DoublyLinkedList<>();

        list.pushBack(10);
        list.pushBack(9);
        list.pushBack(8);
        list.removeValue(9);
        assertEquals(2, list.size());
        assertEquals(10, (int) list.front());
        assertEquals(8, (int) list.back());
        assertEquals(8, (int) list.valueAt(1));

        list.removeValue(8);
        assertEquals(10, (int) list.front());
        assertEquals(10, (int) list.back());
    }
}