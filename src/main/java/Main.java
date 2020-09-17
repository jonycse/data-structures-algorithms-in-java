public class Main {

    public static void main(String[] args) {

        System.out.println(reverse("Hello world"));
    }

    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
