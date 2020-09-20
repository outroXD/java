package chap3;

import common.AbstractPuzzle;

public class Puzzle13 extends AbstractPuzzle {

    public Puzzle13() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        final String pig = "length: 10";
        final String dog = "length: " + pig.length();
        System.out.println("Animals are equal: " + pig == dog);
    }

    @Override
    public void showCorrect() {
        final String pig = "length: 10";
        final String dog = "length: " + pig.length();
        System.out.println("Animals are equal: " + pig.equals(dog));
    }
}
