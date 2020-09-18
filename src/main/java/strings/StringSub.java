package strings;


/**
 * Subtract two string numbers
 */
public class StringSub {

    public static String subtract(String a, String b) {

        StringBuilder sub = new StringBuilder("");
        if (a.equals(b)) {
            return "0";
        }
        boolean bGraterThanA = isBGraterThanA(a, b);
        if (bGraterThanA) {
            String t = a;
            a = b;
            b = t;
        }
        int i = a.length() - 1, carry = 0;
        for (int j = b.length() - 1; j >= 0; i--, j--) {
            carry = calc(a.charAt(i), b.charAt(j), carry, sub);
        }

        while (i >= 0) {
            carry = calc(a.charAt(i), '0', carry, sub);
            i--;
        }

        // remove leading zero
        i = sub.length() - 1;
        while (sub.charAt(i) == '0') {
            i--;
        }

        StringBuilder result = new StringBuilder(sub.substring(0, i + 1));
        if (bGraterThanA) {
            result.append("-");
        }

        return result.reverse().toString();
    }


    private static int calc(char cx, char cy, int carry, StringBuilder sub) {

        int x = Character.getNumericValue(cx);
        int y = Character.getNumericValue(cy);
        int d = x - y - carry;
        carry = 0;
        if (d < 0) {
            d += 10;
            carry = 1;
        }
        sub.append(d);
        return carry;
    }

    private static boolean isBGraterThanA(String a, String b) {

        if (a.length() != b.length()) {
            return b.length() > a.length();
        }
        for (int i = 0; i < a.length(); i++) {
            int x = Character.getNumericValue(a.charAt(i));
            int y = Character.getNumericValue(b.charAt(i));
            if (x != y) {
                return y > x;
            }
        }
        return false;
    }

}
