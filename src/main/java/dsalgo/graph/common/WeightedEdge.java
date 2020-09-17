package dsalgo.graph.common;

public class WeightedEdge {
    public int u;
    public int v;
    public int w;

    public WeightedEdge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    public boolean isNegativeEdge() {
        return w < 0;
    }
}
