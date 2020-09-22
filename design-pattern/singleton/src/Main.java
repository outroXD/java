public class Main {
    public static void main(String[] args) {
        System.out.println("Start");

        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        if (obj1 == obj2) {
            System.out.println("同じインスタンス");
        } else {
            System.out.println("異なるインスタンス");
        }

        System.out.println("End");
    }
}
