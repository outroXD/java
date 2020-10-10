package chap5;

import common.AbstractPuzzle;

public class Puzzle40 extends AbstractPuzzle {

    public Puzzle40() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    private class Reluctant {
        private Reluctant internalInstance = new Reluctant();
        public Reluctant() throws Exception {
            throw new Exception("I'm not coming out");
        }
    }

    @Override
    public void showExample() {
        try {
//            Reluctant b = new Reluctant();
            System.out.println("Surprise!");
        } catch (Exception e) {
            System.out.println("I told you so");
        }
    }

    @Override
    public void showCorrect() {
    }
}
