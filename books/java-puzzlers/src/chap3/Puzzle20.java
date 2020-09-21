package chap3;

import common.AbstractPuzzle;

import java.util.regex.Pattern;

public class Puzzle20 extends AbstractPuzzle {

    public Puzzle20() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        System.out.println(Puzzle20.class.getName().replaceAll(".", "/") + ".class");
    }

    @Override
    public void showCorrect() {
        System.out.println(Puzzle20.class.getName().replaceAll(Pattern.quote("."), "/") + ".class");
    }
}
