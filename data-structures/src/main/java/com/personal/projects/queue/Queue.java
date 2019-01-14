package com.personal.projects.queue;

public interface Queue<T> {

    int size();
    boolean empty();
    boolean full();
    void enqueue(T item);
    T dequeue();
    T peek();
}