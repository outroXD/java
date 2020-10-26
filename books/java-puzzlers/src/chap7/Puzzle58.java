package chap7;

import common.AbstractPuzzle;

import java.util.HashSet;
import java.util.Set;

public class Puzzle58 extends AbstractPuzzle {

    public Puzzle58() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        Set<NamePuzzle58> s = new HashSet<>();
        s.add(new NamePuzzle58("Donald", "Duck"));
        System.out.println(s.contains(new NamePuzzle58("Donald", "Duck")));
    }

    @Override
    public void showCorrect() {
        Set<NamePuzzle58Correct> s = new HashSet<>();
        s.add(new NamePuzzle58Correct("Donald", "Duck"));
        System.out.println(s.contains(new NamePuzzle58Correct("Donald", "Duck")));
    }
}

class NamePuzzle58 {
    private String first, last;

    public NamePuzzle58(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(NamePuzzle58 n) {
        return n.first.equals(first) && n.last.equals(last);
    }

    public int hashCode() {
        return 31 * first.hashCode() + last.hashCode();
    }
}

class NamePuzzle58Correct {
    private String first, last;

    public NamePuzzle58Correct(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof NamePuzzle58Correct)) {
            return false;
        }
        NamePuzzle58Correct n = (NamePuzzle58Correct) o;
        return n.first.equals(first) && n.last.equals(last);
    }

    @Override
    public int hashCode() {
        return 31 * first.hashCode() + last.hashCode();
    }
}