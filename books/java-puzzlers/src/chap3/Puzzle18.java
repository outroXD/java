package chap3;

import common.AbstractPuzzle;

public class Puzzle18 extends AbstractPuzzle {

    public Puzzle18() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        byte[] bytes = new byte[256];
        for (int i = 0; i < 256; i++) {
            bytes[i] = (byte) i;
        }
        String str = new String(bytes);
        for (int i = 0, n = str.length(); i < n; i++) {
            System.out.println((int) str.charAt(i) + " ");
        }
    }

    @Override
    public void showCorrect() {
        byte[] bytes = new byte[256];
        for (int i = 0; i < 256; i++) {
            bytes[i] = (byte) i;
        }
        String str = "";
        try {
            str = new String(bytes, "ISO-8859-1");
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        for (int i = 0, n = str.length(); i < n; i++) {
            System.out.println((int) str.charAt(i) + " ");
        }
    }
}
