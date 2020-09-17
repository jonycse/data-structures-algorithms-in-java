package dsalgo.graph.mst;


import dsalgo.graph.common.WeightedEdge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Kruskal {

    private int nodes;
    private int[] parent;
    private PriorityQueue<WeightedEdge> queue;
    private List<WeightedEdge> mst;
    private int cost;

    public Kruskal(int n, List<WeightedEdge> edges) {
        this.nodes = n;
        this.mst = new ArrayList<>(n - 1);
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            // each node connected with itself
            parent[i] = i;
        }

        queue = new PriorityQueue<>(edges.size(), new Comparator<WeightedEdge>() {
            @Override
            public int compare(WeightedEdge a, WeightedEdge b) {
                return a.w - b.w;
            }
        });
        // add all edges to priority queue
        for (WeightedEdge edge : edges) {
            queue.add(edge);
        }
        cost = 0;

        mst();
    }

    private void mst() {

        int MAX_EDGE_TO_FORM_MST = nodes - 1;

        while (MAX_EDGE_TO_FORM_MST > 0 && !queue.isEmpty()) {

            WeightedEdge edge = queue.remove();

            if (!connected(edge.u, edge.v)) {
                MAX_EDGE_TO_FORM_MST--;
                union(edge.u, edge.v);
                cost += edge.w;
                mst.add(edge);
            }
        }
        if (MAX_EDGE_TO_FORM_MST != 0) {
            throw new RuntimeException("No MST found");
        }
    }

    public void union(int u, int v) {
        u = root(u);
        v = root(v);
        parent[u] = v;
    }

    public boolean connected(int u, int v) {
        return root(u) == root(v);
    }

    private int root(int x) {

        if (!isValid(x)) {
            throw new RuntimeException("Invalid index");
        }

        while (x != parent[x]) {
            // making parent more flat
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private boolean isValid(int x) {
        if (x < 0 || x >= nodes) {
            return false;
        }
        return true;
    }

    public List<WeightedEdge> getMst() {
        return mst;
    }

    public int getCost() {

        //return mst.stream().map(item -> item.w).reduce(0, Integer::sum);
        return cost;
    }
}
