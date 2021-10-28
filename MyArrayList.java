package com.geekbrains;

import java.util.Arrays;

public class MyArrayList<T extends Comparable<T>> {
    private T[] list;
    public int size;
    private final int DEFAULT_CAPACITY = 10;

    public void copy100000(MyArrayList<T> tolist) {
        for (int i = 0; i < 100000; i++) {
            T key = list[i];
            tolist.add(key);
        }
    }

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity < 0 :" + capacity);
        }
        list = (T[]) new Comparable[capacity];
    }

    public MyArrayList() {
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    public void add(T item) {
        //проверить на переполнение.  при заполнении пересоздать внутренний массив
        // размером capacity *1.5 +1
        if (size == list.length) {
            list = Arrays.copyOf(list, list.length + list.length/2 + 1);
            System.out.println("Новый размер массива: " + list.length);
        }
        list[size] = item;
        size++;
    }

    public void add(int index, T item) {
        //проверить на переполнение.  при заполнении пересоздать внутренний массив
        // размером capacity *1.5 +1
        // проверить index
        if (list[index-1] == null) {
            throw new IllegalArgumentException("Элемент с данным индексом ещё не заведён");
        }
        if (size == list.length) {
            list = Arrays.copyOf(list, list.length + list.length/2 + 1);
            System.out.println("Новый размер массива: " + list.length);
        }
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
    }

    public final T delete(int index) {
        //проверить index
        if (list[index-1] == null || size < index) {
            throw new IllegalArgumentException("Элемент с данным индексом ещё не заведён");
        }
        T temp = list[index];
        if (size - index >= 0) {
            System.arraycopy(list, index + 1, list, index, size - index);
        }
        size--;
        return temp;
    }

    public boolean delete(T item) {
        int pos = index(item);
        if (pos < 0) {
            return false;
        }
        delete(pos);
        return true;
    }

    public T get(int index) {
        //проверить index
        if (list[index-1] == null || size < index) {
            throw new IllegalArgumentException("Элемент с данным индексом ещё не заведён");
        }
        return list[index];
    }

    public void set(int index, T item) {
        //проверить index
        if (list[index-1] == null || size < index) {
            throw new IllegalArgumentException("Элемент с данным индексом ещё не заведён");
        }
        list[index] = item;
    }

    public int indexOf(T item) {
        return index(item);
    }

    private int index(T item) {
        if (item == null) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (item.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }

    private boolean less(T item1, T item2) {
        return item1.compareTo(item2) < 0;
    }

    private void swap(int index1, int index2) {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    //O(n * n)
    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int iMin = i;
            for (int j = i; j < size; j++) {
                if (less(list[j], list[iMin])) {
                    iMin = j;
                }
            }
            swap(i, iMin);
        }
    }

    public void insertionSort() {
        T key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = list[i];
            while (j > 0 && less(key, list[j - 1])) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = key;
        }
    }

    public void bubbleSort() {
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (less(list[j + 1], list[j])) {
                    swap(j + 1, j);
                }
            }
        }
    }

    public void bubbleSortOpt() {
        boolean isSwap;
        for (int i = size - 1; i > 0; i--) {
            isSwap = false;
            for (int j = 0; j < i; j++) {
                if (less(list[j + 1], list[j])) {
                    swap(j + 1, j);
                    isSwap = true;
                }
            }

            if (!isSwap) {
                break;
            }
        }
    }

}
