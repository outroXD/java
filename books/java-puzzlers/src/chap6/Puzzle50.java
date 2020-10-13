package chap6;

import common.AbstractPuzzle;

import java.lang.reflect.Type;

public class Puzzle50 extends AbstractPuzzle {

    public Puzzle50() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        Type1 t1 = new Type1();
        t1.doSample();
        System.out.println("");
        Type3 t3 = new Type3();
        t3.doSample();
    }

    @Override
    public void showCorrect() {
    }
}

class Type1 {
    public void doSample() {
        String s = null;
        System.out.println(s instanceof String);
    }
}

class Type2 {
    public void doSample() {
        try {
            // コンパイルエラー
//            System.out.println(new Type2() instanceof String);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

class Type3 {
    public void doSample() {
        try {
            Type3 t2 = (Type3) new Object();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}