package chap4;

import common.AbstractPuzzle;

public class Puzzle25 extends AbstractPuzzle {

    public Puzzle25() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        int j = 0;
        for (int i = 0; i < 100; i++) {
            j = j++;
        }
        System.out.println(j);
    }

    @Override
    public void showCorrect() {
        int j = 0;
        for (int i = 0; i < 100; i++) {
            j++;
        }
        System.out.println(j);
        j = 0;
        for (int i = 0; i < 100; i++) {
            ++j;
        }
        System.out.println(j);
    }
}
