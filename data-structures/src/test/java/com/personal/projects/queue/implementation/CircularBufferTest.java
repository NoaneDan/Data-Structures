package com.personal.projects.queue.implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.personal.projects.queue.Queue;

import org.junit.Before;
import org.junit.Test;

public class CircularBufferTest {


    private Queue<Integer> buffer;

    @Before
    public void setUp() {
        buffer = new CircularBuffer<>(5);
    }

    @Test
    public void testCreate() {
        
        assertEquals(0, buffer.size());
        assertTrue(buffer.empty());
        assertFalse(buffer.full());
    }

    @Test
    public void testOperations() {

        for (int index = 0; index < 5; ++index) {
            buffer.enqueue(index);
        }

        assertEquals(5, buffer.size());
        assertFalse(buffer.empty());
        assertTrue(buffer.full());
        
        assertEquals(0, (int) buffer.dequeue());
        assertEquals(1, (int) buffer.dequeue());
        assertFalse(buffer.empty());
        assertFalse(buffer.full());

        buffer.enqueue(5);
        buffer.enqueue(6);

        for (int index = 2; index < 5; ++index) {
            assertEquals(index, (int) buffer.dequeue());
        }

        buffer.enqueue(7);
        assertEquals(5, (int) buffer.dequeue());
        assertEquals(6, (int) buffer.dequeue());
        assertEquals(7, (int) buffer.dequeue());
    }
}