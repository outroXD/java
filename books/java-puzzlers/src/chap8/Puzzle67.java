package chap8;

import common.AbstractPuzzle;

public class Puzzle67 extends AbstractPuzzle {

    public Puzzle67() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        String s = new String("Hello world");
        System.out.println(s);
    }

    class String {
        private final java.lang.String s;

        public String(java.lang.String s) {
            this.s = s;
        }

        public java.lang.String toString() {
            return s;
        }
    }

    @Override
    public void showCorrect() {

    }
}