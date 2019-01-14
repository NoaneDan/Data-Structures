package com.personal.projects.queue.implementation;

import com.personal.projects.queue.Queue;

public class CircularBuffer<T> implements Queue<T> {


    private Object[] buffer;
    private int capacity;
    private int size;
    private int read;
    private int write;

    public CircularBuffer(int capacity) {

        if (capacity <= 0) {
            throw new IllegalArgumentException("Buffer capacity must be greater than 0!");
        }

        this.buffer = new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
        this.read = 0;
        this.write = 0;
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

        return size == capacity;
    }

    @Override
    public void enqueue(T item) {

        if (full()) {
            throw new IllegalStateException("Buffer is full!");
        }

        if (write == capacity) {
            write = 0;
        }

        buffer[write] = item;
        write = (write + 1) % capacity;
        size++;
    }

    @Override
    public T dequeue() {

        if (empty()) {
            throw new IllegalStateException("Buffer is empty!");
        }

        T item = (T) buffer[read];
        read = (read + 1) % capacity;
        size++;

        return item;
    }

    @Override
    public T peek() {

        if (empty()) {
            throw new IllegalStateException("Buffer is empty!");
        }

        return (T) buffer[read];
    }
}