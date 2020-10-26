package chap7;

import common.AbstractPuzzle;

import java.math.BigInteger;

public class Puzzle56 extends AbstractPuzzle {

    public Puzzle56() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        BigInteger fiveThousand = new BigInteger("5000");
        BigInteger fiftyThousand = new BigInteger("50000");
        BigInteger fiveHundredThousand = new BigInteger("500000");

        BigInteger total = BigInteger.ZERO;
        total.add(fiftyThousand);
        total.add(fiveThousand);
        total.add(fiveHundredThousand);
        System.out.println(total);
    }

    @Override
    public void showCorrect() {
        BigInteger fiveThousand = new BigInteger("5000");
        BigInteger fiftyThousand = new BigInteger("50000");
        BigInteger fiveHundredThousand = new BigInteger("500000");

        BigInteger total = BigInteger.ZERO;
        total = total.add(fiveThousand);
        total = total.add(fiftyThousand);
        total = total.add(fiveHundredThousand);
        System.out.println(total);
    }
}
