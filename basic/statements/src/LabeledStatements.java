public class LabeledStatements {
    public static void main(String args[]) {
    }

    public static boolean example86(String query, String target) {
        nextposition:  // 最初のfor文へラベルをつけた
        for (int j = 0; j <= target.length() - query.length(); j++) {
            for (int k = 0; k < query.length(); k++) {
                if (target.charAt(j+k) != query.charAt(k)) {
                    continue nextposition;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean example87(String query, String target) {
        for (int j = 0; j <= target.length() - query.length(); j++) {
            thisposition: {  // block文に対してラベルをつけた
                for (int k = 0; k < query.length(); k++) {
                    if (target.charAt(j+k) != query.charAt(k)) {
                        break thisposition;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
