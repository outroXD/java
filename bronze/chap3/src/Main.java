public class Main {
    public static void main(String args[]) {
        // 整数同士の演算結果が少数の場合、小数点以下は切り捨て
        System.out.println(5 / 2);

        // 文字列連結演算子としての「+」は文字列がオペランドの場合は文字列の連結として扱われる。
        // 以下のコードでは整数がString型に変換された上で文字列の連結が行われる。
        System.out.println(10 + "5");
        System.out.println(5 + 10 + "5");

        // 「条件式」の結果はboolean型である必要がある
        // 条件式がboolean型を返さない場合、コンパイル時にエラーが発生する

        // 条件式ブロックを省略した場合、1行目だけが条件式ブロックとして扱われる。
        if (false)
            System.out.println("A");
            System.out.println("B");
            System.out.println("C");

        // switch文の式はchar, byte, short, int, Character, Byte, Short, Integer, String、列挙型
        // を戻す式でなければならない。
    }
}
