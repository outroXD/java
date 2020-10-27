package chap7;

import common.AbstractPuzzle;

import java.util.IdentityHashMap;
import java.util.Map;

public class Puzzle62 extends AbstractPuzzle {

    public Puzzle62() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        Map<String, String> m = new IdentityHashMap<String, String>();
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
        System.out.println(m.size());
    }

    @Override
    public void showCorrect() {
    }
}
