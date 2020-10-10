package chap5;

import common.AbstractPuzzle;

public class Puzzle42 extends AbstractPuzzle {

    public Puzzle42() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        int[][] test = {{6, 5, 4, 3, 2, 1}, {1, 2}, {1, 2, 3}, {1, 2, 3, 4}, {1}};
        int n = 0;

        try {
            int i = 0;
            while (true) {
                if (thirdElementIsThree(test[i++])) {
                    n++;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //
        }
        System.out.println(n);
    }

    private static boolean thirdElementIsThree(int[] a) {
        return a.length >= 3 & a[2] == 3;
    }

    @Override
    public void showCorrect() {
        int[][] tests = {{6, 5, 4, 3, 2, 1}, {1, 2}, {1, 2, 3}, {1, 2, 3, 4}, {1}};
        int cnt = 0;

        try {
            for (int[] test : tests) {
                if (correctThirdElementIsThree(test)) {
                    cnt++;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //
        }
        System.out.println(cnt);
    }

    private static boolean correctThirdElementIsThree(int[] a) {
        return a.length >= 3 && a[2] == 3;
    }
}
