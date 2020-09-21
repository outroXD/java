package chap3;

import common.AbstractPuzzle;

public class Puzzle15 extends AbstractPuzzle {

    public Puzzle15() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        System.out.print("Hell");
        System.out.println("o world");
    }

    @Override
    public void showCorrect() {

    }
}
