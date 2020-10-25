package chap6;

import common.AbstractPuzzle;

public class Puzzle51 extends AbstractPuzzle {

    public Puzzle51() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        System.out.println(new ColorPoint(4, 2, "purple"));
    }

    private class Point {
        protected final int x, y;
        private final String name;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
            name = makeName();
        }

        protected String makeName() {
            return "[" + x +  "," + y + "]";
        }

        public final String toString() {
            return name;
        }
    }

    private class ColorPoint extends Point {
        private final String color;
        ColorPoint(int x, int y, String color) {
            super(x, y);
            this.color = color;
        }

        protected String makeName() {
            return super.makeName() + ":" + color;
        }
    }

    @Override
    public void showCorrect() {
        System.out.println(new ColorPointCorrect(4, 2, "purple"));
    }

    private class PointCorrect {
        protected final int x, y;
        private String name;
        PointCorrect(int x, int y) {
            this.x = x;
            this.y = y;
        }

        protected String makeName() {
            return "[" + x +  "," + y + "]";
        }

        public final synchronized String toString() {
            if (name == null) {
                name = makeName();
            }
            return name;
        }
    }

    private class ColorPointCorrect extends PointCorrect {
        private final String color;
        ColorPointCorrect(int x, int y, String color) {
            super(x, y);
            this.color = color;
        }

        protected String makeName() {
            return super.makeName() + ":" + color;
        }
    }
}
