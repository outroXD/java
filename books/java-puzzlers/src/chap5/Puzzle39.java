package chap5;

import common.AbstractPuzzle;

public class Puzzle39 extends AbstractPuzzle {

    public Puzzle39() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        try {
            System.out.println("Hello world");
//            System.exit(0);
        } finally {
            System.out.println("Goodbye world");
        }
    }

    @Override
    public void showCorrect() {
        System.out.println("Hello world");
        Runtime.getRuntime().addShutdownHook(
                new Thread() {
                    public void run() {
                        System.out.println("Goodbye world");
                    }
                }
        );
//        System.exit(0);
    }
}
