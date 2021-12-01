package com.geekbrains;

public class Satchel {

    private Item[] items;

    Satchel(Item[] items) {
        this.items = items;
    }

    int optSum(int i, int capacity) {
        if (i < 0) {
            return 0;
        }
        if (items[i].weight > capacity) {
            return optSum(i - 1, capacity);
        } else {
            return Math.max(optSum(i - 1, capacity),
                    optSum(i - 1, capacity - items[i].weight) + items[i].price);
        }
    }

    public Item[] getItems() {
        return items;
    }
}