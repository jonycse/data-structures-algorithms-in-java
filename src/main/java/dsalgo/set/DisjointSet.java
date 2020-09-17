package dsalgo.set;

public class DisjointSet {

    private final int n;
    private int[] parent;

    public DisjointSet(int n) {
        this.n = n;
        this.parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // each node connected with itself
            parent[i] = i;
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

        if (x < 1 || x > this.n) {
            throw new RuntimeException("Invalid index");
        }

        while (x != parent[x]) {

            // making tree more flat
            parent[x] = parent[parent[x]];

            x = parent[x];
        }
        return x;
    }
}
