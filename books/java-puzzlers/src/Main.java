import common.AbstractPuzzle;
import common.Chapter;
import common.IPuzzle;
import common.PuzzlesSingleton;
import java.util.List;

public class Main {
    private static final Chapter chapter = Chapter.Eight;

    public static void main(String[] args) {
        List<AbstractPuzzle> puzzles = (List<AbstractPuzzle>) PuzzlesSingleton.getPuzzlesByChapter(chapter);
        for (IPuzzle puzzle : puzzles) {
            puzzle.exec();
        }
    }
}
