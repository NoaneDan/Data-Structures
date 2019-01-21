package com.personal.projects.heap.implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.personal.projects.heap.Heap;

import org.junit.Before;
import org.junit.Test;

public class BinaryHeapTest {


    private Heap<Integer> heap;

    @Before
    public void setUp() {
        heap = new BinaryHeap<>();
    }

    @Test
    public void testCreate() {

        assertTrue(heap.empty());

        try {
            heap.getMax();
            assertFalse(false);
        }
        catch (IllegalStateException e) {
            assertTrue(true);
        }

        try {
            heap.extractMax();
            assertFalse(false);
        }
        catch (IllegalStateException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testInsertExtract() {

        heap.insert(10);
        heap.insert(9);

        assertEquals(10, (int) heap.getMax());
        assertEquals(10, (int) heap.extractMax());
        assertEquals(9, (int) heap.getMax());
        assertEquals(9, (int) heap.extractMax());

        try {
            heap.extractMax();
            assertFalse(false);
        }
        catch (IllegalStateException e) {
            assertTrue(true);
        }
    }
}