package chap2;

import common.AbstractPuzzle;

public class Puzzle8 extends AbstractPuzzle {

    public Puzzle8() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        char x = 'X';
        int i = 0;
        System.out.println(true ? x : 0);
        System.out.println(false ? i : x);
    }

    @Override
    public void showCorrect() {
        char x = 'X';
        char i = '0';
        System.out.println(true ? x : 0);
        System.out.println(false ? i : x);
    }
}
