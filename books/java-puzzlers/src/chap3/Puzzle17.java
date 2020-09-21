package chap3;

import common.AbstractPuzzle;

public class Puzzle17 extends AbstractPuzzle {

    public Puzzle17() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        \u0053\u0079\u0073\u0074\u0065\u006d\u002e\u006f\u0075\u0074\u002e\u0070\u0072\u0069\u006e\u0074\u006c\u006e\u0028\u0022\u0048\u0065\u006c\u006c\u006f\u0020\u0077\u0022\u0020\u002b\u0020\u0022\u006f\u0072\u006c\u0064\u0022\u0029\u003b;
    }

    @Override
    public void showCorrect() {
        System.out.println("Hello w" + "orld");
    }
}
