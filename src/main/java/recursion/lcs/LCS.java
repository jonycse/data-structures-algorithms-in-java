package recursion.lcs;

public class LCS {

    public static int LCS(String a, String b) {

        return LCS(a, b, 0, 0);
    }

    private static int LCS(String a, String b, int i, int j) {

        if (i == a.length() || j == b.length()) {
            return 0;
        }
        if (a.charAt(i) == b.charAt(j)) {
            return 1 + LCS(a, b, i + 1, j + 1);
        }
        return Math.max(
                LCS(a, b, i + 1, j),
                LCS(a, b, i, j + 1)
        );
    }
}
