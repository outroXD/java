public class ClassStatements {
    public static void main(String args[]) {
        // staticフィールドはインスタンス全体で共有される
        ClassSample sampleA = new ClassSample();
        ClassSample sampleB = new ClassSample();
        sampleA.out("sampleA");
        sampleB.out("sampleB");
    }
}

class ClassSample {
    private static String sample = "this is test!";
    static private String sample2 = "this is tesr!2";  // アクセス修飾子とstatic宣言は逆でもOK
    public ClassSample() {}
    public void out(String classname) {
        System.out.println(this.sample + ":from " + classname);
        System.out.println(this.sample2 + ":from " + classname);
    }
}
