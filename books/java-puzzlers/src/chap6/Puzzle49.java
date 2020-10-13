package chap6;

import common.AbstractPuzzle;

import java.util.Calendar;

public class Puzzle49 extends AbstractPuzzle {

    public Puzzle49() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        System.out.println("Elvis wears a size " + Elvis.INSTANCE.beltSize() + "belt.");
    }

    @Override
    public void showCorrect() {
        System.out.println("Elvis wears a size " + ElvisCorrect.INSTANCE.beltSize() + "belt.");
    }
}

class Elvis {
    public static final Elvis INSTANCE = new Elvis();
    private final int beltSize;
    private static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);

    private Elvis() {
        beltSize = CURRENT_YEAR - 1930;
    }

    public int beltSize() {
        return beltSize;
    }
}

class ElvisCorrect {
    private static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
    public static final ElvisCorrect INSTANCE = new ElvisCorrect();
    private final int beltSize;

    private ElvisCorrect() {
        beltSize = CURRENT_YEAR - 1930;
    }

    public int beltSize() {
        return beltSize;
    }
}