package common;

public abstract class AbstractPuzzle implements IPuzzle {

    String className;

    public AbstractPuzzle(String className) {
        this.className = className;
    }

    @Override
    public void exec() {
        System.out.println(this.className + " " + "Example case.");
        this.getExample();
        System.out.println(this.className + " " + "Correct case.");
        this.getCorrect();
        System.out.println();
    }
}
