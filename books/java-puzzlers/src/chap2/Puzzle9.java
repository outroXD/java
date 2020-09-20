package chap2;

import common.AbstractPuzzle;

public class Puzzle9 extends AbstractPuzzle {

    public Puzzle9() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void getExample() {
    }

    @Override
    public void getCorrect() {
        short x = 0;
        int i = 123456;
        System.out.println("x:" + x);
        System.out.println("i:" + i);
        x += i;
        System.out.println("x += i:" + x);
//        x = x + i;  コンパイルエラー
    }
}
