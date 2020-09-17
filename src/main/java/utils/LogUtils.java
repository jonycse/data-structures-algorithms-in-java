package utils;

import java.util.List;
import java.util.Set;

public class LogUtils {
    public static void plInt(List<Integer> a) {
        String data = "", sp = "";
        for (Integer n : a) {
            data = data + sp + n;
            sp = " ";
        }
        System.out.println(data);
    }

    public static void plInt2d(List<List<Integer>> a) {
        for (List<Integer> n : a) {
            plInt(n);
        }
    }

    public static void plString(List<String> a) {
        String data = "", sp = "";
        for (String n : a) {
            data = data + sp + n;
            sp = ", ";
        }
        System.out.println(data);
    }

    public static void plString2d(List<List<String>> a) {
        for (List<String> n : a) {
            plString(n);
        }
    }

    public static void plLong(List<Long> a) {
        String data = "", sp = "";
        for (Long n : a) {
            data = data + sp + n;
            sp = " ";
        }
        System.out.println(data);
    }

    public static void paBool(boolean[] a) {
        String data = "", sp = "";
        for (boolean n : a) {
            data = data + sp + (n == true ? 1 : 0);
            sp = " ";
        }
        System.out.println(data);
    }

    public static void paBool(boolean[][] a) {
        String data = "", sp = "";
        for (boolean[] x : a) {
            paBool(x);
        }
    }

    public static void paInt(int[] a) {
        String data = "", sp = "";
        for (int n : a) {
            data = data + sp + n;
            sp = " ";
        }
        System.out.println(data);
    }


    public static void paChar(char[] a) {
        String data = "", sp = "";
        for (char n : a) {
            data = data + sp + n;
            sp = " ";
        }
        System.out.println(data);
    }

    public static void paChar2d(char[][] a) {
        for (char[] x : a) {
            paChar(x);
        }
    }

    public static void paInt2d(int[][] a) {
        for (int[] n : a) {
            paInt(n);
        }
    }

    public static void paString(String[] a) {
        String data = "", sp = "";
        for (String n : a) {
            data = data + sp + n;
            sp = " ";
        }
        System.out.println(data);
    }

    public static String psInt(Set<Integer> set, boolean isPrint) {
        String data = "", sp = "";
        for (Integer n : set) {
            data = data + sp + n;
            sp = " ";
        }
        if (isPrint) {
            System.out.println(data);
        }
        return data;
    }
}
