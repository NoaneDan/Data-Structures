package com.personal.projects.stack.implementation;

import com.personal.projects.list.List;
import com.personal.projects.list.implementation.DoublyLinkedList;
import com.personal.projects.stack.Stack;

public class LinkedListStack<T> implements Stack<T> {

    private List<T> stack;

    public LinkedListStack() {
        this.stack = new DoublyLinkedList<>();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public boolean empty() {
        return stack.empty();
    }

    @Override
    public boolean full() {
        return false;
    }

    @Override
    public void push(T item) {
        stack.pushBack(item);
    }

    @Override
    public T pop() {
        return stack.popBack();
    }

    @Override
    public T top() {
        return stack.back();
    }
}