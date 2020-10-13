package common;

import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

public class PuzzlesSingleton {

    // !!クラス初期化子の循環あり!!
    // コンストラクタ内の処理ではpuzzlesを使用しているので、先にpuzzlesを初期化すること。
    private static final Map<Chapter, List<? extends AbstractPuzzle>> puzzles = new HashMap<>();
    private static final PuzzlesSingleton singleton = new PuzzlesSingleton();

    private static final String CHAPTER_PACKAGE_SUFFIX = "chap";
    private static final String CLASS_SUFFIX = ".class";
    private static final String PUZZLE_PREFIX = "Puzzle";
    private static final String QUOTE = ".";
    private static final String DOLLAR = "$";

    private PuzzlesSingleton() {
        for (Chapter chapter : Chapter.values()) {
            puzzles.put(chapter, getClasses(chapter));
        }
    }

    public static PuzzlesSingleton getInstance() {
        return singleton;
    }

    private static <T extends AbstractPuzzle> List<T> getClasses(Chapter chapter) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        final String resourceName = (CHAPTER_PACKAGE_SUFFIX + chapter.getValue()).replace('.', '/');
        List<T> classes = new ArrayList<>();
        try {
            Enumeration<URL> enumeration = classLoader.getResources(resourceName);
            while (enumeration.hasMoreElements()) {
                URL url = enumeration.nextElement();
                ArrayList<File> puzzleFiles = getSortedClassFiles(url.getPath());
                for (File puzzleFile : puzzleFiles) {
                    String classPackageName = getPackageName(chapter, puzzleFile);
                    T puzzleClass = (T) Class.forName(classPackageName).getDeclaredConstructor().newInstance();
                    classes.add(puzzleClass);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classes;
    }

    private static ArrayList<File> getSortedClassFiles(String rootPath) {
        File rootDir = new File(rootPath);
        ArrayList<File> puzzleFiles = getFilteredFiles(rootDir);
        assert puzzleFiles != null;
        puzzleFiles.sort(new Comparator<File>() {
            @Override
            public int compare(File file1, File file2) {
                int file1ClassNumber = getPuzzleNumberByClassName(file1.getName());
                int file2ClassNumber = getPuzzleNumberByClassName(file2.getName());
                return file1ClassNumber >= file2ClassNumber ? 1 : -1;
            }
        });
        return puzzleFiles;
    }

    private static ArrayList<File> getFilteredFiles(File rootDir) {
        ArrayList<File> ret = new ArrayList<>();
        for (File file : Objects.requireNonNull(rootDir.listFiles())) {
            if (!isClass(file)) continue;
            if (isAnonymousClass(file)) continue;
            if (!isPuzzleClass(file)) continue;
            ret.add(file);
        }
        return ret;
    }

    private static boolean isClass(File file) {
        return file.getName().endsWith(CLASS_SUFFIX);
    }

    private static boolean isAnonymousClass(File file) {
        return file.getName().contains(DOLLAR);
    }

    private static boolean isPuzzleClass(File file) {
        return file.getName().startsWith(PUZZLE_PREFIX);
    }

    private static int getPuzzleNumberByClassName(String className) {
        String name = className.split(Pattern.quote(QUOTE))[0];
        return Integer.parseInt(name.substring(6));
    }

    private static String getPackageName(Chapter chapter, File puzzleFile) {
        return CHAPTER_PACKAGE_SUFFIX + chapter.getValue() + QUOTE + puzzleFile.getName().split(Pattern.quote(QUOTE))[0];
    }

    public static List<? extends IPuzzle> getPuzzlesByChapter(Chapter chapter) {
        return puzzles.get(chapter);
    }
}
