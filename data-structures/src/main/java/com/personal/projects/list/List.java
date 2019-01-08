package com.personal.projects.list;

public interface List<T> {

    int size();
    boolean empty();
    
    T valueAt(int index);
    T nthValueFromEnd(int nth);
    
    void pushFront(T value);
    T popFront();

    void pushBack(T value);
    T popBack();

    T front();
    T back();

    void insert(int index, T value);
    void erase(int index);
    
    void reverse();

    void removeValue(T value);
}