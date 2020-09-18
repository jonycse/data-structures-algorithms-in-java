package strings;


/**
 * Add two string numbers
 */
public class StringAdd {

    public static String add(String a, String b) {

        // make sure length(a) >= length(b)
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }

        StringBuilder sum = new StringBuilder("");

        int i = a.length() - 1;
        int carry = 0;

        for (int j = b.length() - 1; j >= 0; j--, i--) {
            int x = Character.getNumericValue(a.charAt(i));
            int y = Character.getNumericValue(b.charAt(j));
            int s = x + y + carry;
            sum.append(s % 10);
            carry = s / 10;
        }

        while (i >= 0) {
            int x = Character.getNumericValue(a.charAt(i));
            int s = x + carry;
            sum.append(s % 10);
            carry = s / 10;
            i--;
        }

        if (carry != 0) {
            sum.append(carry);
        }

        return sum.reverse().toString();
    }

}
