package recursion.lcs;

import java.util.Arrays;

public class LCSMemo {

    public static int LCS(String a, String b) {
        int[][] memo = new int[a.length()][b.length()];
        for (int[] x : memo) {
            Arrays.fill(x, -1);
        }

        return LCS(a, b, 0, 0, memo);
    }

    private static int LCS(String a, String b, int i, int j, int[][] memo) {
        if (i == a.length() || j == b.length()) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (a.charAt(i) == b.charAt(j)) {
            memo[i][j] = 1 + LCS(a, b, i + 1, j + 1, memo);
        } else {
            memo[i][j] = Math.max(
                    LCS(a, b, i + 1, j, memo),
                    LCS(a, b, i, j + 1, memo)
            );
        }

        return memo[i][j];
    }
}
