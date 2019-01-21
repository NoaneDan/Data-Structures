package com.personal.projects.heap;

public interface Heap<T extends Comparable<T>> {

    boolean empty();
    T getMax();
    void insert(T item);
    T extractMax();
    void replace(T item);
}