package chap9;

import common.AbstractPuzzle;

public class Puzzle83 extends AbstractPuzzle {

    public Puzzle83() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
    }

    @Override
    public void showCorrect() {
        Dog dog = Dog.INSTANCE.getInstance();
        dog.toString();
    }
}

class Dog extends Exception {
    public static final Dog INSTANCE = new Dog();

    private Dog() {}

    public Dog getInstance() {
        return INSTANCE;
    }

    public String toString() {
        return "Woof";
    }
}