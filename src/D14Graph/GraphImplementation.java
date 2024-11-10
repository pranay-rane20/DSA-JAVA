package D14Graph;

import java.util.ArrayList;
import java.util.List;

public class GraphImplementation {
    private int vertices;
    private int[][] adjacencyMatrix;

    public GraphImplementation(int v) {
        this.vertices = v;
        this.adjacencyMatrix = new int[v][v];
    }

    public void addEdge(int source, int destination) {
        // Add edge
        adjacencyMatrix[source][destination] = 1;

        // If undirected graph, add the reverse edge as well
        // adjacencyMatrix[destination][source] = 1;
    }

    public void removeEdge(int source, int destination) {
        // Remove edge
        adjacencyMatrix[source][destination] = 0;

        // If undirected graph, remove the reverse edge as well
        // adjacencyMatrix[destination][source] = 0;
    }

    public boolean isEdge(int source, int destination) {
        return adjacencyMatrix[source][destination] == 1;
    }

    public List<Integer> getAdjacentVertices(int vertex) {
        List<Integer> adjacentVertices = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            if (adjacencyMatrix[vertex][i] == 1) {
                adjacentVertices.add(i);
            }
        }
        return adjacentVertices;
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (int j = 0; j < vertices; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphImplementation graph = new GraphImplementation(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("Graph representation using Adjacency Matrix:");
        graph.printGraph();
    }
}