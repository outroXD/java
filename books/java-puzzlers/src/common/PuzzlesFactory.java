package common;

import chap2.*;
import chap3.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PuzzlesFactory {

    private static final HashMap<ChapterEnum, ArrayList<IPuzzle>> puzzles = new HashMap<ChapterEnum, ArrayList<IPuzzle>>();

    public PuzzlesFactory() {
        puzzles.put(ChapterEnum.ChapTwo, new ArrayList<IPuzzle>(Arrays.asList(
                new Puzzle1(), new Puzzle2(), new Puzzle3(), new Puzzle4(), new Puzzle5(),
                new Puzzle6(), new Puzzle7(), new Puzzle8(), new Puzzle9(), new Puzzle10())));
        puzzles.put(ChapterEnum.ChapThree, new ArrayList<IPuzzle>(Arrays.asList(
                new Puzzle11(), new Puzzle12(), new Puzzle13(), new Puzzle14(), new Puzzle15(),
                new Puzzle16(), new Puzzle17(), new Puzzle18(), new Puzzle19(), new Puzzle20())));
    }

    public ArrayList<IPuzzle> getPuzzlesByChapter(ChapterEnum chapter) {
        return puzzles.get(chapter);
    }
}
