package D14Graph;

import java.util.*;

public class TopologicalSort {
    public static void create(ArrayList<ArrayList<Integer>> adj, int sc, int des, boolean direct) {
        if (direct) {
            adj.get(sc).add(des);
        } else {
            adj.get(sc).add(des);
            adj.get(des).add(sc);
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

    public static void topSort(ArrayList<ArrayList<Integer>> adj, int v){
        boolean vis[] = new boolean[v];
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < v; i++) {
            if (!vis[i]) { // Check if the vertex is already visited
                topSortUtil(adj, i, vis, s);
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<ArrayList<Integer>> adj, int curr, boolean vis[] , Stack<Integer> s){
        vis[curr] = true;
        for(int i : adj.get(curr)){
            if(!vis[i])
                topSortUtil(adj, i, vis, s);
        }
        s.push(curr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of vertices
        System.out.print("Enter the number of vertices: ");
        int v = 5;

        // Initialize adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Create edges
        create(adj, 0, 2, true);
        create(adj, 0, 3, true);
        create(adj, 0, 1, true);
        create(adj, 2, 4, true);

        topSort(adj,v);
       }
}
