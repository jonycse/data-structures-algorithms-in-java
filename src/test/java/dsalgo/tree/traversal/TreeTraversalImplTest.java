package dsalgo.tree.traversal;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TreeTraversalImplTest {

    @Test
    public void testInOrderNthNode() {
         /*
             1
            / \
           2  3
          / \
         4  5

         */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeTraversalImpl tree = new TreeTraversalImpl(root);

        Assert.assertEquals(4, tree.inOrderNthNode(0));
        Assert.assertEquals(2, tree.inOrderNthNode(1));
        Assert.assertEquals(5, tree.inOrderNthNode(2));
        Assert.assertEquals(1, tree.inOrderNthNode(3));
        Assert.assertEquals(3, tree.inOrderNthNode(4));
        Assert.assertEquals(-1, tree.inOrderNthNode(5));
        Assert.assertEquals(-1, tree.inOrderNthNode(500));
    }


    @Test
    public void inorderTraversalNthNodeWithDescendents() {

        /*
                  1(8)
                /   \
              2(4)  3(2)
              /  \    / \
             4  5(2) 9  4
               / \
              6  7
         */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        // root right
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(4);

        // set counter
        root.descendents = 8;

        root.left.descendents = 4;
        root.left.right.descendents = 2;

        root.right.descendents = 2;

        TreeTraversalImpl tree = new TreeTraversalImpl(root);


        Assert.assertEquals(4, tree.inOrderNthNodeDecen(0));
        Assert.assertEquals(2, tree.inOrderNthNodeDecen(1));
        Assert.assertEquals(6, tree.inOrderNthNodeDecen(2));
        Assert.assertEquals(5, tree.inOrderNthNodeDecen(3));
        Assert.assertEquals(7, tree.inOrderNthNodeDecen(4));
        Assert.assertEquals(1, tree.inOrderNthNodeDecen(5));
        Assert.assertEquals(9, tree.inOrderNthNodeDecen(6));
        Assert.assertEquals(3, tree.inOrderNthNodeDecen(7));
        Assert.assertEquals(4, tree.inOrderNthNodeDecen(8));
        Assert.assertEquals(-1, tree.inOrderNthNodeDecen(9));
        Assert.assertEquals(-1, tree.inOrderNthNodeDecen(10));


        Assert.assertEquals(4, tree.inOrderNthNodeRec(0));
        Assert.assertEquals(2, tree.inOrderNthNodeRec(1));
        Assert.assertEquals(6, tree.inOrderNthNodeRec(2));
        Assert.assertEquals(5, tree.inOrderNthNodeRec(3));
        Assert.assertEquals(7, tree.inOrderNthNodeRec(4));
        Assert.assertEquals(1, tree.inOrderNthNodeRec(5));
        Assert.assertEquals(9, tree.inOrderNthNodeRec(6));
        Assert.assertEquals(3, tree.inOrderNthNodeRec(7));
        Assert.assertEquals(4, tree.inOrderNthNodeRec(8));
        Assert.assertEquals(-1, tree.inOrderNthNodeRec(9));
        Assert.assertEquals(-1, tree.inOrderNthNodeRec(10));
    }

}
