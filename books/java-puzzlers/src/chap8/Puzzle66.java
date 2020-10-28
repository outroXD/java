package chap8;

import common.AbstractPuzzle;

public class Puzzle66 extends AbstractPuzzle {

    public Puzzle66() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
//        System.out.println(new Derived().className);
    }

    @Override
    public void showCorrect() {
        System.out.println("[1]");
        System.out.println(((Base) new Derived()).className);

        System.out.println("[2]");
        System.out.println(new DerivedCorrect().getClassName());
    }
}

class Base {
    public String className = "Base";
}

class Derived extends Base {
    private String className = "Derived";
}

class BaseCorrect {
    public String getClassName() {
        return "Base";
    }
}

class DerivedCorrect extends BaseCorrect {
    public String getClassName() {
        return "DerivedCorrect";
    }
}