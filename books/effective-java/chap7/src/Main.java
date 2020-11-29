import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // 44
        // 関数オブジェクト(lambda)をapiUsingFuncObjに渡している
        apiUsingFuncObj((subjectWord, objectWord) -> subjectWord + " love " + objectWord);

        // 47 検証
        // Streamはfor-each構文で使用できない
        Stream<String> stream = Stream.of("A","B","C","D","E");
//        for (String e : stream) {  // for each not applicable.
//        }
        // Iterableにキャストすれば使えるが、そもそも呼び出し側でこんな処理を書きたくない
        for (String e : (Iterable<String>) stream::iterator) {
            System.out.println(e);
        }

        Stream<String> stream2 = Stream.of("A","B","C","D","E");
        // アダプターメソッドを介してfor-eachを使う場合
        // 明示的なキャストの記述を避けられるsakerareru
        for (String e : iterableOf(stream2)) {
            System.out.println(e);
        }
        System.out.println();

        // Collection<E>を実装しているArrayListであれば、
        // for-each, streamどちらの文脈でも使用できる。
        ArrayList<String> arr = new ArrayList<>();
        arr.add("a"); arr.add("1"); arr.add("b"); arr.add("2");
        for (String e : arr) {
            System.out.println(e);
        }
        System.out.println();
        arr.forEach(System.out::println);

        // 50 検証
        // endはPeriodと参照を共有しているので、状態を変更できてしまう
        Date start = new Date();
        Date end = new Date();
        System.out.println(end.toString());
        Period p = new Period(start, end);
        end.setYear(78);
        System.out.println(p.toString());

        System.out.println();
        end = new Date();
        Period2 p2 = new Period2(start, end);
        System.out.println(p2.toString());
    }

    public static void apiUsingFuncObj(BinaryOperator<String> funcSpecifiedByUser) {
        // applyは引数の型と同じ型を返す。
        System.out.println(funcSpecifiedByUser.apply("I", "you"));
    }

    public static <E> Iterable<E> iterableOf(Stream<E> stream) {
        return stream::iterator;
    }

    private static class Period {
        private final Date start;
        private final Date end;

        public Period(Date start, Date end) {
            if (start.compareTo(end) > 0)
                throw new IllegalArgumentException(start + " after " + end);
            this.start = start;
            this.end = end;
        }

        public Date start() {
            return start;
        }

        public Date end() {
            return end;
        }

        public String toString() {
            return this.end.toString();
        }
    }

    private static class Period2 {
        private final Date start;
        private final Date end;

        public Period2(Date start, Date end) {
            this.start = new Date(start.getTime());
            this.end = new Date(end.getTime());
        }

        public Date start() {
            return new Date(start.getTime());
        }

        public Date end() {
            return new Date(end.getTime());
        }

        public String toString() {
            return this.end.toString();
        }
    }
}