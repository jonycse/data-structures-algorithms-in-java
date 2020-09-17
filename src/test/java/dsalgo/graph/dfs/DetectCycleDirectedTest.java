package dsalgo.graph.dfs;

import dsalgo.graph.common.Edge;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DetectCycleDirectedTest {

    @Test
    void test1(){

        /**
         * Input
         *
         *
         *                           2
         *                         /   \
         *                        1     0
         *                       / \     \
         *                      4   5     6
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

        List<Edge> edgesDirected = new ArrayList<>();

        edgesDirected.add(new Edge(2, 1));
        edgesDirected.add(new Edge(2, 0));

        edgesDirected.add(new Edge(1, 4));
        edgesDirected.add(new Edge(1, 5));

        edgesDirected.add(new Edge(0, 6));

        edgesDirected.add(new Edge(4, 7));
        edgesDirected.add(new Edge(7, 3));




        DetectCycleDirected detectCycle = new DetectCycleDirected(8, edgesDirected);

        assertEquals(false, detectCycle.hasCycle());


        // making a cycle using this edge
        edgesDirected.add(new Edge(3, 2));



        detectCycle = new DetectCycleDirected(8, edgesDirected);
        assertEquals(true, detectCycle.hasCycle());


    }
}
