package dsalgo.graph.mst;

import dsalgo.graph.common.WeightedEdge;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class KruskalTest {

    @Test
    public void test1() {
        List<WeightedEdge> edges = new ArrayList<>();


        edges.add(new WeightedEdge(7, 6, 1));
        edges.add(new WeightedEdge(8, 2, 2));
        edges.add(new WeightedEdge(6, 5, 2));
        edges.add(new WeightedEdge(0, 1, 4));
        edges.add(new WeightedEdge(2, 5, 4));
        edges.add(new WeightedEdge(8, 6, 6));
        edges.add(new WeightedEdge(2, 3, 7));
        edges.add(new WeightedEdge(7, 8, 7));
        edges.add(new WeightedEdge(0, 7, 8));
        edges.add(new WeightedEdge(1, 2, 8));
        edges.add(new WeightedEdge(3, 4, 9));
        edges.add(new WeightedEdge(5, 4, 10));
        edges.add(new WeightedEdge(1, 7, 11));
        edges.add(new WeightedEdge(3, 5, 14));

        int nodes = 9;
        Kruskal mst = new Kruskal(nodes, edges);
        Assert.assertTrue(mst.getMst().size() == (nodes - 1));
        Assert.assertEquals(37, mst.getCost());

        Assert.assertTrue(hasEdge(mst.getMst(), new WeightedEdge(0, 1, 4)));
        Assert.assertTrue(hasEdge(mst.getMst(), new WeightedEdge(0, 7, 8)));
        Assert.assertTrue(hasEdge(mst.getMst(), new WeightedEdge(7, 6, 1)));
        Assert.assertTrue(hasEdge(mst.getMst(), new WeightedEdge(6, 5, 2)));
        Assert.assertTrue(hasEdge(mst.getMst(), new WeightedEdge(5, 2, 4)));
        Assert.assertTrue(hasEdge(mst.getMst(), new WeightedEdge(2, 8, 2)));
        Assert.assertTrue(hasEdge(mst.getMst(), new WeightedEdge(2, 3, 7)));
        Assert.assertTrue(hasEdge(mst.getMst(), new WeightedEdge(3, 4, 9)));
    }

    private boolean hasEdge(List<WeightedEdge> edges, WeightedEdge edge) {
        return edges.stream().anyMatch(item -> item.u == edge.u && item.v == edge.v && item.w == edge.w)
                || edges.stream().anyMatch(item -> item.u == edge.v && item.v == edge.u && item.w == edge.w);
    }
}
