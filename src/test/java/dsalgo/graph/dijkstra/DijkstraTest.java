package dsalgo.graph.dijkstra;

import dsalgo.graph.common.WeightedEdge;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DijkstraTest {

    @Test
    @DisplayName("Dijkstra Test")
    public void test1() {


        System.out.println("Dijkstra SSSP");

        int totalNodes = 5;
        int start = 0;
        List<WeightedEdge> edges = new ArrayList<>();

        edges.add(new WeightedEdge(0, 1, 9));
        edges.add(new WeightedEdge(0, 2, 6));
        edges.add(new WeightedEdge(0, 3, 5));
        edges.add(new WeightedEdge(0, 4, 3));

        edges.add(new WeightedEdge(2, 1, 2));
        edges.add(new WeightedEdge(2, 3, 4));
        edges.add(new WeightedEdge(4, 2, 1));

        Dijkstra dijkstra = new Dijkstra(totalNodes, edges, start);

        dijkstra.printDistance();

        int[] distance = dijkstra.getDistance();
        Assert.assertEquals("0", dijkstra.getPath(0));
        Assert.assertEquals(0, distance[0]);

        Assert.assertEquals(6, distance[1]);
        Assert.assertEquals("0 => 4 => 2 => 1", dijkstra.getPath(1));

        Assert.assertEquals(4, distance[2]);
        Assert.assertEquals("0 => 4 => 2", dijkstra.getPath(2));

        Assert.assertEquals(5, distance[3]);
        Assert.assertEquals("0 => 3", dijkstra.getPath(3));

        Assert.assertEquals(3, distance[4]);
        Assert.assertEquals("0 => 4", dijkstra.getPath(4));

    }

    @Test
    @DisplayName("Dijkstra2 Test")
    public void test2() {


        System.out.println("Dijkstra SSSP");

        int totalNodes = 5;
        int start = 0;
        List<WeightedEdge> edges = new ArrayList<>();

        edges.add(new WeightedEdge(0, 1, 9));
        edges.add(new WeightedEdge(0, 2, 6));
        edges.add(new WeightedEdge(0, 3, 5));
        edges.add(new WeightedEdge(0, 4, 3));

        edges.add(new WeightedEdge(2, 1, 2));
        edges.add(new WeightedEdge(2, 3, 4));
        edges.add(new WeightedEdge(4, 2, 1));

        Dijkstra2 dijkstra = new Dijkstra2(totalNodes, edges, start);

        dijkstra.printDistance();

        int[] distance = dijkstra.getDistance();
        Assert.assertEquals("0", dijkstra.getPath(0));
        Assert.assertEquals(0, distance[0]);

        Assert.assertEquals(6, distance[1]);
        Assert.assertEquals("0 => 4 => 2 => 1", dijkstra.getPath(1));

        Assert.assertEquals(4, distance[2]);
        Assert.assertEquals("0 => 4 => 2", dijkstra.getPath(2));

        Assert.assertEquals(5, distance[3]);
        Assert.assertEquals("0 => 3", dijkstra.getPath(3));

        Assert.assertEquals(3, distance[4]);
        Assert.assertEquals("0 => 4", dijkstra.getPath(4));

    }
}
