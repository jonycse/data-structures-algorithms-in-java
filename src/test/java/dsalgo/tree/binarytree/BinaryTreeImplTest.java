package dsalgo.tree.binarytree;

import dsalgo.tree.binarytree.BinaryTreeImpl;
import dsalgo.tree.binarytree.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

public class BinaryTreeImplTest {

    @Test
    public void test1() {

             /*
                    1
                  /    \
                 2      3
                / \     /
               5  6    8
                  \   /
                  7  9



         */


        BinaryTreeNode root = new BinaryTreeNode(1);

        root.right = new BinaryTreeNode(3);
        root.right.left = new BinaryTreeNode(8);
        root.right.left.left = new BinaryTreeNode(9);

        root.left = new BinaryTreeNode(2);
        root.left.left = new BinaryTreeNode(5);
        root.left.right = new BinaryTreeNode(6);
        root.left.right.right = new BinaryTreeNode(7);


        BinaryTreeImpl tree = new BinaryTreeImpl();
        Assert.assertEquals(6, tree.getDiameter(root));
    }


    @Test
    @DisplayName("Check if a binary tree is mirror of itself")
    public void test2() {

        /*
                       1
                    /    \
                   3      3
                  / \     / \
                 6   7    7  6
                /             \
                8              8
         */

        BinaryTreeImpl tree = new BinaryTreeImpl();

        BinaryTreeNode root = new BinaryTreeNode(1);

        root.left = new BinaryTreeNode(3);
        root.right = new BinaryTreeNode(3);

        root.left.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(6);

        root.left.right = new BinaryTreeNode(7);
        root.right.left = new BinaryTreeNode(7);

        root.left.left.left = new BinaryTreeNode(8);
        root.right.right.right = new BinaryTreeNode(8);

        Assert.assertTrue(tree.isMirror(root));

        root.right.right.right.right = new BinaryTreeNode(9);
        Assert.assertFalse(tree.isMirror(root));
        root.right.right.right.right = null;
        root.right.right.right = new BinaryTreeNode(9);
        Assert.assertFalse(tree.isMirror(root));
        root.right.right.right = new BinaryTreeNode(8);
        Assert.assertTrue(tree.isMirror(root));
    }


    @Test
    public void test3() {
         /*
                        1
                    /      \
                   3       4
                  / \     /  \
                 6   7    17  16
                /             \
                8              8
         */

        BinaryTreeImpl tree = new BinaryTreeImpl();

        BinaryTreeNode root = new BinaryTreeNode(1);

        root.left = new BinaryTreeNode(3);
        root.right = new BinaryTreeNode(4);

        root.left.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(16);

        root.left.right = new BinaryTreeNode(7);
        root.right.left = new BinaryTreeNode(17);

        root.left.left.left = new BinaryTreeNode(8);
        root.right.right.right = new BinaryTreeNode(8);

        List<String> paths = tree.allPathFromRoot(root);
        Assert.assertEquals(4, paths.size());

        Assert.assertEquals("1 => 3 => 6 => 8", paths.get(0));
        Assert.assertEquals("1 => 3 => 7", paths.get(1));
        Assert.assertEquals("1 => 4 => 17", paths.get(2));
        Assert.assertEquals("1 => 4 => 16 => 8", paths.get(3));

    }

    @org.junit.jupiter.api.Test
    public void testRemoveLeapNode() {

        /*
                     1
                   /   \
                  2     3
                 /     / \
                2     2   4


         */
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.left.left = new BinaryTreeNode(2);

        root.right = new BinaryTreeNode(3);
        root.right.right = new BinaryTreeNode(4);
        root.right.left = new BinaryTreeNode(2);


        root = BinaryTreeImpl.removeLeapNodeOfValuex(root, 2);

        Assert.assertEquals(null, root.left);
        Assert.assertEquals(null, root.right.left);
        Assert.assertEquals(3, root.right.val);
        Assert.assertEquals(4, root.right.right.val);
    }
}
