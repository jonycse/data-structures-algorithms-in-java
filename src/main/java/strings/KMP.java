package strings;

public class KMP {

    public static boolean hasSubstring(String str, String pattern) {

        int[] lps = getLps(pattern);

        int i = 0;
        int j = 0;
        while (i < str.length() && j < pattern.length()) {
            if (str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return j == pattern.length();
    }

    private static int[] getLps(String pattern) {
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        int j = 0;
        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
