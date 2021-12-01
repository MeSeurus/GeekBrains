package com.geekbrains;

//2. Создать класс для реализации дека.

public class MyDeque<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;


    public MyDeque(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        list = (T[]) new Object[capacity];
    }

    public MyDeque() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    private int previousIndex(int index) {
        return (list.length + index - 1) % list.length;
    }

    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insertLeft(T item) {
        if (isFull()) {
            throw new RuntimeException("deque is full");
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public void insertRight(T item){
        if (isFull()) {
            throw new RuntimeException("deque is full");
        }
        size++;
        begin = previousIndex(begin);
        list[begin] = item;
    }

    public T removeLeft() {
        T item = checkLeft();
        size--;
        end = previousIndex(end);
        list[end] = null;
        return item;
    }

    public T removeRight() {
        T item = checkRight();
        size--;
        list[begin] = null;
        begin = nextIndex(end);
        return item;
    }

    public T checkLeft() {
        if (isEmpty()) {
            throw new RuntimeException("deque queue is empty");
        }
        return list[previousIndex(end)];
    }

    public T checkRight() {
        if (isEmpty()) {
            throw new RuntimeException("deque queue is empty");
        }
        return list[begin];
    }
}
