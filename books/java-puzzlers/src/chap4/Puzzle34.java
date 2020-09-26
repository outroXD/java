package chap4;

import common.AbstractPuzzle;

public class Puzzle34 extends AbstractPuzzle {

    public Puzzle34() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        final int START = 2000000000;
        int count = 0;
        for (float f = START; f < START + 50; f++) {
            count++;
        }
        System.out.println(count);
    }

    @Override
    public void showCorrect() {
        final int START = 2000000000;
        if ((float) START + 50 == (float) START) {
            System.out.println("精度が落ちている。");
        }

        int count = 0;
        for (int f = START; f < START + 50; f++) {
            count++;
        }
        System.out.println(count);
    }
}
