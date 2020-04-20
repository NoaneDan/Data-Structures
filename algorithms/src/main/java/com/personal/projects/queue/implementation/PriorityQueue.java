package com.personal.projects.queue.implementation;

import com.personal.projects.heap.Heap;
import com.personal.projects.heap.implementation.BinaryHeap;
import com.personal.projects.queue.Queue;

public class PriorityQueue<T extends Comparable<T>> implements Queue<T> {


    private Heap<T> heap;
    private int size;

    public PriorityQueue() {
        this.heap = new BinaryHeap<>();
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public boolean full() {
        return false;
    }

    @Override
    public void enqueue(T item) {
        heap.insert(item);
    }

    @Override
    public T dequeue() {
        return heap.extractMax();
    }

    @Override
    public T peek() {
        return heap.getMax();
    }
    
}