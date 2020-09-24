package chap4;

import common.AbstractPuzzle;

public class Puzzle26 extends AbstractPuzzle {

    public static final int END = Integer.MAX_VALUE;
    public static final int START = END - 100;

    public Puzzle26() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
//        int count = 0;
//        for (int i = START; i <= END; i++) {
//            count++;
//        }
//        System.out.println(count);
    }

    @Override
    public void showCorrect() {
        int count = 0;
        for (long i = START; i <= END; i++) {
            count++;
        }
        System.out.println(count);
    }
}
