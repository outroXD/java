package chap6;

import common.AbstractPuzzle;

public class Puzzle46 extends AbstractPuzzle {

    public Puzzle46() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        new Confusing(null);
    }

    private class Confusing {
        private Confusing(Object o) {
            System.out.println("Objevt");
        }

        private Confusing(double[] dArray) {
            System.out.println("double");
        }

//        コンパイルエラー
//        private Confusing(int[] i) {
//            System.out.println("int");
//        }
    }

    @Override
    public void showCorrect() {
    }
}
