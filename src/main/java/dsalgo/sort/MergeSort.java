package dsalgo.sort;

public class MergeSort {


    public static void sort(int[] a) {
        int[] aux = new int[a.length];
        sort(0, a.length - 1, a, aux);
    }

    private static void sort(int lo, int hi, int[] a, int[] aux) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        sort(lo, mid, a, aux);
        sort(mid + 1, hi, a, aux);
        merge(lo, mid, hi, a, aux);
    }

    private static void merge(int lo, int mid, int hi, int[] a, int[] aux) {

        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        int loLeft = lo;
        int hiLeft = mid + 1;

        for (int i = lo; i <= hi; i++) {

            if (loLeft > mid) {
                // all taken from left array
                a[i] = aux[hiLeft++];
            } else if (hiLeft > hi) {
                // all taken from right array
                a[i] = aux[loLeft++];
            } else if (aux[loLeft] < aux[hiLeft]) {
                // element of left array is less than right array
                a[i] = aux[loLeft++];
            } else {
                a[i] = aux[hiLeft++];
            }
        }
    }

}
