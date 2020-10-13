package chap6;

import common.AbstractPuzzle;

public class Puzzle48 extends AbstractPuzzle {

    public Puzzle48() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        Dog woofer = new Dog();
        Dog nipper = new Basenji();
        woofer.bark();
        nipper.bark();
    }

    @Override
    public void showCorrect() {
    }
}

class Dog {
    public static void bark() {
        System.out.println("woof.");
    }
}

class Basenji extends Dog {
    public static void bark() {}
}