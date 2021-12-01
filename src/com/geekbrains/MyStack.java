package com.geekbrains;

import java.util.EmptyStackException;

public class MyStack<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    //1. Создать программу, которая переворачивает вводимые строки (читает справа налево).
    public void reverse() {
        T[] tempArr = (T[]) new Object[list.length];
        for (int i = 0; i < size; i++) {
            tempArr[i] = list[list.length - 1 - i];
        }
        list = tempArr;
    }

    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        list = (T[]) new Object[capacity];
    }

    public MyStack() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }
    // 3*. Реализовать автоматическое увеличение размера массива в стеке
    public void push(T item) {
        if (isFull()) {
            T[] tempArr = (T[]) new Object[size + size/2];
            System.arraycopy(list, 0, tempArr, 0, size);
            list = tempArr;
        }
        list[size] = item;
        size++;
    }

    public T pop() {
        T temp = peek();
        size--;
        list[size] = null;
        return temp;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    private void reCapacity(int newCapacity) {
        T[] tempArr = (T[]) new Object[newCapacity];
        System.arraycopy(list, 0, tempArr, 0, size);
        list = tempArr;
    }
}
