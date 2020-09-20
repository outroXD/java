package chap3;

import common.AbstractPuzzle;

public class Puzzle11 extends AbstractPuzzle {

    public Puzzle11() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        System.out.print("H" + "a");
        System.out.println('H' + 'a');
    }

    @Override
    public void showCorrect() {
        System.out.println((int) 'H');
        System.out.println((int) 'a');
        System.out.println();
        StringBuffer sb = new StringBuffer();
        sb.append('H');
        sb.append('a');
        System.out.println(sb.toString());
        System.out.println();
        System.out.println("" + 'H' + 'a');
    }
}
