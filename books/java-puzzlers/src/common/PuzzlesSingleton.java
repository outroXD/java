package common;

import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.*;

public class PuzzlesSingleton {

    // TODO puzzlesより先にsingletonを記述すると実行時エラー 順序に依存している。
    private static final Map<Chapter, List<? extends AbstractPuzzle>> puzzles = new HashMap<>();
    private static final PuzzlesSingleton singleton = new PuzzlesSingleton();

    private static final String CHAPTER_PACKAGE_SUFFIX = "chap";
    private static final String CLASS_SUFFIX = ".class";

    private PuzzlesSingleton() {
        for (Chapter chapter : Chapter.values()) {
            puzzles.put(chapter, getClasses(chapter));
        }
    }

    private static <T extends AbstractPuzzle> List<T> getClasses(Chapter chapter) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        final String resourceName = (CHAPTER_PACKAGE_SUFFIX + chapter.getValue()).replace('.', '/');
        List<T> classes = new ArrayList<>();
        try {
            Enumeration<URL> enumeration = classLoader.getResources(resourceName);
            while (enumeration.hasMoreElements()) {
                URL url = enumeration.nextElement();
                File dir = new File(url.getPath());
                for (String path : Objects.requireNonNull(dir.list())) {
                    if (path.endsWith(CLASS_SUFFIX) && isAnonymousClass(path)) {
                        String classPackageName = CHAPTER_PACKAGE_SUFFIX + chapter.getValue() + "." + path.substring(0, path.length() - 6);
                        T puzzle = (T) Class.forName(classPackageName).getDeclaredConstructor().newInstance();
                        classes.add(puzzle);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classes;
    }

    private static boolean isAnonymousClass(String path) {
        return !path.contains("$");
    }

    public static PuzzlesSingleton getInstance() {
        return singleton;
    }

    public static List<? extends IPuzzle> getPuzzlesByChapter(Chapter chapter) {
        return puzzles.get(chapter);
    }
}
