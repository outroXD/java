package chap6;

import common.AbstractPuzzle;

public class Puzzle52 extends AbstractPuzzle {

    public Puzzle52() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        System.out.println(Cache.getSum());
    }

    @Override
    public void showCorrect() {
        System.out.println(CacheCorrect.getSum());
    }
}

class Cache {
    static {
        initializeIfNecessary();  // 1
    }

    private static int sum;
    public static int getSum() {
        initializeIfNecessary();
        return sum;
    }

    private static boolean initialized = false;  // 5
    private static synchronized void initializeIfNecessary() {
        if (!initialized) {  // 2, 6
            for (int i = 0; i < 100; i++) {
                sum += 1; // 3, 7
            }
            initialized = true;  // 4
        }
    }
}

class CacheCorrect {
    private static final int sum = computeSum();

    private static int computeSum() {
        int result = 0;
        for (int i = 0; i < 100; i++) {
            result += i;
        }
        return result;
    }

    public static int getSum() {
        return sum;
    }
}