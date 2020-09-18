package dsalgo.graph.tsp;

import dsalgo.graph.common.WeightedEdge;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TSPTest {

    @Test
    public void test1() {

        List<WeightedEdge> edges = new ArrayList<>();

        edges.add(new WeightedEdge(0, 1, 10));
        edges.add(new WeightedEdge(0, 2, 15));
        edges.add(new WeightedEdge(0, 3, 20));

        edges.add(new WeightedEdge(1, 0, 10));
        edges.add(new WeightedEdge(1, 2, 35));
        edges.add(new WeightedEdge(1, 3, 25));

        edges.add(new WeightedEdge(2, 0, 15));
        edges.add(new WeightedEdge(2, 1, 35));
        edges.add(new WeightedEdge(2, 3, 30));

        edges.add(new WeightedEdge(3, 0, 20));
        edges.add(new WeightedEdge(3, 1, 25));
        edges.add(new WeightedEdge(3, 2, 30));

        TSP tsp = new TSP(4, edges);


        Assert.assertEquals(80, tsp.getCost());
        //System.out.println("Path " + tsp.getPath());
        Assert.assertEquals("0 => 1 => 3 => 2 => 0", tsp.getPath());
    }

    @Test
    public void test2() {
        int[][] graph = {{0, 12, 3, 9, 6, 1, 2},
                {12, 0, 6, 1, 8, 2, 10},
                {3, 6, 0, 6, 7, 11, 7},
                {9, 1, 6, 0, 9, 10, 3},
                {6, 8, 7, 9, 0, 1, 11},
                {1, 2, 11, 10, 1, 0, 12},
                {2, 10, 7, 3, 11, 12, 0}};

        TSP tsp = new TSP(7, graph);
        //System.out.println("Path " + tsp.getPath());
        Assert.assertEquals(19, tsp.getCost());
        Assert.assertEquals("0 => 2 => 4 => 5 => 1 => 3 => 6 => 0", tsp.getPath());
    }

    @Test
    public void test3() {

        int[][] graph = {{0, 1, 15, 6},
                {2, 0, 7, 3},
                {9, 6, 0, 12},
                {10, 4, 8, 0},
        };

        TSP tsp = new TSP(4, graph);
        //System.out.println("Path " + tsp.getPath());
        Assert.assertEquals(21, tsp.getCost());
        Assert.assertEquals("0 => 1 => 3 => 2 => 0", tsp.getPath());

    }
}
