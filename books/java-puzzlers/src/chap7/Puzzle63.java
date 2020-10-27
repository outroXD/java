package chap7;

import common.AbstractPuzzle;

import java.util.HashMap;
import java.util.Map;

public class Puzzle63 extends AbstractPuzzle {

    public Puzzle63() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
    }

    @Override
    public void showCorrect() {
        MoreName.main(null);
    }
}

class MoreName {
    private Map<String, String> m = new HashMap<String, String>();

    MoreName() {
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
    }

    public int size() {
        return m.size();
    }

    public static void main(String args[]) {
        MoreName moreName = new MoreName();
        System.out.println(moreName.size());
    }
}
