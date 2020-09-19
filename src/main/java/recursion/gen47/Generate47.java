package recursion.gen47;

import java.util.*;


public class Generate47 {


    public static List<Integer> generate(int MAX) {
        List<Integer> nums = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        generate(stack, MAX, nums);

        Collections.sort(nums);

        return nums;
    }

    private static void generate(Stack<Integer> stack, int max, List<Integer> nums) {
        int x = getNum(stack);

        if (x > max) {
            return;
        }
        if (x != 0) {
            nums.add(x);
        }
        stack.push(4);
        generate(stack, max, nums);
        stack.pop();

        stack.push(7);
        generate(stack, max, nums);
        stack.pop();
    }

    // [2, 1, 3] => 213
    // [4, 5, 6] => 465
    private static int getNum(Stack<Integer> stack) {
        int num = 0;

        Iterator<Integer> it = stack.iterator();
        while (it.hasNext()) {
            int x = it.next();
            num = num * 10 + x;
        }
        return num;
    }

    private static void removeLaseDigit(StringBuilder sb) {
        sb.deleteCharAt(sb.length() - 1);
    }

}
