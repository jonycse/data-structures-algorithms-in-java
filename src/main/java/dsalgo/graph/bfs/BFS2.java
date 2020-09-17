package dsalgo.graph.bfs;


import dsalgo.graph.common.Edge;

import java.util.*;

public class BFS2 {

    private final int nodes;
    private final int start;
    private Map<Integer, Set<Integer>> graph;
    private boolean[] visited;
    private int[] dist;
    private int[] parent;

    private static int NIL = -1;
    private static int INF = Integer.MAX_VALUE;

    public BFS2(int nodes, List<Edge> edges, int start) {
        this.nodes = nodes;
        this.start = start;

        this.graph = new TreeMap<>();

        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;

            initAdjacentList(u);
            initAdjacentList(v);

            graph.get(u).add(v);
            graph.get(v).add(u);

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

        if (!graph.containsKey(start)) {
            return;
        }

        while (!queue.isEmpty()) {

            int u = queue.remove();

            for (int v : graph.getOrDefault(u, new HashSet<>())) {
                if (!visited[v]) {
                    visited[v] = true;
                    parent[v] = u;
                    dist[v] = dist[u] + 1;
                    queue.add(v);
                }
            }
        }
    }

    public String getPath(int target) {
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

    private void initAdjacentList(int key) {
        if (!graph.containsKey(key)) {
            graph.put(key, new HashSet<>());
        }
    }
}
