package dsalgo.tree.traversal;

import java.util.Stack;

public class TreeTraversalImpl {

    private TreeNode root;

    public TreeTraversalImpl(TreeNode root) {
        this.root = root;
    }

    /**
     * Return n'th node of in-order traversal
     */
    public int inOrderNthNode(int index) {
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
                if (index == 0) {
                    return current.val;
                }
                index--;
                current = current.right;
            }
        }
        return -1;
    }

    class State {
        public int counter = 0;
    }

    public int inOrderNthNodeRec(int index) {
        TreeNode node = inOrderNthNodeRec(root, new State(), index);
        return node == null ? -1 : node.val;
    }

    private TreeNode inOrderNthNodeRec(TreeNode root, State state, int index) {
        if (root == null) {
            return null;
        }
        TreeNode left = inOrderNthNodeRec(root.left, state, index);
        // we already found
        if (left != null) {
            return left;
        }
        if (state.counter == index) {
            return root;
        }
        state.counter++;
        return inOrderNthNodeRec(root.right, state, index);
    }


    public int inOrderNthNodeDecen(int k) {
        TreeNode node = inOrderNthNodeDecen(root, k);
        return node == null ? -1 : node.val;
    }

    private TreeNode inOrderNthNodeDecen(TreeNode node, int k) {
        if (node == null) {
            return null;
        }
        // 1 is fo node
        int left = node.left == null ? 0 : node.left.descendents + 1;
        if (left > k) {
            // result is in left node
            return inOrderNthNodeDecen(node.left, k);
        } else if (left == k) {
            // got the result
            return node;
        } else {
            // need to go right
            return inOrderNthNodeDecen(node.right, k - left - 1);
        }
    }
}
