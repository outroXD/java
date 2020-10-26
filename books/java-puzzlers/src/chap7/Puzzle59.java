package chap7;

import common.AbstractPuzzle;

import java.util.HashSet;
import java.util.Set;

public class Puzzle59 extends AbstractPuzzle {

    public Puzzle59() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        int vals[] = {789, 678, 567, 456,
                     345, 234, 123, 012};
        Set<Integer> diffs = new HashSet<>();

        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j < vals.length; j++) {
                diffs.add(vals[i] - vals[j]);
            }
        }

        System.out.println(diffs.size());
    }

    @Override
    public void showCorrect() {
        int vals[] = {789, 678, 567, 456,
                345, 234, 123, 12};
        Set<Integer> diffs = new HashSet<>();

        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j < vals.length; j++) {
                diffs.add(vals[i] - vals[j]);
            }
        }

        System.out.println(diffs.size());
    }
}
