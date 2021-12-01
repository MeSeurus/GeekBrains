package com.geekbrains;

/**
 * 1. Написать программу по возведению числа в степень с помощью рекурсии.
 * 2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
 */

public class Main {
    public static void main(String[] args) {

        //Задание 1.
        System.out.println(recursionPower(9,-1));

        //Задание 2.
        Item[] items = {new Item(2, 3),
                new Item(3, 5),
                new Item(5, 3),
                new Item(1, 7),
                new Item(2, 9)};

        Satchel satchel = new Satchel(items);
        //Вместимость рюкзака
        int capacity = 10;
        System.out.println("Рюкзак заполнен на " +
                satchel.optSum(items.length - 1, capacity) + " из " + capacity);
    }

    //1. Написать программу по возведению числа в степень с помощью рекурсии.

    public static double recursionPower(double value, double power) {
        if (value == 0) {
            return 0;
        }
        if (power == 0) {
            return 1;
        }
        if (power < 0) {
            return recursionPower(1 / value, -1 * power);
        } else {
            return value * recursionPower(value, power - 1);
        }
    }
}
