package dsalgo.binarysearch;

public class BinarySearchImpl {
    // Get First occurrence using binary search
    public static int bSearchFirstOccurrence(int[] a, int n, int target) {
        if (n == 0 || a[0] > target) {
            return -1;
        }
        if (a[0] == target) {
            return 0;
        }
        int b = 0, e = n - 1;
        int m = (b + e) / 2;
        while (b < e) {
            if (a[m] > target) {
                e = m - 1;
            } else if (a[m] < target) {
                b = m + 1;
            } else if (a[m] == target) {
                if (a[m - 1] == target) {
                    e = m - 1;
                } else {
                    break;
                }
            }
            m = (b + e) / 2;
        }

        return a[m] == target ? m : -1;
    }

    // Get Last occurrence using binary search
    public static int bSearchLastOccurrence(int[] a, int n, int target) {
        if (n == 0 || a[0] > target) {
            return -1;
        }
        if (a[n - 1] == target) {
            return n - 1;
        }
        int b = 0, e = n - 1;
        int m = (b + e) / 2;
        while (b < e) {
            if (a[m] > target) {
                e = m - 1;
            } else if (a[m] < target) {
                b = m + 1;
            } else if (a[m] == target) {
                if (a[m + 1] == target) {

                    b = m + 1;
                } else {
                    break;
                }
            }
            m = (b + e) / 2;

        }
        return a[m] == target ? m : -1;
    }
}
