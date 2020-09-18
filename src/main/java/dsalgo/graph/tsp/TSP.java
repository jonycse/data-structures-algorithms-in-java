package dsalgo.graph.tsp;

import dsalgo.graph.common.WeightedEdge;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringJoiner;

public class TSP {

    private static int NIL = -1;
    private int nodes;
    private int[][] graph;
    private boolean[] visited;

    private int cost;
    private int start;
    private String path;

    private Stack<Integer> stack;

    public TSP(int nodes, List<WeightedEdge> edges) {

        this.nodes = nodes;
        graph = new int[nodes][nodes];

        for (int[] x : graph) {
            Arrays.fill(x, NIL);
        }

        for (WeightedEdge edge : edges) {
            graph[edge.u][edge.v] = edge.w;
            graph[edge.v][edge.u] = edge.w;
        }

        init();
    }

    public TSP(int nodes, int[][] graph) {
        this.nodes = nodes;
        this.graph = graph;

        init();
    }

    private void init() {

        visited = new boolean[nodes];
        cost = 0;
        stack = new Stack<>();

        // we can start from anywhere
        start = 0;

        visited[start] = true;
        stack.push(start);

        cost = tsp(Integer.MAX_VALUE, start, 0, 1);
    }

    private int tsp(int res, int u, int costCurrent, int countCurrentVisited) {

        if (countCurrentVisited == nodes && graph[u][start] != NIL) {
            int tCost = costCurrent + graph[u][start];
            if (tCost < res) {
                res = tCost;
                savePath();
            }
            // res = Math.min(res, cost + graph[u][start]);
            return res;
        }

        for (int i = 0; i < nodes; i++) {
            if (!visited[i] && graph[u][i] != NIL) {

                visited[i] = true;
                stack.push(i);
                res = tsp(res, i, costCurrent + graph[u][i], countCurrentVisited + 1);
                visited[i] = false;
                stack.pop();
            }
        }
        return res;
    }

    private void savePath() {
        StringJoiner joiner = new StringJoiner(" => ");
        stack.forEach(v -> joiner.add(String.valueOf(v)));
        joiner.add(String.valueOf(start));

        path = joiner.toString();
    }

    public int getCost() {
        return cost;
    }

    public String getPath() {
        return path;
    }
}
