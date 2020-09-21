package recursion.editdistance;

import java.util.Arrays;

public class EditDistance {

    private int cost;
    private int[][] dp;
    private static int NIL = -1;

    public EditDistance(String sa, String sb) {


        dp = new int[sa.length() + 1][sb.length() + 1];
        for (int[] x : dp) {
            Arrays.fill(x, NIL);
        }

        cost = ed(sa, sb, sa.length(), sb.length());
    }

    private int ed(String sa, String sb, int n, int m) {

        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        if (dp[n][m] != NIL) {
            return dp[n][m];
        }

        if (sa.charAt(n - 1) == sb.charAt(m - 1)) {
            return ed(sa, sb, n - 1, m - 1);
        }
        dp[n][m] = 1 + min(
                ed(sa, sb, n - 1, m), // insert
                ed(sa, sb, n, m - 1), // remove
                ed(sa, sb, n - 1, m - 1) // replace
        );
        return dp[n][m];
    }

    private int min(int x, int y, int z) {
        return Math.min(x, Math.min(y, z));
    }

    public int getCost() {
        return cost;
    }
}
