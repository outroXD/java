package common;

public abstract class AbstractPuzzle implements IPuzzle {

    String className;

    public AbstractPuzzle(String className) {
        this.className = className;
    }

    @Override
    public void exec() {
        System.out.println(this.className + " " + "Example case.");
        this.showExample();
        System.out.println(this.className + " " + "Correct case.");
        this.showCorrect();
        System.out.println();
    }
}
