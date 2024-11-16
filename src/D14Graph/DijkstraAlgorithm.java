package D14Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    // Edge class to represent a directed weighted edge in the graph
    static class Edge {
        int s, d, w; // s: source, d: destination, w: weight
        public Edge(int s, int d, int w) {
            this.s = s;
            this.d = d;
            this.w = w;
        }
    }

        // Function to create the graph using adjacency list representation
        static void createGraph(ArrayList<Edge> graph[]) {
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>(); // Initialize adjacency list for each vertex
            }
            // Adding edges to the graph
            graph[0].add(new Edge(0, 1, 2));
            graph[0].add(new Edge(0, 2, 4));

            graph[1].add(new Edge(1, 3, 7));
            graph[1].add(new Edge(1, 2, 1));

            graph[2].add(new Edge(2, 4, 3));

            graph[3].add(new Edge(3, 5, 1));

            graph[4].add(new Edge(4, 3, 2));
            graph[4].add(new Edge(4, 5, 5));
        }

    // Pair class to represent a vertex and its distance from the source
    static class Pair implements Comparable<Pair> {
        int n; // Vertex
        int path; // Distance of this vertex from the source
        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            // Sort by distance (ascending order)
            return this.path - p2.path;
        }
    }



    // Implementation of Dijkstra's Algorithm
    public static void dijkstra(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length]; // Array to store shortest distances

        // Initialize distances to infinity (Integer.MAX_VALUE), except the source
        for (int i = 0; i < graph.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0; // Distance to source is 0

        // PriorityQueue to pick the vertex with the shortest distance
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0)); // Start with the source vertex

        while (!pq.isEmpty()) {
            Pair curr = pq.poll(); // Get the vertex with the smallest distance
            int u = curr.n;

            // Traverse all neighbors of the current vertex
            for (Edge e : graph[u]) {
                int v = e.d; // Destination vertex
                int wt = e.w; // Edge weight

                // Relaxation step: Check if a shorter path exists
                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt; // Update distance
                    pq.add(new Pair(v, dist[v])); // Add the updated distance to the priority queue
                }
            }
        }

        // Print the shortest distances from the source
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }




    public static void main(String[] args) {
        int v = 6; // Number of vertices
        ArrayList<Edge> graph[] = new ArrayList[v]; // Graph represented as an array of adjacency lists
        createGraph(graph); // Populate the graph

        int src = 0; // Source vertex
        dijkstra(graph, src); // Run Dijkstra's algorithm
    }
}
