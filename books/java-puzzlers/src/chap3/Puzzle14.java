package chap3;

import common.AbstractPuzzle;

public class Puzzle14 extends AbstractPuzzle {

    public Puzzle14() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        System.out.println("a\u0022.length() + \u0022b".length());
    }

    @Override
    public void showCorrect() {
        System.out.println("a\".length() + \"b".length());
    }
}
