package chap6;

import common.AbstractPuzzle;

public class Puzzle54 extends AbstractPuzzle {

    public Puzzle54() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        ((Null) null).greet();
    }

    @Override
    public void showCorrect() {
        Null.main();
    }
}

class Null {
    public static void greet() {
        System.out.println("Hello world!");
    }

    public static void main() {
        greet();
    }
}