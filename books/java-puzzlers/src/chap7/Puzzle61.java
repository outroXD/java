package chap7;

import common.AbstractPuzzle;

import java.util.Calendar;
import java.util.Date;

public class Puzzle61 extends AbstractPuzzle {

    public Puzzle61() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1999, 12, 31);
        System.out.println(calendar.get(Calendar.YEAR) + " ");

        Date date = calendar.getTime();
        System.out.println(date.getDay());
    }

    @Override
    public void showCorrect() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1999, Calendar.DECEMBER, 31);
        System.out.println(calendar.get(Calendar.YEAR) + " ");
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
