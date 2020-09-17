package utils;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SortUtils {
    public static boolean isSortedArrayAsc(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i].compareTo(a[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSortedArrayAsc(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSortedArray(List<Integer> a, boolean orderAscending) {
        for (int i = 0; i < a.size() - 1; i++) {
            if (orderAscending) {
                if (a.get(i).compareTo(a.get(i + 1)) > 0) {
                    return false;
                }
            } else {
                if (a.get(i).compareTo(a.get(i + 1)) < 0) {
                    return false;
                }
            }

        }
        return true;
    }


    public static boolean isSortedArrayDesc(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i].compareTo(a[i + 1]) < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSortedArrayDesc(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] getNRandomElements(int n) {

        return getNRandomElementsWithBound(n, -1);
    }


    public static Integer[] getNRandomElements(int n, int bound) {

        return getNRandomElementsWithBound(n, bound);
    }

    /**
     * Generate random integer with bound (optional)
     *
     * @param bound: pass -1 if not required
     */
    private static Integer[] getNRandomElementsWithBound(int n, int bound) {

        Integer[] data = new Integer[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            if (bound <= 0) {

                data[i] = rand.nextInt();

            } else {
                data[i] = rand.nextInt(bound);
            }
        }

        return data;
    }

    public static void shuffle(List<Integer> a) {
        Collections.shuffle(a);
    }

    public static void shuffle(int[] a) {

        int n = a.length;
        Random random = new Random();
        for (int i=0;i<n;i++){
            int p = random.nextInt(n);
            swap(a, i, p);
        }
    }

    private static void swap(int[] a, int i, int j) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }
}
