package chap9;

import common.AbstractPuzzle;

public class Puzzle84 extends AbstractPuzzle {

    public Puzzle84() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        Thread.currentThread().interrupt();

        if (Thread.interrupted()) {
            System.out.println("Interrupted: " + Thread.interrupted());
        } else {
            System.out.println("Not Interrupted: " + Thread.interrupted());
        }
    }

    @Override
    public void showCorrect() {

    }
}
