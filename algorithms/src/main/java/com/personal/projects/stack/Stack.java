package com.personal.projects.stack;

public interface Stack<T> {

    int size();
    boolean empty();
    boolean full();
    void push(T item);
    T pop();
    T top();
}