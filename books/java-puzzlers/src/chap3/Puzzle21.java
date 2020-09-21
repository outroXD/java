package chap3;

import common.AbstractPuzzle;

import java.io.File;

public class Puzzle21 extends AbstractPuzzle {

    public Puzzle21() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        // windowsだとうまく置換できないっぽい
        System.out.println(Puzzle21.class.getName().replaceAll("\\.", File.separator) + ".class");
    }

    @Override
    public void showCorrect() {
        System.out.println(Puzzle21.class.getName().replace('.', File.separatorChar) + ".class");
    }
}
