package recursion.fib;

import java.util.Arrays;

public class FibMemo {

    private static int MAX = 10;
    private static long[] memoTable = new long[MAX + 1];

    static {
        Arrays.fill(memoTable, -1);
    }

    public static long fib(int n) {
        if (n > MAX) {
            throw new RuntimeException("Not supported");
        }
        if (n <= 0) {
            return 0L;
        }
        if (n <= 2) {
            return 1L;
        }
        // we already calculated this
        if (memoTable[n] != -1) {
            return memoTable[n];
        }
        memoTable[n] = fib(n - 1) + fib(n - 2);
        return memoTable[n];
    }
}
