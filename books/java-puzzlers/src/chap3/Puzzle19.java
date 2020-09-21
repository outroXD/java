package chap3;

import common.AbstractPuzzle;

public class Puzzle19 extends AbstractPuzzle {

    public Puzzle19() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        System.out.println(classify('n')
                + classify('+')
                + classify('2'));
    }

    private String classify(char ch) {
        if ("012356789".indexOf(ch) >= 0) {
            return "NUMERAL ";
        }
        if ("abcdefghijklmnopqrstuvwxyz".indexOf(ch) >= 0) {
            return "OPERATOR ";
        }

//        /* (Operators not supported yet)
//        if ("+-*/&|!=".indexOf(ch) >= 0) " +
//                "return "OPERATOR ";
//         */
        return "UNKNOWN ";
    }

    @Override
    public void showCorrect() {
    }
}
