package com.personal.projects.minstack;

import org.junit.Assert;
import org.junit.Test;

public class MinStackTest {

    @Test
    public void testCreate() {
        MinStack<Integer> minStack = new MinStack<>();

        Assert.assertEquals(0, minStack.size());
        Assert.assertTrue(minStack.empty());
    }

    @Test
    public void testSizeAndEmpty() {
        MinStack<Integer> minStack = new MinStack<>();

        minStack.push(1);
        Assert.assertEquals(1, minStack.size());
        Assert.assertFalse(minStack.empty());

        minStack.push(3);
        Assert.assertEquals(2, minStack.size());
        Assert.assertFalse(minStack.empty());
    }

    @Test
    public void testPush() {
        MinStack<Integer> minStack = new MinStack<>();

        minStack.push(1);
        Assert.assertEquals(1, (int) minStack.top());
        Assert.assertEquals(1, (int) minStack.getMin());

        minStack.push(2);
        Assert.assertEquals(2, (int) minStack.top());
        Assert.assertEquals(1, (int) minStack.getMin());

        minStack.push(-10);
        Assert.assertEquals(-10, (int) minStack.top());
        Assert.assertEquals(-10, (int) minStack.getMin());
    }

    @Test
    public void testPop() {
        MinStack<Integer> minStack = new MinStack<>();

        try {
            minStack.pop();
            Assert.fail("should have thrown error");
        } catch (IllegalStateException e) {
            Assert.assertTrue("must throw exception", true);
        }

        minStack.push(1);
        Assert.assertEquals(1, (int) minStack.pop());
        Assert.assertEquals(0, minStack.size());
        Assert.assertTrue(minStack.empty());

        minStack.push(1);
        minStack.push(-1);
        minStack.push(4);
        minStack.push(-10);

        Assert.assertEquals(-10, (int) minStack.pop());
        Assert.assertEquals(-1, (int) minStack.getMin());
        Assert.assertEquals(4, (int) minStack.top());

        Assert.assertEquals(4, (int) minStack.pop());
        Assert.assertEquals(-1, (int) minStack.getMin());
        Assert.assertEquals(-1, (int) minStack.top());
    }
}
