package dsalgo.sort;

public class InsertionSort {

    public static void sort(int[] a) {
        int n = a.length;
        for (int step = 1; step < n; step++) {
            int value = a[step];
            int i = step - 1;

            while (i >= 0 && value < a[i]) {
                a[i + 1] = a[i];
                i--;
            }
            a[i + 1] = value;
        }
    }
}
