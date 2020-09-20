import chap2.*;
import common.ChapterEnum;
import common.IPuzzle;
import common.PuzzlesFactory;

import java.util.ArrayList;

public class Main {
    private static final ChapterEnum targetChap = ChapterEnum.ChapTwo;

    public static void main(String[] args) {
        ArrayList<IPuzzle> puzzles = new PuzzlesFactory().getPuzzles(targetChap);
        for (IPuzzle puzzle : puzzles) {
            puzzle.exec();
        }
    }
}
