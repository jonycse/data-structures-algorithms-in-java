package dsalgo.graph.dfs;


import dsalgo.graph.common.Edge;

import java.util.*;

public class DFS2 {

    private static int NIL = -1;
    private int nodes;
    private Map<Integer, ArrayList<Integer>> graph;
    private boolean[] visited;
    private int[] parent;

    public DFS2(int nodes, List<Edge> edges) {

        this.nodes = nodes;

        visited = new boolean[nodes];
        parent = new int[nodes];
        graph = new TreeMap<>();

        init(edges);
        dfs();
    }

    private void dfs() {

        Arrays.fill(parent, NIL);
        for (int i = 0; i < nodes; i++) {
            if (!visited[i] && graph.containsKey(i)) {
                visit(i);
            }
        }
    }

    private void visit(int u) {

        visited[u] = true;
        for (int v : graph.get(u)) {
            if (!visited[v]) {
                parent[v] = u;
                visit(v);
            }
        }
    }

    public String getPath(int source, int dest) {
        return getPath(source, dest, "");
    }

    private String getPath(int source, int dest, String path) {
        if (dest == source) {
            return source + "";
        } else if (parent[dest] == NIL) {
            return "No path";
        } else {
            path = getPath(source, parent[dest], path);
            path = path + " => " + dest;
        }
        return path;
    }

    private void init(List<Edge> edges) {

        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;

            if (!graph.containsKey(u)) {
                graph.put(u, new ArrayList<>());
            }

            if (!graph.containsKey(v)) {
                graph.put(v, new ArrayList<>());
            }
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
    }
}
