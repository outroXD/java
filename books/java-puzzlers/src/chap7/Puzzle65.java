package chap7;

import common.AbstractPuzzle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Puzzle65 extends AbstractPuzzle {

    public Puzzle65() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        SuspiciousSort.main(null);
    }

    @Override
    public void showCorrect() {
    }
}

class SuspiciousSort {
    public static void main(String[] args) {
        Random rnd = new Random();
        Integer[] arr = new Integer[100];

        for (int i = 0; i < arr.length; i++)
            arr[i] = rnd.nextInt();

        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };

        Arrays.sort(arr, cmp);
        System.out.println(order(arr));
    }

    enum Order {ASCENDING, DESCENDING, CONSTANT, UNORDERED};

    static Order order(Integer[] a) {
        boolean ascending = false;
        boolean descending = false;

        for (int i = 1; i < a.length; i++) {
            ascending |= a[i] > a[i-1];
            descending |= a[i] < a[i-1];
        }

        if (ascending && !descending)
            return Order.ASCENDING;
        if (descending && !ascending)
            return Order.DESCENDING;
        if (!ascending)
            return Order.CONSTANT;
        return Order.UNORDERED;
    }
}