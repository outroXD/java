package chap8;

import common.AbstractPuzzle;

public class Puzzle72 extends AbstractPuzzle {

    public Puzzle72() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        DoubleJeopardy.main(null);
    }

    @Override
    public void showCorrect() {

    }
}

class Jeopardy {
    public static final String PRIZE = "$64,000";
}

class DoubleJeopardy extends Jeopardy {
    public static final String PRIZE = "2 cents";

    public static void main(String[] args) {
        System.out.println(DoubleJeopardy.PRIZE);
    }
}
