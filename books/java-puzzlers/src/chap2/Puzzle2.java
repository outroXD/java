package chap2;

import common.AbstractPuzzle;

import java.math.BigDecimal;

public class Puzzle2 extends AbstractPuzzle {

    public Puzzle2() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void getExample() {
        System.out.println(2.00 - 1.10);
    }

    @Override
    public void getCorrect() {
        System.out.println(200 - 110 + "cents");
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));
    }
}
