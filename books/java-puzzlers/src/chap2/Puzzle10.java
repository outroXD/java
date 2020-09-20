package chap2;

import common.AbstractPuzzle;

public class Puzzle10 extends AbstractPuzzle {

    public Puzzle10() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
    }

    @Override
    public void showCorrect() {
        Object x = "Buy ";
        String i = "Effective Java!";

        System.out.println("x:" + x);
        System.out.println("i:" + i);
        x = x + i;
        System.out.println("x = x + i:" + x);
        x += i;
        System.out.println("x += i:" + x);
    }
}
