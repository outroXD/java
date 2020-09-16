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
    public ClassSample() {}
    public void out(String classname) {
        System.out.println(this.sample + ":from " + classname);
    }
}
