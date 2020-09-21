package chap3;

import common.AbstractPuzzle;

public class Puzzle22 extends AbstractPuzzle {

    public Puzzle22() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        System.out.println("iexplore:");
        http://www.google.com
        System.out.println(":maximize");
    }

    @Override
    public void showCorrect() {
    }
}
