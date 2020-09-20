package chap2;

import common.AbstractPuzzle;

public class Puzzle1 extends AbstractPuzzle {

    public Puzzle1() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        System.out.println(isOdd(1));
        System.out.println(isOdd(2));
        System.out.println(isOdd(3));
        System.out.println(isOdd(4));
        System.out.println();
        System.out.println(isOdd(-1));
        System.out.println(isOdd(-2));
        System.out.println(isOdd(-3));
        System.out.println(isOdd(-4));
    }

    @Override
    public void showCorrect() {
        System.out.println(isOddCorrect(1));
        System.out.println(isOddCorrect(2));
        System.out.println(isOddCorrect(3));
        System.out.println(isOddCorrect(4));
        System.out.println();
        System.out.println(isOddCorrect(-1));
        System.out.println(isOddCorrect(-2));
        System.out.println(isOddCorrect(-3));
        System.out.println(isOddCorrect(-4));
    }

    private boolean isOdd(int i) {
        return i % 2 == 1;
    }

    private static boolean isOddCorrect(int i) {
        return i % 2 != 0;
    }
}
