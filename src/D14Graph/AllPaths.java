package D14Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AllPaths {
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


    public static void storeAllPaths(ArrayList<ArrayList<Integer>> adj, int src, int dest, String path, ArrayList<String> allPaths) {
        if (src == dest) {
            allPaths.add(path + dest);
            return;
        }
        for (int i : adj.get(src)) {
            storeAllPaths(adj, i, dest, path + src + " -> ", allPaths);
        }
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


    }
}
