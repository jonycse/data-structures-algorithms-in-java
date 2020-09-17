package dsalgo.graph.dfs;


import dsalgo.graph.common.Edge;

import java.util.Arrays;
import java.util.List;

public class DFS {

    private static int NIL = -1;
    private int nodes;
    private boolean[][] graph;
    private boolean[] visited;
    private int[] parent;

    public DFS(int nodes, List<Edge> edges) {

        this.nodes = nodes;

        graph = new boolean[nodes][nodes];
        visited = new boolean[nodes];
        parent = new int[nodes];

        init(edges);
        dfs();
    }

    private void init(List<Edge> edges) {
        for (Edge edge : edges) {
            graph[edge.u][edge.v] = true;
            graph[edge.v][edge.u] = true;
        }
    }

    private void dfs() {

        Arrays.fill(parent, NIL);

        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                visit(i);
            }
        }
    }

    private void visit(int u) {
        // System.out.println("U " + u);
        visited[u] = true;
        for (int v = 0; v < nodes; v++) {
            if (graph[u][v] && !visited[v]) {
                parent[v] = u;
                visit(v);
            }
        }
        // System.out.println("UF " + u);
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
}
