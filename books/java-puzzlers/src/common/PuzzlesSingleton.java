package common;

import chap2.*;
import chap3.*;
import chap4.Puzzle24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PuzzlesSingleton {

    // TODO puzzlesより先にsingletonを記述すると実行時エラー 順序に依存している。
    private static final Map<Chapter, ArrayList<IPuzzle>> puzzles = new HashMap<>();
    private static final PuzzlesSingleton singleton = new PuzzlesSingleton();

    private PuzzlesSingleton() {
        puzzles.put(Chapter.Two, new ArrayList<>(Arrays.asList(
                new Puzzle1(), new Puzzle2(), new Puzzle3(), new Puzzle4(), new Puzzle5(),
                new Puzzle6(), new Puzzle7(), new Puzzle8(), new Puzzle9(), new Puzzle10())));
        puzzles.put(Chapter.Three, new ArrayList<>(Arrays.asList(
                new Puzzle11(), new Puzzle12(), new Puzzle13(), new Puzzle14(), new Puzzle15(),
                new Puzzle16(), new Puzzle17(), new Puzzle18(), new Puzzle19(), new Puzzle20(),
                new Puzzle21(), new Puzzle22(), new Puzzle23())));
        puzzles.put(Chapter.Four, new ArrayList<>(Arrays.asList(
                new Puzzle24())));
    }

    public static PuzzlesSingleton getInstance() {
        return singleton;
    }

    public static ArrayList<IPuzzle> getPuzzlesByChapter(Chapter chapter) {
        return puzzles.get(chapter);
    }
}
