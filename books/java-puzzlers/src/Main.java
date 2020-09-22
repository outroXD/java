import common.Chapter;
import common.IPuzzle;
import common.PuzzlesSingleton;

import java.util.ArrayList;

public class Main {
    private static final Chapter chapter = Chapter.Four;

    public static void main(String[] args) {
        ArrayList<IPuzzle> puzzles = PuzzlesSingleton.getPuzzlesByChapter(chapter);
        for (IPuzzle puzzle : puzzles) {
            puzzle.exec();
        }
    }
}
