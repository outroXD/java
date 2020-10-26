package chap7;

import common.AbstractPuzzle;

import java.util.HashSet;
import java.util.Set;

public class Puzzle57 extends AbstractPuzzle {

    public Puzzle57() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        Set<Name> s = new HashSet<Name>();
        s.add(new Name("Mickey", "Mouse"));
        System.out.println(s.contains(new Name("Mickey", "Mouse")));
    }

    @Override
    public void showCorrect() {
        Set<NameCorrect> s = new HashSet<NameCorrect>();
        s.add(new NameCorrect("Mickey", "Mouse"));
        System.out.println(s.contains(new NameCorrect("Mickey", "Mouse")));
    }
}

class Name {
    private String first, last;

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Name)) {
            return false;
        }
        Name n = (Name) o;
        return n.first.equals(first) && n.last.equals(last);
    }
}

class NameCorrect {
    private String first, last;

    public NameCorrect(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (!(o instanceof NameCorrect)) {
            return false;
        }
        NameCorrect n = (NameCorrect) o;
        return n.first.equals(first) && n.last.equals(last);
    }

    public int hashCode() {
        return 37 * first.hashCode() + last.hashCode();
    }
}