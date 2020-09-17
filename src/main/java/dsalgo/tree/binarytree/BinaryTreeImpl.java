package dsalgo.tree.binarytree;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BinaryTreeImpl {

    public int getDiameter(BinaryTreeNode root) {

        return getDiameterAndDepth(root).diameter;
    }

    private BinaryTreeNode getDiameterAndDepth(BinaryTreeNode current) {
        if (current == null) {
            return null;
        }
        BinaryTreeNode left = getDiameterAndDepth(current.left);
        BinaryTreeNode right = getDiameterAndDepth(current.right);

        int leftDiameter = left != null ? left.diameter : 0;
        int leftDepth = left != null ? left.depth : 0;

        int rightDiameter = right != null ? right.diameter : 0;
        int rightDepth = right != null ? right.depth : 0;

        int parentDiameter = Math.max(Math.max(leftDiameter, rightDiameter), leftDepth + rightDepth);
        int parentDepth = Math.max(leftDepth, rightDepth) + 1;
        current.depth = parentDepth;
        current.diameter = parentDiameter;

        //System.out.println("=== "+ current.val);

        return current;
    }

    public boolean isMirror(BinaryTreeNode root) {
        return isMirror(root.left, root.right);
    }


    private boolean isMirror(BinaryTreeNode left, BinaryTreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }

        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }


    public List<String> allPathFromRoot(BinaryTreeNode root) {
        Stack<Integer> stack = new Stack<>();
        List<String> paths = new ArrayList<>();
        allPathFromRoot(root, stack, paths);
        return paths;
    }

    private void allPathFromRoot(BinaryTreeNode root, Stack<Integer> stack, List<String> paths) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            stack.push(root.val);
            savePath(stack, paths);
            stack.pop();
        } else {
            stack.push(root.val);
            allPathFromRoot(root.left, stack, paths);
            allPathFromRoot(root.right, stack, paths);
            stack.pop();
        }
    }

    public static BinaryTreeNode removeLeapNodeOfValuex(BinaryTreeNode current, int value) {
        if (current == null) {
            return null;
        }
        current.left = removeLeapNodeOfValuex(current.left, value);
        current.right = removeLeapNodeOfValuex(current.right, value);
        if (current.isLeaf() && current.val == value) {
            return null;
        }
        return current;
    }

    private void savePath(Stack<Integer> stack, List<String> paths) {

        String path = "", sp = "";

        Iterator<Integer> it = stack.iterator();
        while (it.hasNext()) {
            path = path + sp + it.next();
            sp = " => ";
        }
        // System.out.println(path);
        paths.add(path);
    }
}
