package D14Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class HasPath {

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

    //O(v+e);
    public static boolean hasPath(ArrayList<ArrayList<Integer>> adj , int src, int dest, boolean visited[]){
        if(src == dest)
            return true;
        visited[src] = true;
        for(int i : adj.get(src)){
            if(!visited[i] && hasPath(adj, i, dest, visited)){
                return true;
            }
        }
        return false;
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

//        ArrayList<Integer> ans = DFS(v, adj);
//        System.out.println(ans);

    }
}
