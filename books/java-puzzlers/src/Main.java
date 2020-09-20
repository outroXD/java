import chap2.*;
import common.IPuzzle;

public class Main {
    private final static IPuzzle[] puzzles = {
            new Puzzle1(), new Puzzle2(), new Puzzle3(), new Puzzle4(), new Puzzle5(),
            new Puzzle6(), new Puzzle7(), new Puzzle8(),
    };

    public static void main(String[] args) {
        for (IPuzzle puzzle : puzzles) {
            puzzle.exec();
        }
    }
}
