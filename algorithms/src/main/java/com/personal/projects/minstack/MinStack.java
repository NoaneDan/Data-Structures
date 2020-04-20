package com.personal.projects.minstack;

import com.personal.projects.list.List;
import com.personal.projects.list.implementation.SinglyLinkedList;
import com.personal.projects.pair.Pair;

public class MinStack<T extends Comparable<T>> {

    private final List<Pair<T, T>> stack;

    public MinStack() {
        this.stack = new SinglyLinkedList<>();
    }

    public int size() {
        return stack.size();
    }

    public boolean empty() {
        return stack.empty();
    }

    public T top() {
        return stack.front().getFirst();
    }

    public T getMin() {
        return stack.front().getSecond();
    }

    public void push(T item) {
        if (empty()) {
            stack.pushFront(new Pair<>(item, item));
        } else {
            T currentMin = getMin();
            stack.pushFront(new Pair<T, T>(item, min(item, currentMin)));
        }
    }

    public T pop() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty!");
        }

        return stack.popFront().getFirst();
    }

    private T min(T first, T second) {
        if (first.compareTo(second) > 0) {
            return second;
        }

        return first;
    }
}
