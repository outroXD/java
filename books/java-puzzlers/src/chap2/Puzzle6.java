package chap2;

import common.AbstractPuzzle;

public class Puzzle6 extends AbstractPuzzle {
    public Puzzle6() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void getExample() {
        System.out.println((int) (char) (byte) -1);
    }

    @Override
    public void getCorrect() {
    }
}
