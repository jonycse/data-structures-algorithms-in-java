package dsalgo.graph.dfs;

import dsalgo.graph.common.TaskNode;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortTest {

    @Test
    public void test1() {

        /**
         * Input
         *
         *
         *                           2            8
         *                         /   \        /  \
         *                        1     0      11  10
         *                       / \     \           \
         *                      4   5     6          9
         *                     /
         *                    7
         *                   /
         *                  3
         *
         *
         *
         *
         *
         */

        List<TaskNode> edgesDirected = new ArrayList<>();

        // 0 and 1 depends on 2
        edgesDirected.add(new TaskNode(2, 1));
        edgesDirected.add(new TaskNode(2, 0));

        // 4 and 5 depends on 1
        edgesDirected.add(new TaskNode(1, 4));
        edgesDirected.add(new TaskNode(1, 5));

        // 0 and 1 depends on 2
        edgesDirected.add(new TaskNode(0, 6));

        edgesDirected.add(new TaskNode(4, 7));
        edgesDirected.add(new TaskNode(7, 3));

        edgesDirected.add(new TaskNode(8, 11));
        edgesDirected.add(new TaskNode(8, 10));
        edgesDirected.add(new TaskNode(10, 9));


        TopologicalSort topologicalSort = new TopologicalSort(12, edgesDirected);

        Stack stack = topologicalSort.getStack();

        // Print contents of stack
        System.out.print("Topological order: ");
        while (!stack.empty()) {

            System.out.print(stack.pop() + " ");
        }
        System.out.println("");

    }

    @Test
    public void test2() {
        List<TaskNode> edgesDirected = new ArrayList<>();

        // 0 and 1 depends on 2
        edgesDirected.add(new TaskNode(2, 1));
        edgesDirected.add(new TaskNode(2, 0));

        // 4 and 5 depends on 1
        edgesDirected.add(new TaskNode(1, 4));
        edgesDirected.add(new TaskNode(1, 5));

        // 0 and 1 depends on 2
        edgesDirected.add(new TaskNode(0, 6));

        edgesDirected.add(new TaskNode(4, 7));
        edgesDirected.add(new TaskNode(7, 3));

        edgesDirected.add(new TaskNode(8, 11));
        edgesDirected.add(new TaskNode(8, 10));
        edgesDirected.add(new TaskNode(10, 9));

        // making cycle with this node
        edgesDirected.add(new TaskNode(3, 2));

        try {
            TopologicalSort topologicalSort = new TopologicalSort(12, edgesDirected);
            Assert.fail("Should not reach here");
        } catch (Exception e) {

        }
    }
}
