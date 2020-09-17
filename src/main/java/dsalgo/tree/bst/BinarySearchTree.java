package dsalgo.tree.bst;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    private BstNode root;

    public BinarySearchTree() {
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    private BstNode insert(BstNode node, int key) {

        if (node == null) {
            node = new BstNode(key);
            return node;
        }
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        }

        return node;
    }

    public boolean search(int key) {
        BstNode node = search(root, key);

        return node != null;
    }

    private BstNode search(BstNode root, int key) {
        if (root == null || root.key == key) {
            return root;
        }

        if (key < root.key) {
            return search(root.left, key);
        }
        return search(root.right, key);
    }

    /**
     * Calculate LCA from BST, -1 if no LCA has found
     */
    public int lca(int u, int v) {

        // both value should exists in tree
        if (!search(u) || !search(v)) {
            return -1;
        }

        BstNode node = lca(root, u, v);

        return node == null ? -1 : node.key;
    }

    private BstNode lca(BstNode node, int u, int v) {
        if (node == null) {
            return null;
        }
        if (node.key > u && node.key > v) {
            return lca(node.left, u, v);
        }
        if (node.key < u && node.key < v) {
            return lca(node.right, u, v);
        }
        return node;
    }

    /**
     * Determine bst is valid or not
     *
     * @return
     */
    public boolean isValidBST() {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(BstNode node, int minValue, int maxValue) {
        if (node == null) {
            return true;
        }
        // System.out.println("Key: " + node.val + " Min " + minValue + " Max " + maxValue);
        if (node.key <= minValue || node.key >= maxValue) {
            return false;
        }
        return isValidBST(node.left, minValue, node.key) && isValidBST(node.right, node.key, maxValue);
    }

    /**
     * return the sorted array
     *
     * @return
     */
    public List<Integer> inOrder() {
        List<Integer> ordered = new ArrayList<>();
        inOrder(root, ordered);
        return ordered;
    }

    private void inOrder(BstNode root, List<Integer> ordered) {
        if (root == null) {
            return;
        }
        inOrder(root.left, ordered);
        ordered.add(root.key);
        inOrder(root.right, ordered);
    }

    public BstNode toBst(List<Integer> inorderSortedBst) {

        return toBst(0, inorderSortedBst.size() - 1, inorderSortedBst);
    }

    private BstNode toBst(int b, int e, List<Integer> inorderSortedBst) {
        if (b > e) {
            return null;
        }
        int m = (b + e) / 2;
        BstNode root = new BstNode(inorderSortedBst.get(m));
        // m is root, for this reason need ignore m
        root.left = toBst(b, m - 1, inorderSortedBst);
        root.right = toBst(m + 1, e, inorderSortedBst);

        return root;
    }

    public BstNode getRoot() {
        return root;
    }
}
