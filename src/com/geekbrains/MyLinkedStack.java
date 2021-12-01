package com.geekbrains;

import java.util.Iterator;
import java.util.NoSuchElementException;

// * 1. Реализовать MyLinkedStack используя класс MyLinkedList

public class MyLinkedStack<Item> implements Iterable<Item> {
    private int n;          // размер стэка
    private Node first;     // верхушка стэка

    // Вспомогательный LinkedList
    private class Node {
        private Item item;
        private Node next;
    }

    public MyLinkedStack() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        Item item = first.item;        // Временный "захват"
        first = first.next;            // удаление первого эл-та
        n--;
        return item;                   // Возврат захваченного элемента
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        return first.item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item + " ");
        }
        return s.toString();
    }

    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<Item> {

        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
