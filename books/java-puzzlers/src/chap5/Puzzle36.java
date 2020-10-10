package chap5;

import common.AbstractPuzzle;

public class Puzzle36 extends AbstractPuzzle {

    public Puzzle36() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        System.out.println(decision());
    }

    private boolean decision() {
        try {
            return true;
        } finally {
            return false;
        }
    }

    @Override
    public void showCorrect() {
    }
}