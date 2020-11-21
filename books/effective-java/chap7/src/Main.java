import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        // 44
        // 関数オブジェクト(lambda)をapiUsingFuncObjに渡している
        apiUsingFuncObj((subjectWord, objectWord) -> subjectWord + " love " + objectWord);
    }

    public static void apiUsingFuncObj(BinaryOperator<String> funcSpecifiedByUser) {
        // applyは引数の型と同じ型を返す。
        System.out.println(funcSpecifiedByUser.apply("I", "you"));
    }
}
