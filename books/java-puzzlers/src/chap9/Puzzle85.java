package chap9;

import common.AbstractPuzzle;

public class Puzzle85 extends AbstractPuzzle {

    public Puzzle85() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        // ハングする
//        Lazy.main(null);
    }

    @Override
    public void showCorrect() {

    }
}

class Lazy {
    private static boolean initialized = false;

    static {
        // バックグラウンドステッドを開始
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                initialized = true;
            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) {
        System.out.println(initialized);
    }
}