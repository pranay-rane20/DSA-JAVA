package D14Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphBFS {

    // Method to create edges in the graph
    public static void create(ArrayList<ArrayList<Integer>> adj, int sc, int des, boolean direct) {
        if (direct) {
            adj.get(sc).add(des);
        } else {
            adj.get(sc).add(des);
            adj.get(des).add(sc);
        }
    }

    public static ArrayList<Integer> BFS(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v];
        ArrayList<Integer> ans = new ArrayList<>();  // List to store BFS traversal order

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                BFSUtil(adj, ans, visited, i);
            }
        }
        return ans;
    }

    // Method to perform BFS traversal from a given node
    public static void BFSUtil(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, boolean[] visited, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            ans.add(curr);

            // Visit all unvisited neighbors of the current node
            for (int neighbor : adj.get(curr)) {
                if (!visited[neighbor]) {
                    q.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    // Method to print the adjacency list of the graph
    public static void print(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + " : ");
            for (int j : adj.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of vertices
        System.out.print("Enter the number of vertices: ");
        int v = sc.nextInt();

        // Initialize adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Create edges
        create(adj, 0, 2, false);
        create(adj, 0, 3, false);
        create(adj, 0, 1, false);
        create(adj, 2, 4, false);

        // Perform BFS and print the result
        ArrayList<Integer> ans = BFS(v, adj);
        System.out.println("BFS Traversal starting from node 0: " + ans);
    }
}
