package dsalgo.tree.traversal;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TreeTraversalTest {

    @Test
    @DisplayName("Test tree traversal")
    public void test1() {


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

        TreeTraversal tree = new TreeTraversal(root);

        System.out.println("Pre-order traverse");
        List<Integer> preOrder = tree.preOrder();
        Assert.assertEquals(Arrays.asList(1, 2, 4, 5, 3), preOrder);


        System.out.println("In-order traverse");
        List<Integer> inOrder = tree.inOrder();
        Assert.assertEquals(Arrays.asList(4, 2, 5, 1, 3), inOrder);
        Assert.assertEquals(Arrays.asList(4, 2, 5, 1, 3), tree.inOrderIterative());


        System.out.println("Post-order traverse");
        List<Integer> postOrder = tree.postOrder();
        Assert.assertEquals(Arrays.asList(4, 5, 2, 3, 1), postOrder);
    }

    @Test
    public void testIterativeTreeTraversal() {
         /*
             1
            / \
           2   3
          / \   \
         4  5    7
                / \
               8   9
         */
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        // 2
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // 3
        TreeNode seven = new TreeNode(7);
        root.right.right = seven;

        // 7
        seven.left = new TreeNode(8);
        seven.right = new TreeNode(9);

        TreeTraversal tree = new TreeTraversal(root);
        Assert.assertEquals(Arrays.asList(1, 2, 4, 5, 3, 7, 8, 9), tree.preOrderIterative());
        Assert.assertEquals(Arrays.asList(4, 2, 5, 1, 3, 8, 7, 9), tree.inOrderIterative());

        // using 1 stack
        Assert.assertEquals(Arrays.asList(4, 5, 2, 8, 9, 7, 3, 1), tree.postOrderIterative());
        Assert.assertEquals(Arrays.asList(4, 5, 2, 8, 9, 7, 3, 1), tree.postOrderIterative2());


    }

}
