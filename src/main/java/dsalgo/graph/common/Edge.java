package dsalgo.graph.common;

public class Edge {
    public int u;
    public int v;

    public boolean bidirectional;

    public Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }

    public Edge(int u, int v, boolean bidirectional) {
        this(u, v);
        this.bidirectional = bidirectional;
    }
}
