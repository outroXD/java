package chap5;

import common.AbstractPuzzle;

import java.io.*;

public class Puzzle41 extends AbstractPuzzle {

    public Puzzle41() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
    }

    private void copy(String src, String dest) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read(buf)) > 0) {
                out.write(buf, 0, n);
            }
        } finally {
            if (in != null) in.close();
            if (out != null) out.close();
        }
    }

    @Override
    public void showCorrect() {
    }

    private void copy_correct_1(String src, String dest) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read(buf)) > 0) {
                out.write(buf, 0, n);
            }
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    //
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    //
                }
            }
        }
    }
}
