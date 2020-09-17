package dsalgo.graph.bfs;


import dsalgo.graph.common.Edge;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BFSTest {


    @BeforeEach
    void beforeEach(TestInfo testInfo) {
        System.out.println("beforeEach: " + testInfo.getDisplayName());
    }

    @Test
    @DisplayName("BFS Test")
        //@RepeatedTest(2)
    void test1(TestInfo testInfo) {

        /**
         * Input
         *
         *
         *                           0
         *                         /   \
         *                        1     2
         *                       / \     \
         *                      5   4     6
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

        System.out.println("Running " + testInfo.getDisplayName());

        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1));
        edges.add(new Edge(0, 2));

        edges.add(new Edge(1, 5));
        edges.add(new Edge(1, 4));

        edges.add(new Edge(2, 6));

        edges.add(new Edge(5, 7));
        edges.add(new Edge(7, 3));
        edges.add(new Edge(4, 3));


        BFS bfs = new BFS(9, edges, 0);

        //System.out.println(bfs.getPath(3, ""));

        assertEquals("0 => 1 => 4 => 3", bfs.getPath(3));
        assertEquals(3, bfs.getDistance(3));
        assertEquals("0 => 1 => 4", bfs.getPath(4));
        assertEquals(2, bfs.getDistance(4));
        assertEquals("0 => 2 => 6", bfs.getPath(6));
        assertEquals(2, bfs.getDistance(6));

        assertEquals(0, bfs.getDistance(0));

        assertEquals("No path found", bfs.getPath(8));

    }

    @Test
    void test2(TestInfo testInfo) {

        /**
         * Input
         *
         *
         *                           0
         *                         /   \
         *                        1     2
         *                       / \     \
         *                      5   4     6
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

        System.out.println("Running " + testInfo.getDisplayName());

        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1));
        edges.add(new Edge(0, 2));

        edges.add(new Edge(1, 5));
        edges.add(new Edge(1, 4));

        edges.add(new Edge(2, 6));

        edges.add(new Edge(5, 7));
        edges.add(new Edge(7, 3));
        edges.add(new Edge(4, 3));


        BFS bfs = new BFS(9, edges, 7);

        //System.out.println(bfs.getPath(3, ""));

        assertEquals("7 => 3", bfs.getPath(3));
        assertEquals("7", bfs.getPath(7));
        assertEquals(1, bfs.getDistance(3));
        assertEquals("7 => 3 => 4", bfs.getPath(4));
        assertEquals(2, bfs.getDistance(4));
        assertEquals("7 => 5 => 1 => 0 => 2 => 6", bfs.getPath(6));
        assertEquals(5, bfs.getDistance(6));

        assertEquals(3, bfs.getDistance(0));

        assertEquals(-1, bfs.getDistance(8));
        assertEquals("No path found", bfs.getPath(8));

    }

    @Test
    @Tag("mySpecialTest")
    void mySpecialTest() {
        System.out.println("Running a very special test.");
    }
}

