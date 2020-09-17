package dsalgo.binarysearch;

public class BinarySearch {
    /**
     * Search x is a, return index if found else return -1
     * a must be sorted
     */
    public static int search(int[] a, int x) {
        int lo = 0, hi = a.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (a[mid] < x) {
                lo = mid + 1;
            } else if (a[mid] > x) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
