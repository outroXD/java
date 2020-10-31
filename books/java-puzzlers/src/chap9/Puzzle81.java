package chap9;

import common.AbstractPuzzle;

public class Puzzle81 extends AbstractPuzzle {

    public Puzzle81() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        String greeting = "Hello world";
        for (int i = 0; i < greeting.length(); i++) {
            System.out.write(greeting.charAt(i));
        }
    }

    @Override
    public void showCorrect() {
        String greeting = "Hello world";
        for (int i = 0; i < greeting.length(); i++) {
            System.out.write(greeting.charAt(i));
            System.out.flush();
        }
    }
}
