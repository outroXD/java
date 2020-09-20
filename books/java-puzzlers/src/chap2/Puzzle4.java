package chap2;

import common.AbstractPuzzle;

public class Puzzle4 extends AbstractPuzzle {

    public Puzzle4() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        System.out.println(12345 + 5432l);
    }

    @Override
    public void showCorrect() {
        System.out.println(12345 + 5432L);
    }
}
