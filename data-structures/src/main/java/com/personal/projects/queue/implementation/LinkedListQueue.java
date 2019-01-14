package com.personal.projects.queue.implementation;

import com.personal.projects.list.List;
import com.personal.projects.list.implementation.DoublyLinkedList;
import com.personal.projects.queue.Queue;

public class LinkedListQueue<T> implements Queue<T> {

    List<T> queue;

    public LinkedListQueue() {
        this.queue = new DoublyLinkedList<>();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean empty() {
        return queue.empty();
    }

    @Override
    public boolean full() {
        return false;
    }

    @Override
    public void enqueue(T item) {
        queue.pushBack(item);
    }

    @Override
    public T dequeue() {
        return queue.popFront();
    }

    @Override
    public T peek() {
        return queue.front();
    }
}