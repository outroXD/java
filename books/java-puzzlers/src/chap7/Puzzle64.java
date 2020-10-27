package chap7;

import common.AbstractPuzzle;

public class Puzzle64 extends AbstractPuzzle {

    public Puzzle64() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
//        final int MODULES = 3;
//        int[] histogram = new int[MODULES];
//
//        int i = Integer.MIN_VALUE;
//        do {
//            histogram[Math.abs(i) % MODULES]++;
//        } while (i++ != Integer.MAX_VALUE);
//
//        for (int j = 0; j < MODULES; j++) {
//            System.out.println(histogram[j] + " ");
//        }
    }

    @Override
    public void showCorrect() {
    }
}
