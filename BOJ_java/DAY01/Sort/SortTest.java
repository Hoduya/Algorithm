package DAY01.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {
    public static void main(String[] args) {
        Item item1 = new Item(1, 3, 1);
        Item item2 = new Item(1, 2, 3);
        Item item3 = new Item(1, 1, 2);

        List<Item> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);

        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        // 현업에서는 잘 안씀 (오름차순인지, 내림차순인지 헷갈려서)
        Collections.sort(list, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.c - o2.c;
            }
        });

        // b로 오름차순
        Collections.sort(list, Comparator.comparingInt(Item::getB));

        // b로 내림차순
        Collections.sort(list, Comparator.comparingInt(Item::getB).reversed());
    }
}

class Item implements Comparable<Item>{
    int a;
    int b;
    int c;

    public Item(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Item{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }

    @Override
    public int compareTo(Item o) {
        // 음수 -> 바꾸지 않음
        // 0
        // 양수 -> SWAP
        return b - o.b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
}
