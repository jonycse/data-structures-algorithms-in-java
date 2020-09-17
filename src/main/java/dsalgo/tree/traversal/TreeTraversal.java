package dsalgo.tree.traversal;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {

    private TreeNode root;

    public TreeTraversal(TreeNode root) {
        this.root = root;
    }

    public List<Integer> preOrder() {
        List<Integer> ordered = new ArrayList<>();
        preOrder(root, ordered);
        return ordered;
    }

    /*
     * print node
     * visit everything of left
     * visit everything of right
     * do this for each node
     *
     */
    private void preOrder(TreeNode current, List<Integer> ordered) {
        if (current == null) {
            return;
        }
        ordered.add(current.val);
        preOrder(current.left, ordered);
        preOrder(current.right, ordered);
    }

    public List<Integer> inOrder() {
        List<Integer> ordered = new ArrayList<>();
        inOrder(root, ordered);
        return ordered;
    }

    /*
     * start from root
     * visit everything of left
     * pop and print node
     * visit everything of right
     *
     * do this for each node
     *
     */
    private void inOrder(TreeNode current, List<Integer> ordered) {
        if (current == null) {
            return;
        }
        inOrder(current.left, ordered);
        ordered.add(current.val);
        inOrder(current.right, ordered);
    }

    public List<Integer> postOrder() {
        List<Integer> ordered = new ArrayList<>();
        postOrder(root, ordered);
        return ordered;
    }

    private void postOrder(TreeNode current, List<Integer> ordered) {
        if (current == null) {
            return;
        }
        postOrder(current.left, ordered);
        postOrder(current.right, ordered);
        ordered.add(current.val);
    }


    /**
     * A) push root
     * B) Pop all items one by one. Do following for every popped item
     * a) print it
     * b) push its right child
     * c) push its left child
     *
     * @return
     */
    public List<Integer> preOrderIterative() {

        List<Integer> ordered = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            ordered.add(current.val);

            if (current.right != null) {
                stack.add(current.right);
            }
            if (current.left != null) {
                stack.add(current.left);
            }
        }

        return ordered;
    }

    public List<Integer> inOrderIterative() {
        List<Integer> ordered = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (true) {

            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                if (stack.empty()) {
                    break;
                }
                current = stack.pop();
                ordered.add(current.val);
                current = current.right;
            }
        }
        return ordered;
    }

    public List<Integer> postOrderIterative() {
        List<Integer> ordered = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        stack.push(root);

        while (!stack.empty()) {
            TreeNode current = stack.peek();

            if (prev == null || prev.left == current || prev.right == current) {
                if (current.left != null) {
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                } else {
                    // for leaf node
                    ordered.add(stack.pop().val);
                }
            } else if (current.left == prev) {
                // go up the tree from left node
                if (current.right != null) {
                    stack.push(current.right);
                } else {
                    ordered.add(stack.pop().val);
                }
            } else if (current.right == prev) {
                // go up from right
                ordered.add(stack.pop().val);
            }
            prev = current;
        }
        return ordered;
    }

    public List<Integer> postOrderIterative2() {
        List<Integer> ordered = new ArrayList<>();

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stackDepthOrdered = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {

            TreeNode current = stack1.pop();
            stackDepthOrdered.push(current);

            if (current.left != null) {
                stack1.push(current.left);
            }
            if (current.right != null) {
                stack1.push(current.right);
            }
        }

        while (!stackDepthOrdered.isEmpty()) {
            ordered.add(stackDepthOrdered.pop().val);
        }

        return ordered;
    }


}
