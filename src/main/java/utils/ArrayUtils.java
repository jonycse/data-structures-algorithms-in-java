package utils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ArrayUtils {
    public static int getSumOfInt(int[] a) {
        int sum = 0;
        for (int n : a) {
            sum += n;
        }
        return sum;
    }

    public static boolean isEqualI(Collection<Integer> ac, Collection<Integer> bc) {
        if (ac == null || bc == null) {
            return false;
        }
        Object[] a = ac.toArray();
        Object[] b = bc.toArray();
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEqual(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }


    public static boolean isEqualS(List<String> a, List<String> b) {

        if (a == null || b == null) {
            return false;
        }
        if (a.size() != b.size()) {
            return false;
        }
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return false;
            }
        }
        return true;
    }
}
