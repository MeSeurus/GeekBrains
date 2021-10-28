package com.geekbrains;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 1. Создать массив большого размера (100000 элементов).
 * 2. Заполнить массив случайными числами.
 * 3. Написать методы, реализующие рассмотренные виды сортировок, и проверить скорость выполнения каждой.
 */

public class Main {

    public static void main(String[] args) {

        MyArrayList<Integer> mal1 = new MyArrayList<>();
        MyArrayList<Integer> mal2 = new MyArrayList<>();
        MyArrayList<Integer> mal3 = new MyArrayList<>();
        MyArrayList<Integer> mal4 = new MyArrayList<>();

        for (int i = 0; i < 100000; i++) {
            mal1.add(ThreadLocalRandom.current().nextInt(0, 10));
        }
        mal1.copy100000(mal2);
        System.out.println(mal2);
        mal1.copy100000(mal3);
        System.out.println(mal3);
        mal1.copy100000(mal4);
        System.out.println(mal4);

        //9827 millis
        long a = System.currentTimeMillis();
        mal1.selectionSort();
        long b = System.currentTimeMillis() - a;
        System.out.println("selectionSort: " + b);

        //53927 millis
        mal2.bubbleSort();
        long c = System.currentTimeMillis() - b - a;
        System.out.println("bubbleSort: " + c);

        //50990 millis
        mal3.bubbleSortOpt();
        long d = System.currentTimeMillis() - c - b - a;
        System.out.println("bubbleSortOpt: " + d);

        //20664 millis
        mal4.insertionSort();
        long e = System.currentTimeMillis() - d - c - b - a;
        System.out.println("insertionSort: " + e);
    }
}