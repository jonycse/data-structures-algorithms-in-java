package recursion.reversenum;


public class ReverseNum {

    public int reverse(int n) {
        return reverse(n, numLen(n));
    }

    private int reverse(int n, int numLen) {
        if (numLen == 1) {
            return n;
        }

        return (n % 10) * (int) Math.pow(10, numLen - 1) + reverse(n / 10, numLen - 1);
    }

    private int numLen(int n) {
        if (n < 10) {
            return 1;
        }
        int c = 0;
        while (n > 0) {
            n = n / 10;
            c++;
        }
        return c;
    }
}
