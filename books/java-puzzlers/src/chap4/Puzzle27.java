package chap4;

import common.AbstractPuzzle;

public class Puzzle27 extends AbstractPuzzle {

    public Puzzle27() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
//        int i = 0;
//        while (-1 << i != 0) {
//            i++;
//        }
//        System.out.println(i);
    }

    @Override
    public void showCorrect() {
        int distance = 0;
        for (int val = -1; val != 0; val <<= 1) {
            distance++;
        }
        System.out.println(distance);
    }
}
