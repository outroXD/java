package chap5;

import common.AbstractPuzzle;

public class Puzzle37 extends AbstractPuzzle {

    public Puzzle37() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
//        ex1();
        ex2();
        ex3();
    }

//    private void ex1() {
//        try {
//            System.out.println("Hello world.");
//        } catch (IOException e) {
//            System.out.println("I've never seen println fail!");
//        }
//    }

    private void ex2() {
        try {
        } catch (Exception e) {
            System.out.println("This can't happen.");
        }
    }

    private interface Type1 {
        void f() throws CloneNotSupportedException;
    }
    private interface Type2 {
        void f() throws InterruptedException;
    }
    private interface Type3 extends Type1, Type2 {
    }
    private class Arcan3 implements Type3 {
        @Override
        public void f() {
            System.out.println("Hello world.");
        }
    }
    private void ex3() {
        Type3 t3 = new Arcan3();
        t3.f();
    }

    @Override
    public void showCorrect() {
    }
}
