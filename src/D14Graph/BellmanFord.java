package D14Graph;

import java.util.ArrayList;

public class BellmanFord {
    static class Edge{
        int s,d,w;
        public Edge(int s, int d, int w){
            this.s = s;
            this.d = d;
            this.w = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,3));

        graph[1].add(new Edge(1,2,-4));

        graph[2].add(new Edge(2,2,2));
        graph[3].add(new Edge(3,4,4));

        graph[4].add(new Edge(4,1,-1));
    }


    public static void bellamanFord(ArrayList<Edge> g[], int src){
        int V = g.length; // Number of vertices
        int[] dist = new int[V]; // Array to store the shortest distances

        // Initialize distances to infinity except for the source
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        // Relax all edges (vertices - 1) times
        for (int i = 0; i < V - 1; i++) {
            for (int u = 0; u < g.length; u++) {
                for (Edge edge : g[u]) {
                    int v = edge.d; // Destination vertex
                    int w = edge.w; // Edge weight

                    // Relaxation step
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                    }
                }
            }
        }

        // Optional: Check for negative-weight cycles
        for (int u = 0; u < g.length; u++) {
            for (Edge edge : g[u]) {
                int v = edge.d; // Destination vertex
                int w = edge.w; // Edge weight

                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    System.out.println("Graph contains a negative-weight cycle.");
                    return;
                }
            }
        }



        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        bellamanFord(graph, 0);
    }
}
