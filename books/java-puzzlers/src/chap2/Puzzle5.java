package chap2;

import common.AbstractPuzzle;

public class Puzzle5 extends AbstractPuzzle {

    public Puzzle5() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        System.out.println(Long.toHexString(0x100000000L + 0xcafebabe));
    }

    @Override
    public void showCorrect() {
        System.out.println(Long.toHexString(0x100000000L + 0xcafebabeL));
    }
}
