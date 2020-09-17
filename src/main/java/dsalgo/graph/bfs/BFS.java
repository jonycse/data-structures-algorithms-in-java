package dsalgo.graph.bfs;

import dsalgo.graph.common.Edge;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    private final int nodes;
    private final int start;
    private boolean[][] graph;
    private boolean[] visited;
    private int[] dist;
    private int[] parent;

    private static int NIL = -1;
    private static int INF = Integer.MAX_VALUE;

    public BFS(int nodes, List<Edge> edges, int start) {
        this.nodes = nodes;
        this.start = start;

        this.graph = new boolean[nodes][nodes];

        for (Edge edge : edges) {
            graph[edge.u][edge.v] = graph[edge.v][edge.u] = true;
        }

        bfs();
    }

    public void bfs() {

        this.dist = new int[nodes];
        this.parent = new int[nodes];
        this.visited = new boolean[nodes];

        Arrays.fill(dist, INF);
        Arrays.fill(parent, NIL);
        Queue<Integer> queue = new LinkedList<>();

        parent[start] = start;
        dist[start] = 0;
        visited[start] = true;
        queue.add(start);


        while (!queue.isEmpty()) {

            int u = queue.remove();
            for (int i = 0; i < nodes; i++) {
                if (graph[u][i] && !visited[i]) {

                    visited[i] = true;
                    parent[i] = u;
                    dist[i] = dist[u] + 1;
                    queue.add(i);
                }
            }
        }
    }

    public String getPath(int target){
        return getPath(target, "");
    }

    private String getPath(int target, String path) {
        if (target == start) {
            return start + "";
        } else if (parent[target] == NIL) {
            return "No path found";
        } else {
            path = getPath(parent[target], path);
            path = path + " => " + target;
            return path;
        }
    }

    public int getDistance(int target) {
        if (dist[target] == INF) {
            return -1;
        }
        return dist[target];
    }
}
