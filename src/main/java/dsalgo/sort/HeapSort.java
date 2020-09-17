package dsalgo.sort;

public class HeapSort {

    public static void sort(int a[]) {
        int n = a.length;

        // Build heap (rearrange array)
        // (n/2 - 1) is first non leaf node
        for (int i = n / 2 - 1; i >= 0; i--) {
            // build max heap
            heapify(a, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            swap(a, i, 0); // n = i = n - 1
            // call max heapify on the reduced heap
            heapify(a, i, 0);
        }
    }

    // heapify(p): move p to correct position in heap
    private static void heapify(int a[], int n, int p) {
        int largest = p;
        int left = 2 * p + 1;
        int right = 2 * p + 2;

        // use a[left] < a[largest] for descending
        if (left < n && a[left] > a[largest]) {
            largest = left;
        }

        // use a[right] < a[largest] for descending
        if (right < n && a[right] > a[largest]) {
            largest = right;
        }

        if (largest != p) {
            swap(a, p, largest);
            heapify(a, n, largest);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
