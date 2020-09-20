package chap2;

import common.AbstractPuzzle;

public class Puzzle7 extends AbstractPuzzle {

    public Puzzle7() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void getExample() {
        int x = 1984;
        int y = 2001;
        x ^= y ^= x ^= y;
        System.out.println("x = " + x + "; y = " + y);
    }

    @Override
    public void getCorrect() {
        int x = 1984;
        int y = 2001;
        int tmp;
        tmp = y;
        y = x;
        x = tmp;
        System.out.println("x = " + x + "; y = " + y);
    }
}
