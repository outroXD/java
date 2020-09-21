package chap3;

import common.AbstractPuzzle;

import java.util.Random;

public class Puzzle23 extends AbstractPuzzle {

    private static Random rnd = new Random();

    public Puzzle23() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        StringBuffer word = null;
        switch (rnd.nextInt(2)) {
            case 1:
                word = new StringBuffer('P');
            case 2:
                word = new StringBuffer('G');
            default:
                word = new StringBuffer('M');
        }
        word.append('a');
        word.append('i');
        word.append('n');
        System.out.println(word);
    }

    @Override
    public void showCorrect() {
        String[] a = {"Main", "Pain", "Gain"};
        System.out.println(randomElement(a));
    }

    private static String randomElement(String[] a) {
        return a[rnd.nextInt(a.length)];
    }
}
