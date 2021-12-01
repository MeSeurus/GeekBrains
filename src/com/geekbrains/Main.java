package com.geekbrains;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        int quantity = 29478;
        int flag = 0;

        for (int i = 0; i < quantity; i++) {
            GenTreeMap<Integer, Integer> map = new GenTreeMap<>();
            int x = 0;
            while (map.height() < 6) {
                x = random.nextInt(101);
                map.put(x, x);
            }
            map.delete(x);
            if (map.isBalanced()) {
                flag++;
            }
        }
        System.out.println("Сбалансировано " + (double) flag / quantity * 100 + " % (" + flag + " штук) из 100 % (всего " + quantity + " штук)");
    }
}
