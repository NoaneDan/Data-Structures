package com.personal.projects.vector;

public interface Array<T> {

    int size();
    int capacity();
    boolean empty();
    T at(int index);
    void set(int index, T item);
    void push(T item);
    void insert(int index, T item);
    void prepend(T item);
    T pop();
    void delete(int index);
    void remove(T item);
    int find(T item);
}