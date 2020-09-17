package dsalgo.sort;

import utils.SortUtils;

public class QuickSort {

    public static void sort(int[] a) {

        // make sure elements are shuffled
        SortUtils.shuffle(a);

        qSort(a, 0, a.length - 1);
    }

    private static void qSort(int[] a, int lo, int hi) {
        if (lo >= hi){
            return;
        }

        int p = partition(a, lo, hi);
        // position p is fixed
        // all elements left of p is less than a[p]
        // all elements right of p is less greater than or equal a[p]
        qSort(a, lo, p - 1);
        qSort(a, p + 1, hi);
    }

    // pick pivot for hi
    private static int partition(int[] a, int lo, int hi) {

        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (a[j] < a[hi]) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, hi);
        // i+1 position is fixed for hi
        return i + 1;
    }

    private static void swap(int[] a, int i, int j) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }
}
