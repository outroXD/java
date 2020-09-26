package chap4;

import common.AbstractPuzzle;

public class Puzzle35 extends AbstractPuzzle {

    public Puzzle35() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        int minutes = 0;
        for (int ms = 0; ms < 60*60*1000; ms++) {
            if (ms % 60*1000 == 0) {
                minutes++;
            }
        }
        System.out.println(minutes);
    }

    @Override
    public void showCorrect() {
        final int MS_PER_HOUR = 60 * 60 * 1000;
        final int MS_PER_MINUTE = 60 * 1000;

        int minutes = 0;
        for (int ms = 0; ms < MS_PER_HOUR; ms++) {
            if (ms % MS_PER_MINUTE == 0) {
                minutes++;
            }
        }
    }
}
