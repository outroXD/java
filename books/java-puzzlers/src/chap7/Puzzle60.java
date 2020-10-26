package chap7;

import common.AbstractPuzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Pattern;

public class Puzzle60 extends AbstractPuzzle {

    public Puzzle60() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        System.out.println("[A]");
        List<String> aIn = new ArrayList<String>(Arrays.asList(
                "spam", "sausage", "spam", "spam", "bacon", "spam", "tomato", "spam"));
        System.out.println(aIn);
        List<String> aOut = getA(aIn);
        System.out.println(aOut);

        System.out.println("[B]");
        String bIn = "fear, surprise, ruthless efficiency, an almost fanatical devotion to the pope, nice red uniforms";
        String[] bOut = bIn.split(Pattern.quote(","));
        for (String out : bOut) {
            System.out.println(out);
        }

        System.out.println("[C]");
        Object[][] cIn = new Object[][]{};
        for (Object o1 : cIn) {
            for (Object o2 : cIn) {
                System.out.println(o2);
            }
        }

        System.out.println("[D]");
        boolean dOut = getC(3, 1);
        System.out.println(dOut);
    }

    @Override
    public void showCorrect() {
        System.out.println("[A]");
        List<String> aIn = new ArrayList<String>(Arrays.asList(
                "spam", "sausage", "spam", "spam", "bacon", "spam", "tomato", "spam"));
        List<String> aOut = withoutDuplucates(aIn);
        System.out.println(aOut);

    }

    private List<String> getA(List<String> strs) {
        List<String> out = new ArrayList<>();
        for (String str : strs) {
            if (!out.contains(str)) {
                out.add(str);
            }
        }
        return out;
    }

    private boolean getC(int i, int j) {
        return (Integer.bitCount(i) > Integer.bitCount(j));
    }

    static <E> List<E> withoutDuplucates(List<E> original) {
        return new ArrayList<E>(new LinkedHashSet<E>(original));
    }
}