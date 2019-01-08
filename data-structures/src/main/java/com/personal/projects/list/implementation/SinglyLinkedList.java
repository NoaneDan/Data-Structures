package com.personal.projects.list.implementation;

import com.personal.projects.list.List;

public class SinglyLinkedList<T> implements List<T> {

    private class Node<S> {
        public S value;
        public Node<S> next;

        public Node(S value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SinglyLinkedList() {

        this.head = null;
        this.tail = null;
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
    public T valueAt(int index) {

        if (indexOutOfRange(index)) {
            throw new IllegalArgumentException("Index out of range!");
        }

        Node<T> current = head;
        
        int position = 0;
        while (position < index) {
            current = current.next;
            position += 1;
        }

        return current.value;
    }

    private boolean indexOutOfRange(int index) {
        return index < 0 || index >= size;
    }

    @Override
    public T nthValueFromEnd(int nth) {
        return valueAt(this.size - nth);
    }

    @Override
    public void pushFront(T value) {

        Node<T> node = new Node<>(value);

        if (size == 0) {
            tail = node;
        }

        node.next = head;
        head = node;

        size += 1;
    }

    @Override
    public T popFront() {

        if (empty()) {
            throw new IllegalStateException("List is empty!");
        }

        Node<T> node = head;

        head = head.next;
        if (size == 1) {
            tail = null;
        }

        size -= 1;

        return node.value;
    }

    @Override
    public void pushBack(T value) {
        
        Node<T> node = new Node<>(value);

        if (tail == null) {
            tail = node;
            head = node;
        }
        else {
            tail.next = node;
            tail = tail.next;
        }

        size += 1;
    }

    @Override
    public T popBack() {

        if (empty()) {
            throw new IllegalStateException("List is empty!");
        }
        
        Node<T> node = tail;
        if (size == 1) {
            tail = null;
            head = null;
        }
        else {
            Node<T> previous = findPrevious(tail);
            previous.next = null;
            tail = previous;
        }

        size -= 1;

        return node.value;
    }

    private Node<T> findPrevious(Node<T> node) {

        Node<T> current = head;
        
        while (current != null && current.next != node) {
            current = current.next;
        }

        return current;
    }

    @Override
    public T front() {

        if (empty()) {
            throw new IllegalStateException("List is empty!");
        }

        return head.value;
    }

    @Override
    public T back() {

        if (empty()) {
            throw new IllegalStateException("List is empty!");
        }

        return tail.value;
    }

    @Override
    public void insert(int index, T value) {

        if (index < 0) {
            throw new IllegalArgumentException("Index out of range!");
        }
        else if (index == 0) {
            pushFront(value);
        }
        else if (index >= size) {
            pushBack(value);
        }
        else {
            Node<T> node = new Node<>(value);

            int position = 0;
            Node<T> current = head;
            while (position + 1 < index) {
                current = current.next;
            }

            node.next = current.next;
            current.next = node;
            size += 1;
        }
    }

    @Override
    public void erase(int index) {

        if (indexOutOfRange(index)) {
            throw new IllegalArgumentException("Index is out of range!");
        }

        if (index == 0) {
            popFront();
        }
        else {
            int position = 0;
            Node<T> current = head;
            while (position + 1 < index) {
                current = current.next;
            }

            current.next = current.next.next;
            size -= 1;
        }
    }

    @Override
    public void reverse() {

        if (head == null) {
            return;
        }

        reverseList(head);

        Node<T> temp;
        temp = head;
        head = tail;
        tail = temp;
    }

    private Node<T> reverseList(Node<T> node) {

        if (node.next == null) {
            return node;
        }

        Node<T> reversedNode = reverseList(node.next);
        node.next = null;
        reversedNode.next = node;
        return node;
    }

    @Override
    public void removeValue(T value) {

        Node<T> current = head;
        boolean found = false;

        while (current != null && !found) {
            if (current.value == value) {
                Node<T> previous = findPrevious(current);
                previous.next = current.next;
                if (current == tail) {
                    tail = previous;
                }
                found = true;
                size -= 1;
            }

            current = current.next;
        }
    }
}