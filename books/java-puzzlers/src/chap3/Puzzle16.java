package chap3;

import common.AbstractPuzzle;

public class Puzzle16 extends AbstractPuzzle {

    public Puzzle16() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        char c = 0x000A;
        System.out.println(c);
    }

    @Override
    public void showCorrect() {
    }
}
