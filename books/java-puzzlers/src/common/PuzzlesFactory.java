package common;

import chap2.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PuzzlesFactory {

    private static HashMap<ChapterEnum, ArrayList<IPuzzle>> puzzles = new HashMap<ChapterEnum, ArrayList<IPuzzle>>();

    public PuzzlesFactory() {
        puzzles.put(ChapterEnum.ChapTwo, new ArrayList<IPuzzle>(Arrays.asList(
                new Puzzle1(), new Puzzle2(), new Puzzle3(), new Puzzle4(), new Puzzle5(),
                new Puzzle6(), new Puzzle7(), new Puzzle8(), new Puzzle9(), new Puzzle10())));
    }

    public ArrayList<IPuzzle> getPuzzles(ChapterEnum key) {
        return this.puzzles.get(key);
    }
}
