public class Util {
    // すべてのコンストラクタは明示的・暗黙的にスーパークラスのコンストラクタを呼び出さなければならない。
    // Utilクラスのコンストラクタはprivateなので、Utilを継承したサブクラスは作成できない。
    private Util() {
        throw new AssertionError();
    }
}

//class UtilSub extends Util {
//}