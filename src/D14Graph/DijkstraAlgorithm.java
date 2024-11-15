package D14Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    static class Edge {
        int s, d, w;
        public Edge(int s, int d, int w) {
            this.s = s;
            this.d = d;
            this.w = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    static class Pair implements Comparable<Pair> {
        int n;
        int path;
        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void dijkstra(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];
        boolean vis[] = new boolean[graph.length];

        // Initialize distances to infinity, except for the source
        for (int i = 0; i < graph.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (!vis[curr.n]) {
                vis[curr.n] = true;

                for (Edge e : graph[curr.n]) {
                    int u = e.s;
                    int v = e.d;
                    int wt = e.w;

                    // Relaxation step
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        // Print the shortest distances from source
        System.out.println("Shortest distances from source " + src + ":");
        for(int i=0; i<dist.length; i++){
            System.out.print(dist[i] + " ");
        }
        System.out.println();


    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        int src = 0;
        dijkstra(graph, src);
    }
}
