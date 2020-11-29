import java.util.Arrays;

public class Anagrams {
    public static void main(String[] args) {
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
