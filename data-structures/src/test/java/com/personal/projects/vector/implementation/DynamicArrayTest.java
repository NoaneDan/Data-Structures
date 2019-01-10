package com.personal.projects.vector.implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.personal.projects.vector.Array;

import org.junit.Test;

public class DynamicArrayTest {

    @Test
    public void testCreate() {

        Array<Integer> array = new DynamicArray<>();

        assertEquals(0, array.size());
        assertEquals(16, array.capacity());
        assertTrue(array.empty());
    }

    @Test
    public void testPush() {

        Array<Integer> array = new DynamicArray<>();

        array.push(10);
        assertEquals(1, array.size());
        assertEquals(16, array.capacity());
        assertEquals(10, (int) array.at(0));

        array.push(9);
        assertEquals(2, array.size());
        assertEquals(16, array.capacity());
        assertEquals(9, (int) array.at(1));

        for (int index = 0; index < 15; ++index) {
            array.push(index);
        }
        assertEquals(17, array.size());
        assertEquals(32, array.capacity());
        for (int index = 2; index < array.size(); ++index) {
            assertEquals(index - 2, (int) array.at(index));
        }
    }

    @Test
    public void testPrepend() {

        Array<Integer> array = new DynamicArray<>();

        array.prepend(10);
        assertEquals(1, array.size());
        assertEquals(16, array.capacity());
        assertEquals(10, (int) array.at(0));

        array.prepend(9);
        assertEquals(2, array.size());
        assertEquals(16, array.capacity());
        assertEquals(9, (int) array.at(0));

        for (int index = 0; index < 15; ++index) {
            array.prepend(index);
        }
        assertEquals(17, array.size());
        assertEquals(32, array.capacity());
    }

    @Test
    public void testInsert() {

        Array<Integer> array = new DynamicArray<>();

        array.insert(0, 10);
        assertEquals(1, array.size());
        assertEquals(10, (int) array.at(0));

        array.insert(1, 9);
        assertEquals(9, (int) array.at(1));

        array.insert(1, 8);
        assertEquals(10, (int) array.at(0));
        assertEquals(8, (int) array.at(1));
        assertEquals(9, (int) array.at(2));

        for (int index = 0; index < 15; ++index) {
            array.insert(index, index);
        }
        assertEquals(18, array.size());
        assertEquals(32, array.capacity());
    }

    @Test
    public void testPop() {

        Array<Integer> array = new DynamicArray<>();

        array.push(10);
        assertEquals(10, (int) array.pop());
        assertEquals(0, array.size());

        array.push(9);
        array.push(8);
        assertEquals(8, (int) array.pop());
        assertEquals(9, (int) array.pop());

        try {
            array.pop();
            assertFalse(false);
        }
        catch (IllegalStateException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testDelete() {

        Array<Integer> array = new DynamicArray<>();

        array.push(10);
        array.push(9);
        array.push(8);

        array.delete(1);
        assertEquals(2, array.size());
        assertEquals(10, (int) array.at(0));
        assertEquals(8, (int) array.at(1));

        try {
            array.delete(2);
            assertFalse(false);
        }
        catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testRemove() {

        Array<Integer> array = new DynamicArray<>();

        array.push(10);
        array.remove(9);
        assertEquals(1, array.size());
        assertEquals(10, (int) array.at(0));

        array.push(9);
        array.push(9);
        array.remove(9);
        assertEquals(1, array.size());
        assertEquals(10, (int) array.at(0));
    }

    @Test
    public void testFind() {

        Array<Integer> array = new DynamicArray<>();

        assertEquals(-1, array.find(10));
        assertEquals(0, array.size());

        for (int i = 0; i < 5; ++i) {
            array.push(i);
        }
        for (int i = 0; i < 5; ++i) {
            array.push(i);
        }
        assertEquals(2, array.find(2));
        assertEquals(-1, array.find(5));
    }
}