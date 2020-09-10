import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
//        example64();
        example65();
    }

    public static void example64() {
        // lambda defined function
        Function<String, Integer>
                fsil1 = s -> Integer.parseInt(s),
                fsil2 = s -> { return Integer.parseInt(s); },
                fsil3 = (String s) -> Integer.parseInt(s),
                fsil4 = (final String s) -> Integer.parseInt(s);

        BiFunction<String, Integer, String>
                fsis1 = (s, i) -> s.substring(i, Math.min(i+3, s.length())),
                fsis2 = (s, i) -> { int to = Math.min(i+3, s.length()); return s.substring(i, to); };

        BiFunction<String, String, String>
                concat = (s1, s2) -> s1 + s2;

        Supplier<String>
                now = () -> new java.util.Date().toString();

        Consumer<String>
                show1 = s -> System.out.println(">>>" + s + "<<<"),
                show2 = s -> { System.out.println(">>>" + s + "<<<"); };

        Function<String[], String>
                fsas1 = ss -> String.join(":", ss),
                fsas2 = (String[] ss) -> String.join(":", ss),
                fsas3 = (String... ss) -> String.join(":", ss);

        // call lambda defined function
        System.out.println(fsil1.apply("004711"));
        System.out.println(fsis1.apply("abcdef", 4));
        show1.accept(now.get());
        System.out.println(fsas1.apply(new String[] {"abc", "DEF"}));
    }

    public static void example65() {
        Function<String, Function<String, String>> prefix = s1 -> s2 -> s1 + s2;
        Function<String, String> addDollar = prefix.apply("$");
        BiFunction<Function<String, String>, String, String> twice = (f, s) -> f.apply(f.apply(s));
        Function<String, String> addTwiceDollars = s -> twice.apply(addDollar, s);
        prefix.apply("$").apply("100");
        addDollar.apply("100");
        addTwiceDollars.apply("100");
    }
}
