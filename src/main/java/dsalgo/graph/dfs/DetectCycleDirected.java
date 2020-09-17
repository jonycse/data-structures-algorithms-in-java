package dsalgo.graph.dfs;

import dsalgo.graph.common.Edge;

import java.util.List;

/**
 * Detect cycle on a directed graph, see also {@link DFS}
 */
public class DetectCycleDirected {

    private boolean[][] graph;
    private boolean[] visited;
    private int nodes;
    private boolean hasCycle;

    public DetectCycleDirected(int nodes, List<Edge> edgesDirected) {
        this.nodes = nodes;
        graph = new boolean[nodes][nodes];

        for (Edge edge : edgesDirected) {
            graph[edge.u][edge.v] = true;
        }

        solve();
    }


    public DetectCycleDirected(int nodes, boolean[][] graph) {
        this.nodes = nodes;
        this.graph = graph;
        solve();
    }

    private void solve() {

        visited = new boolean[nodes];
        hasCycle = false;
        boolean[] recStack = new boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                if (isCyclicGraph(i, recStack)) {
                    hasCycle = true;
                    break;
                }
            }
        }
    }

    private boolean isCyclicGraph(int u, boolean[] recStack) {

        if (recStack[u]) {
            return true;
        }
        if (visited[u]) {
            return false;
        }
        recStack[u] = true;
        visited[u] = true;

        for (int v = 0; v < nodes; v++) {
            if (graph[u][v]) {
                if (isCyclicGraph(v, recStack)) {
                    return true;
                }
            }
        }

        recStack[u] = false;
        return false;
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
