package chap9;

import common.AbstractPuzzle;

public class Puzzle82 extends AbstractPuzzle {

    public Puzzle82() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample(){
        // 実行時引数にslaveを指定して実行する
        BeerBlast.main(null);
    }

    @Override
    public void showCorrect() {
    }
}

class BeerBlast {
     static final String COMMAND = "java BeerBlast slave";

     public static void main(String[] args) {
         try {
             if (args.length == 1 && args[0].equals("slave")) {
                 for (int i = 99; i > 0; i--) {
                     System.out.println(i + " bottles of beer on the wall.");
                     System.out.println(i + " bottles of beer.");
                     System.out.println("You take one down, pass it around,");
                     System.out.println((i-1) + " bottles of beer on the wall.");
                     System.out.println();
                 }
             } else {
                 Process process = Runtime.getRuntime().exec(COMMAND);
                 int exitValue = process.waitFor();
                 System.out.println("exit value = " + exitValue);
             }
         } catch (Exception e) {
             System.out.println(e.toString());
         }
     }
}