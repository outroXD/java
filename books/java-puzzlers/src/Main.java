import chap2.*;
import common.ChapterEnum;
import common.IPuzzle;
import common.PuzzlesFactory;

import java.util.ArrayList;

public class Main {
    private static final ChapterEnum chapter = ChapterEnum.ChapThree;

    public static void main(String[] args) {
        ArrayList<IPuzzle> puzzles = new PuzzlesFactory().getPuzzlesByChapter(chapter);
        for (IPuzzle puzzle : puzzles) {
            puzzle.exec();
        }
    }
}
