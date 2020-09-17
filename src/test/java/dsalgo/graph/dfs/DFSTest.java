package dsalgo.graph.dfs;

import dsalgo.graph.common.Edge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DFSTest {

    @Test
    void test1(){

        /**
         * Input
         *
         *
         *                           0
         *                         /   \
         *                        1     2
         *                       / \     \
         *                      4   5     6
         *                     /    /
         *                    7    /
         *                   /    /
         *                   /   /
         *                   /  /
         *                   / /
         *                   3
         *
         *                         8
         *
         *
         *
         *
         *
         */

        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1));
        edges.add(new Edge(0, 2));

        edges.add(new Edge(1, 4));
        edges.add(new Edge(1, 5));

        edges.add(new Edge(2, 6));

        edges.add(new Edge(4, 7));
        edges.add(new Edge(7, 3));
        edges.add(new Edge(5, 3));


        DFS dfs = new DFS(9, edges);

        System.out.println(dfs.getPath(0, 3));
        assertEquals("0 => 1 => 4 => 7 => 3", dfs.getPath(0, 3));
    }

    @Test
    @DisplayName("Test DFS2")
    void test2(){

        /**
         * Input
         *
         *
         *                           0
         *                         /   \
         *                        1     2
         *                       / \     \
         *                      4   5     6
         *                     /    /
         *                    7    /
         *                   /    /
         *                   /   /
         *                   /  /
         *                   / /
         *                   3
         *
         *                         8
         *
         *
         *
         *
         *
         */

        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1));
        edges.add(new Edge(0, 2));

        edges.add(new Edge(1, 4));
        edges.add(new Edge(1, 5));

        edges.add(new Edge(2, 6));

        edges.add(new Edge(4, 7));
        edges.add(new Edge(7, 3));
        edges.add(new Edge(5, 3));


        DFS2 dfs = new DFS2(9, edges);

        System.out.println(dfs.getPath(0, 3));
        assertEquals("0 => 1 => 4 => 7 => 3", dfs.getPath(0, 3));
    }
}
