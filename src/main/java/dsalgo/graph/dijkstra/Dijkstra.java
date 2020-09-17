package dsalgo.graph.dijkstra;


import dsalgo.graph.common.WeightedEdge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class Dijkstra {

    class DNode {
        public int node;
        public Integer cost;

        public DNode(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    private int[][] graph;
    private int[] distance;
    private int[] parent;
    private final int nodes;
    private final int start;
    private static int INF = Integer.MAX_VALUE;
    private static int NIL = -1;

    public Dijkstra(int nodes, List<WeightedEdge> edges, int start) {

        this.nodes = nodes;
        this.start = start;

        graph = new int[nodes][nodes];
        distance = new int[nodes];
        parent = new int[nodes];

        Arrays.fill(parent, NIL);
        Arrays.fill(distance, INF);
        for (int i = 0; i < nodes; i++) {
            Arrays.fill(graph[i], NIL);
        }

        for (WeightedEdge edge : edges) {
            if (edge.isNegativeEdge()) {
                throw new RuntimeException("Negative edge is not supported");
            }
            graph[edge.u][edge.v] = edge.w;
        }
        dijkstra();
    }

    private void dijkstra() {
        distance[start] = 0;
        parent[start] = start;
        PriorityQueue<DNode> queue = new PriorityQueue<>(new Comparator<DNode>() {
            @Override
            public int compare(DNode a, DNode b) {
                //return a.cost - b.cost;
                return a.cost.compareTo(b.cost);
            }
        });
        queue.add(new DNode(start, 0));

        while (!queue.isEmpty()) {
            int u = queue.remove().node;
            for (int v = 0; v < nodes; v++) {
                if (graph[u][v] != NIL) {
                    int alt = distance[u] + graph[u][v];
                    // A* search, h(v) will guide us to path near to goal
                    // int alt = distance[u] + graph[u][v] + h(v);

                    if (alt < distance[v]) {
                        distance[v] = alt;
                        parent[v] = u;
                        queue.add(new DNode(v, distance[v]));
                    }
                }
            }
        }
    }


    public void printDistance() {
        for (int i = 0; i < nodes; i++) {
            System.out.println("Distance from " + start + " to " + i + " is " + distance[i]);
            System.out.println("path " + getPath(i));
        }
    }

    public int[] getDistance() {
        return distance;
    }

    public String getPath(int destination) {
        return getPath(destination, "");
    }

    private String getPath(int destination, String path) {
        if (destination == start) {
            return start + "";
        } else if (parent[destination] == NIL) {
            return "No path";
        } else {
            path = getPath(parent[destination], path);
            return path + " => " + destination;
        }
    }
}
