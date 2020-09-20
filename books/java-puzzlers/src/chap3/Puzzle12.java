package chap3;

import common.AbstractPuzzle;

public class Puzzle12 extends AbstractPuzzle {

    public Puzzle12() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        String letters = "ABC";
        char[] numbers = {'1', '2', '3'};
        System.out.println(letters + " easy as " + numbers);
    }

    @Override
    public void showCorrect() {
        String letters = "ABC";
        char[] numbers = {'1', '2', '3'};
        System.out.println(letters + " easy as " + String.valueOf(numbers));
    }
}
