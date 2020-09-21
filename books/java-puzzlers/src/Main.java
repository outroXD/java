import common.Chapter;
import common.IPuzzle;
import common.PuzzlesFactory;

import java.util.ArrayList;

public class Main {
    private static final Chapter chapter = Chapter.Three;

    public static void main(String[] args) {
        ArrayList<IPuzzle> puzzles = new PuzzlesFactory().getPuzzlesByChapter(chapter);
        for (IPuzzle puzzle : puzzles) {
            puzzle.exec();
        }
    }
}
