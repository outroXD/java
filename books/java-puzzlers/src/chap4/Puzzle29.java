package chap4;

import common.AbstractPuzzle;

public class Puzzle29 extends AbstractPuzzle {

    public Puzzle29() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {}

    @Override
    public void showCorrect() {
        double i = Double.NaN;
        System.out.println(i != i);
    }
}
