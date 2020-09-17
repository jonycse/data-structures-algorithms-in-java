package dsalgo.graph.dfs;


import dsalgo.graph.common.TaskNode;

import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    private int nodes;
    private Stack<Integer> stack;
    private boolean[][] graph;
    private boolean[] visited;

    public TopologicalSort(int nodes, List<TaskNode> edgesDirected) {

        this.nodes = nodes;
        graph = new boolean[nodes][nodes];
        visited = new boolean[nodes];
        stack = new Stack<>();
        for (TaskNode edge : edgesDirected) {
            graph[edge.dependsOn][edge.task] = true;
        }

        if (hasCycle()) {
            throw new RuntimeException("Cycle detected");
        }

        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    private boolean hasCycle() {
        DetectCycleDirected dcd = new DetectCycleDirected(nodes, graph);

        return dcd.hasCycle();
    }

    private void dfs(int u) {

        visited[u] = true;
        for (int v = 0; v < nodes; v++) {
            if (graph[u][v] && !visited[v]) {
                dfs(v);
            }
        }
        stack.push(u);
    }

    public Stack getStack() {
        return stack;
    }
}
