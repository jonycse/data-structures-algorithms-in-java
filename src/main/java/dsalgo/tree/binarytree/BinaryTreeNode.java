package dsalgo.tree.binarytree;

public class BinaryTreeNode {
    public BinaryTreeNode(int key) {
        this.val = key;
        this.diameter = 0;
        this.depth = 0;
    }

    public int val;
    public BinaryTreeNode left, right;
    public int diameter;
    public int depth; // distance from root

    public boolean isLeaf() {
        return left == null && right == null;
    }
}
