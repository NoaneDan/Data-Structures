package com.personal.projects.heap.implementation;

import com.personal.projects.heap.Heap;
import com.personal.projects.vector.Array;
import com.personal.projects.vector.implementation.DynamicArray;

public class BinaryHeap<T extends Comparable<T>> implements Heap<T> {


    private Array<T> heap;

    public BinaryHeap() {
        this.heap = new DynamicArray<>();
    }

    @Override
    public boolean empty() {
        return heap.empty();
    }

    @Override
    public T getMax() {

        if (empty()) {
            throw new IllegalStateException("Heap is empty!");
        }

        return heap.at(0);
    }

    @Override
    public void insert(T item) {

        heap.push(item);
        siftUp(heap.size() - 1);
    }

    @Override
    public T extractMax() {

        T max = getMax();

        if (heap.size() == 1) {
            heap.pop();
        }
        else {
            heap.set(0, heap.pop());
            siftDown(0);
        }

        return max;
    }

    @Override
    public void replace(T item) {

        if (empty()) {
            insert(item);
        }
        else {
            heap.set(0, item);
            siftDown(0);
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void siftUp(int index) {

        T temp;

        while (index > 1 && heap.at(parent(index)).compareTo(heap.at(index)) < 0) {
            temp = heap.at(parent(index));
            heap.set(parent(index), heap.at(index));
            heap.set(index, temp);

            index = parent(index);
        }
    }

    private void siftDown(int index) {

        int maxIndex = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < heap.size() && heap.at(left).compareTo(heap.at(maxIndex)) > 0) {
            maxIndex = left;
        }

        if (right < heap.size() && heap.at(right).compareTo(heap.at(maxIndex)) > 0) {
            maxIndex = right;
        }

        if (index != maxIndex) {
            T temp = heap.at(index);
            heap.set(index, heap.at(maxIndex));
            heap.set(maxIndex, temp);

            siftDown(maxIndex);
        }
    }
}