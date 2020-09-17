package dsalgo.graph.dijkstra;

import dsalgo.graph.common.WeightedEdge;

import java.util.*;


public class Dijkstra2 {

    class DNode {

        public Integer node;
        public Integer cost;

        public DNode(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    private Map<Integer, Set<DNode>> graph;
    private int[] distance;
    private int[] parent;
    private final int nodes;
    private final int start;
    private static int INF = Integer.MAX_VALUE;
    private static int NIL = -1;

    public Dijkstra2(int nodes, List<WeightedEdge> edges, int start) {

        this.nodes = nodes;
        this.start = start;

        distance = new int[nodes];
        parent = new int[nodes];

        Arrays.fill(parent, NIL);
        Arrays.fill(distance, INF);

        this.graph = new TreeMap<>();

        for (WeightedEdge edge : edges) {
            if (edge.isNegativeEdge()) {
                throw new RuntimeException("Negative edge is not supported");
            }
            int u = edge.u;
            int v = edge.v;
            int w = edge.w;

            if (!graph.containsKey(u)) {
                graph.put(u, new HashSet<>());
            }
            graph.get(u).add(new DNode(v, w));

        }
        dijkstra();
    }

    private void dijkstra() {
        distance[start] = 0;
        parent[start] = start;
        PriorityQueue<DNode> queue = new PriorityQueue<>(new Comparator<DNode>() {
            @Override
            public int compare(DNode a, DNode b) {
                return a.cost.compareTo(b.cost);
            }
        });
        queue.add(new DNode(start, 0));

        while (!queue.isEmpty()) {
            int u = queue.remove().node;

            for (DNode v : graph.getOrDefault(u, new HashSet<>())) {
                int alt = distance[u] + v.cost;
                if (alt < distance[v.node]) {
                    distance[v.node] = alt;
                    parent[v.node] = u;
                    queue.add(new DNode(v.node, distance[v.node]));
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
