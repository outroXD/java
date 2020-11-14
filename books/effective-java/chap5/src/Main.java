import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    // ========== ジェネリクス ==========

    // Setの要素の型は「Eそのもの、または、Eのサブタイプ」
    public static <E> Set<E> union(Set<? extends E> s1,
                                   Set<? extends E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    // Tを「比較可能(Comparable)で、スーパークラスがTである型」と定義する
    // Listの要素の型は「型Tそのもの、または、Tのサブタイプ」
    public static <T extends Comparable<? super T>> T max(List<? extends T> list) {
        if (list.isEmpty())
            throw new IllegalArgumentException("Empty collection");
        T result = null;
        for (T e : list) {
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
        }
        return result;
    }

    static <T> T[] toArray(T... args) {
        // ジェネリックス → 配列への変換
        return args;
    }

//    static <T> T[] pickTwo(T a, T b, T c) {
//        switch (ThreadLocalRandom.current().nextInt(3)) {
//            case 0: return toArray(a, b);
//            case 1: return toArray(a, c);
//            case 2: return toArray(b, c);
//        }
//        throw new AssertionError();
//    }

    // 可変長パラメータ(配列)をリストに置き換える
    static <T> List<T> pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0: return List.of(a, b);
            case 1: return List.of(b, c);
            case 2: return List.of(a, c);
        }
        throw new AssertionError();
    }

    public static void main(String[] args) {
//        Set<String> s1 = new HashSet<>();
//        s1.add("A");
//        s1.add("B");
//        s1.add("C");
//        Set<String> s2 = new HashSet<>();
//        s2.add("D");
//        s2.add("A");
//        Set<String> res = union(s1, s2);
//        System.out.println("union: ");
//        for (String e : res) {
//            System.out.println(e);
//        }
//
//        System.out.println("max: ");
//        List<Integer> l1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
//        System.out.println(max(l1));

        // 項目32
        // コンパイラはpickTwoが返す値をString[]へキャストしている
        // pickTwoはObject[]を返す
        // Object[]はString[]のサブタイプではないので、コンパイラのキャスト時にエラー
        List<String> attributes = pickTwo("Good", "Fast", "Cheap");
        System.out.println("STOP");
    }
}