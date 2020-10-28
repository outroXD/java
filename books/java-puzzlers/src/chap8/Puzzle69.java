package chap8;

import common.AbstractPuzzle;

public class Puzzle69 extends AbstractPuzzle {

    public Puzzle69() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {

    }

    @Override
    public void showCorrect() {
        FadeToBlack.main(null);
    }
}

class FadeToBlack {
    public static void main(String[] args) {
        System.out.println(((X69.Y)null).Z);
    }
}

class X69 {
    static class Y {
        static String Z = "Black";
    }

    static C69 Y = new C69();
}

class C69 {
    String Z = "White";
}