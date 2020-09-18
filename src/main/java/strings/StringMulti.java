package strings;

/**
 * Multiply two string numbers, see also {@link StringAdd}
 */
public class StringMulti {

    public static String multi(String a, String b) {

        String result = "0";
        if (a.equals("0") || b.equals("0")) {
            return result;
        }
        int padZero = 0;
        for (int i = b.length() - 1; i >= 0; i--) {

            int m = Character.getNumericValue(b.charAt(i));
            String s = multiSingle(a, m, padZero++);
            result = StringAdd.add(result, s);
            //System.out.println(a+" * "+m+" = "+s);
        }
        return result;
    }


    private static String multiSingle(String a, int m, int padZero) {
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int s = carry + Character.getNumericValue(a.charAt(i)) * m;
            sb.append(s % 10);
            carry = s / 10;
        }
        if (carry != 0) {
            sb.append(carry);
        }

        sb = sb.reverse();

        // add trailing zero
        while (padZero > 0) {
            padZero--;
            sb.append("0");
        }

        return sb.toString();
    }
}
