package com.personal.projects.vector.implementation;

import com.personal.projects.vector.Array;

public class DynamicArray<T> implements Array<T> {

    private int size;
    private int capacity;
    private Object[] array;

    public DynamicArray() {

        this.size = 0;
        this.capacity = 16;
        this.array = new Object[this.capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public T at(int index) {

        if (indexOutOfRange(index)) {
            throw new IndexOutOfBoundsException("Index out of range!");
        }

        return (T) array[index];
    }

    @Override
    public void push(T item) {

        resize();
        array[size++] = item;
    }

    @Override
    public void insert(int index, T item) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        resize();
        shiftRight(index);

        array[index] = item;
        size++;
    }

    @Override
    public void prepend(T item) {
        insert(0, item);
    }

    @Override
    public T pop() {

        if (empty()) {
            throw new IllegalStateException("Array is empty!");
        }

        T item = (T) array[size - 1];
        size--;

        resize();

        return item;
    }

    @Override
    public void delete(int index) {

        if (indexOutOfRange(index)) {
            throw new IndexOutOfBoundsException("Index out of range!");
        }

        shiftLeft(index);
        --size;
        resize();
    }

    @Override
    public void remove(T item) {

        for (int index = size - 1; index >= 0; --index) {
            if (((T) array[index]).equals(item)) {
                shiftLeft(index);
                size--;
            }
        }

        resize();
    }

    @Override
    public int find(T item) {

        int position = -1;
        boolean found = false;

        for (int index = 0; index < size && !found; ++index) {
            if (((T) array[index]).equals(item)) {
                position = index;
                found = true;
            }
        }

        return position;
    }

    private boolean indexOutOfRange(int index) {
        return index < 0 || index >= size;
    }

    private void resize() {

        if (size == capacity) {
            this.capacity *= 2;
            createNewArray();
        }
        else if (size > 4 && size <= capacity / 4) {
            this.capacity /= 4;
            createNewArray();
        }
    }

    private void createNewArray() {

        Object[] newArray = new Object[this.capacity];

        for (int index = 0; index < size; ++index) {
            newArray[index] = array[index];
        }

        this.array = newArray;
    }

    private void shiftRight(int index) {

        for (int position = size; position > index; --position) {
            array[position] = array[position - 1];
        }
    }

    private void shiftLeft(int index) {

        for (int position = index; position < size - 1; ++position) {
            array[position] = array[position + 1];
        }
    }

    @Override
    public void set(int index, T item) {

        if (indexOutOfRange(index)) {
            throw new IndexOutOfBoundsException("Index out of range!");
        }

        array[index] = item;
    }
}