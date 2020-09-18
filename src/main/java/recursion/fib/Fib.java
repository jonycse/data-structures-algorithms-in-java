package recursion.fib;

public class Fib {

    public static long fib(int n) {
        if (n <= 0) {
            return 0L;
        }
        if (n <= 2) {
            return 1L;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
