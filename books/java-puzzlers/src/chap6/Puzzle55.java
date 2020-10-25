package chap6;

import common.AbstractPuzzle;

public class Puzzle55 extends AbstractPuzzle {

    public Puzzle55() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
//        for (int i = 0; i < 100; i++)
//            Creature creature = new Creature();
//        System.out.println(Creature.getNumCreated());
    }

    @Override
    public void showCorrect() {
        for (int i = 0; i < 100; i++) {
            Creature creature = new Creature();
        }
        System.out.println(Creature.getNumCreated());
    }
}

class Creature {
    private static long numCreated = 0;

    public Creature() {
        numCreated++;
    }

    public static long getNumCreated() {
        return numCreated;
    }
}

class CreatureThreadSafe {
    private static long numCreated = 0;

    public CreatureThreadSafe() {
        synchronized (CreatureThreadSafe.class) {
            numCreated++;
        }
    }

    public static long getNumCreated() {
        return numCreated;
    }
}