package chap8;

import common.AbstractPuzzle;

public class Puzzle68 extends AbstractPuzzle {

    public Puzzle68() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        System.out.println(X.Y.Z);
    }

    @Override
    public void showCorrect() {
        System.out.println(Ex.Why.z);
    }
}

class X {
    static class Y {
        static String Z = "Black";
    }

    static C Y = new C();
}

class C {
    String Z = "White";
}

class Ex {
    static class Why {
        static String z = "Black";
    }
    static See y = new See();
}

class See {
    String z = "White";
}