package dsalgo.tree.bst;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BinarySearchTreeTest {

    @Test
    public void validateBstConstruction() {
        /**
         *                    5
         *                  /   \
         *                 2    10
         *                / \   /  \
         *                1  3 6    11
         *               /           \
         *               0            100
         *
         */
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(2);
        bst.insert(10);
        bst.insert(10);// will not inserted
        bst.insert(11);
        bst.insert(100);
        bst.insert(100);// will not inserted
        bst.insert(1);
        bst.insert(0);
        bst.insert(6);
        bst.insert(3);

        BstNode root = bst.getRoot();

        Assert.assertEquals(5, root.key);

        Assert.assertEquals(2, root.left.key);
        Assert.assertEquals(10, root.right.key);

        Assert.assertEquals(6, root.right.left.key);
        Assert.assertEquals(11, root.right.right.key);
        Assert.assertEquals(100, root.right.right.right.key);
        Assert.assertEquals(null, root.right.right.left);

        Assert.assertEquals(1, root.left.left.key);
        Assert.assertEquals(0, root.left.left.left.key);
        Assert.assertEquals(null, root.left.left.right);
        Assert.assertEquals(3, root.left.right.key);
    }

    @Test
    @DisplayName("Test BST")
    public void test1() {
        /**
         *                    5
         *                  /   \
         *                 2    10
         *                / \   /  \
         *                1  3 6    11
         *               /           \
         *               0            100
         *
         */
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(2);
        bst.insert(10);
        bst.insert(10);// will not inserted
        bst.insert(11);
        bst.insert(100);
        bst.insert(100);// will not inserted
        bst.insert(1);
        bst.insert(0);
        bst.insert(6);
        bst.insert(3);

        Assert.assertTrue(bst.search(10));
        Assert.assertTrue(bst.search(100));
        Assert.assertFalse(bst.search(99));

        System.out.println("In-order traverse BST");
        List<Integer> inorderSortedBst = bst.inOrder();
        //  0 1 2 5 10 11 100
        Assert.assertTrue(isSortedArray(inorderSortedBst, true));

        System.out.println("BST LCA");
        Assert.assertEquals(5, bst.lca(0, 11));
        Assert.assertEquals(10, bst.lca(6, 100));
        Assert.assertEquals(5, bst.lca(3, 11));
        Assert.assertEquals(1, bst.lca(0, 1));
        Assert.assertEquals(-1, bst.lca(0, 12));
        Assert.assertEquals(11, bst.lca(100, 11));
        Assert.assertEquals(5, bst.lca(100, 0));


        System.out.println("Construct new bst from inorder sorted value, it is also balanced BST");
        BstNode rootNew = bst.toBst(inorderSortedBst);
        System.out.println("New root: " + rootNew.key);
        System.out.println("Child of " + rootNew.key + " L " + +rootNew.left.key + " R " + rootNew.right.key);
        /*
                    5
                  /   \
                 1     11
                / \    / \
               0   2  10  100

         */
    }


    @Test
    public void test2() {

        /**
         *                    5
         *                  /   \
         *                 2    10
         *                / \   /  \
         *                1  3 6    11
         *               /           \
         *               0            100
         *
         */
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(2);
        bst.insert(10);
        bst.insert(11);
        bst.insert(100);
        bst.insert(1);
        bst.insert(0);
        bst.insert(6);
        bst.insert(3);
        Assert.assertTrue(bst.isValidBST());


        /**
         *                    5
         *                  /   \
         *                 2    10
         *                / \   /  \
         *                1  3 6    11
         *               /    \       \
         *               0     7*       100
         *
         */
        BinarySearchTree invalid1 = new BinarySearchTree();
        invalid1.insert(5);
        invalid1.insert(2);
        invalid1.insert(10);
        invalid1.insert(11);
        invalid1.insert(100);
        invalid1.insert(1);
        invalid1.insert(0);
        invalid1.insert(6);
        invalid1.insert(3);
        BstNode root = invalid1.getRoot();
        root.left.right.right = new BstNode(7);
        Assert.assertFalse(invalid1.isValidBST());


        /**
         *                    5
         *                  /   \
         *                 2    10
         *                / \   /  \
         *                1  3 12*    11
         *               /           \
         *               0            100
         *
         */
        BinarySearchTree invalid2 = new BinarySearchTree();
        invalid2.insert(5);
        invalid2.insert(2);
        invalid2.insert(10);
        invalid2.insert(11);
        invalid2.insert(100);
        invalid2.insert(1);
        invalid2.insert(0);
        invalid2.insert(6);
        invalid2.insert(3);
        BstNode root2 = invalid2.getRoot();
        root2.right.left = new BstNode(12);
        Assert.assertFalse(invalid2.isValidBST());


    }

    private boolean isSortedArray(List<Integer> a, boolean orderAscending) {
        for (int i = 0; i < a.size() - 1; i++) {
            if (orderAscending) {
                if (a.get(i).compareTo(a.get(i + 1)) > 0) {
                    return false;
                }
            } else {
                if (a.get(i).compareTo(a.get(i + 1)) < 0) {
                    return false;
                }
            }

        }
        return true;
    }

}

