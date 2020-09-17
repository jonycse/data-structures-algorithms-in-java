package dsalgo.tree.traversal;

public class TreeNode {

    public TreeNode(int key) {
        this.val = key;
    }

    public int descendents = 0;

    public int val;
    public TreeNode left, right;

    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public String toString() {
        if (this == null) {
            return "null";
        }
        return "val=" + val;

    }
}
