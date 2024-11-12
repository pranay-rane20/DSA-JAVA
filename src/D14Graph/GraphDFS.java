package D14Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class GraphDFS {
    public static void create(ArrayList<ArrayList<Integer>> adj , int sc, int des, boolean direct){
        if(direct){
            adj.get(sc).add(des);
        } else {
            adj.get(sc).add(des);
            adj.get(des).add(sc);
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + " : ");
            for (int j : adj.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }


    public static ArrayList<Integer> DFS(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfsUtil(i, adj, visited, result);
            }
        }
        return result;
    }

    private static void dfsUtil(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result) {
        visited[node] = true;
        result.add(node);

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, adj, visited, result);
            }
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
//        ArrayList<Integer> ans = BFS(v, adj);
//        System.out.println("BFS Traversal starting from node 0: " + ans);

        ArrayList<Integer> ans = DFS(v, adj);
        System.out.println(ans);

    }
}
