package com.personal.projects.list.implementation;

import com.personal.projects.list.List;

public class DoublyLinkedList<T> implements List<T> {


    private class Node<S> {
        public S value;
        public Node<S> prev;
        public Node<S> next;

        public Node(S value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {

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

        
        int position = 0;
        Node<T> current = head;
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

        if (indexOutOfRange(this.size - nth)) {
            throw new IllegalArgumentException("Index out of range!");
        }

        int index = 1;
        Node<T> current = tail;
        while (index < nth) {
            current = current.prev;
            index += 1;
        }

        return current.value;
    }

    @Override
    public void pushFront(T value) {

        Node<T> node = new Node<>(value);

        if (size == 0) {
            head = node;
            tail = node;
        }
        else {
            node.next = head;
            head.prev = node;
            head = node;
        }

        size += 1;
    }

    @Override
    public T popFront() {
        
        if (empty()) {
            throw new IllegalStateException("List is empty!");
        }

        Node<T> node = head;

        if (size == 1) {
            head = null;
            tail = null;
        }
        else {
            head.next.prev = null;
            head = head.next;
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
            node.prev = tail;
            tail = node;
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
            tail.prev.next = null;
            tail = tail.prev;
        }

        size -= 1;

        return node.value;
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

            current.next.prev = node;
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
                position += 1;
            }

            Node<T> deleted = current.next;

            if (deleted.next != null) {
                deleted.next.prev = current;
            }
            current.next = deleted.next;
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
        node.prev = reversedNode;
        return node;
    }

    @Override
    public void removeValue(T value) {

        Node<T> current = head;
        boolean found = false;

        while (current != null && !found) {
            if (current.value == value) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }

                if (current == tail) {
                    tail = current.prev;
                }
                
                found = true;
                size -= 1;
            }
            else {
                current = current.next;
            }
        }
    }

}