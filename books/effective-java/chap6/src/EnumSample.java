import com.sun.nio.file.ExtendedOpenOption;

import java.util.*;
import java.util.function.DoubleBinaryOperator;
import java.util.stream.Stream;

public class EnumSample {
    public static void main(String[] args) {
        // 37
        // Planetの要素をキーに、データ集合を紐付ける
        System.out.println("=== 37 ===");
        Map<Planet.LifeCycle, Set<Planet>> planetsByLifeCycle = new EnumMap<>(Planet.LifeCycle.class);
        for (Planet.LifeCycle lc : Planet.LifeCycle.values())
            planetsByLifeCycle.put(lc, new HashSet<>());
        System.out.println(planetsByLifeCycle);

        // 38
        System.out.println("=== 38 ===");
        double x = Double.parseDouble("0.2");
        double y = Double.parseDouble("0.5");
        test(BasicOperation.class, x, y);
        test(ExtendedOperation.class, x, y);
        test(Arrays.asList(ExtendedOperation.values()), x, y);

        // 42
        System.out.println("=== 42 ===");
        x = Double.parseDouble("0.2");
        y = Double.parseDouble("0.5");
        double ans1 = Operation42.PLUS.apply(x, y);
        System.out.println(ans1);
    }

    static class Planet {
        enum LifeCycle { ANNUAL, PERENNIAL, BIENNIAL }

        String name;
        LifeCycle lifeCycle;

        Planet(String name, LifeCycle lifeCycle) {
            this.name = name;
            this.lifeCycle = lifeCycle;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    enum Phase {
        SOLID, LIQUID, GAS;

        public enum Transition {
            MELT(SOLID, LIQUID),
            FREEZE(LIQUID, SOLID),
            BOIL(LIQUID, GAS),
            CONDENSE(GAS, LIQUID),
            SUBLIME(SOLID, GAS),
            DEPOSIT(GAS, SOLID);

            private final Phase from;
            private final Phase to;

            Transition(Phase from, Phase to) {
                this.from = from;
                this.to = to;
            }
        }
    }

    // 項目38
    // インターフェースを拡張する形でenumを定義すれば、
    public interface Operation {
        double apply(double x, double y);
    }

    // このenumクラスに対して機能を追加したいとする
    public enum BasicOperation implements Operation {
        PLUS("+") {
            @Override
            public double apply(double x, double y) {
                return x + y;
            }
        },
        MINUS("-") {
            @Override
            public double apply(double x, double y) {
                return x - y;
            }
        },
        TIMES("*") {
            @Override
            public double apply(double x, double y) {
                return x * y;
            }
        },
        DIVIDE("/") {
            @Override
            public double apply(double x, double y) {
                return x / y;
            }
        };

        private final String symbol;

        BasicOperation(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }
    }

    // 新機能として新しい演算を定義するときは、Operationを実装したenumクラスを追加する
    public enum ExtendedOperation implements Operation {
        EXP("^") {
            public double apply(double x, double y) {
                return Math.pow(x, y);
            }
        },
        REMAINDER("%") {
            @Override
            public double apply(double x, double y) {
                return x % y;
            }
        };

        private final String symbol;

        ExtendedOperation(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }
    }

    // Class<T>は境界型トークンとしての役割を担う
    // <T extends Enum<T> & Operation>: TはClassオブジェクトをenumでかつ、Operationのサブタイプであると定義している
    private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y) {
        for (Operation op : opEnumType.getEnumConstants())
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }

    // 境界ワイルドカード型による渡し方
    // オブジェクトを渡す代わりにこの渡し方でもOK
    private static void test(Collection<? extends Operation> opSet, double x, double y) {
        for (Operation op : opSet) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

    // 項目42
    // enum型のフィールド毎に固有の振る舞いを持たせたパターン
    // かつ、振る舞いをlambdaで定義した場合
    public enum Operation42 {
        PLUS ("+", (x, y) -> x + y),
        MINUS ("-", (x, y) -> x - y),
        TIMES ("*", (x, y) -> x * y),
        DIVIDE("/", (x, y) -> x / y);

        private final String symbol;
        private final DoubleBinaryOperator op;

        Operation42(String symbol, DoubleBinaryOperator op) {
            this.symbol = symbol;
            this.op = op;
        }

        @Override
        public String toString() {
            return symbol;
        }

        public double apply(double x, double y) {
            return op.applyAsDouble(x, y);
        }
    }
}
