package chap4;

import common.AbstractPuzzle;

public class Puzzle24 extends AbstractPuzzle {

    private static final byte TARGET = (byte) 0x90;

    public Puzzle24() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
            if (b == 0x90) {
                System.out.println("Joy!");
            }
        }
    }

    @Override
    public void showCorrect() {
        for (byte b = Byte.MIN_VALUE; b< Byte.MAX_VALUE; b++) {
            if (b == TARGET) {
                System.out.println("Joy!");
            }
        }
    }
}
