package D14Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CycleDirected {
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

    public static boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] vis = new boolean[v];
        boolean[] recv = new boolean[v];

        for(int i=0;i<v;i++){
            if(!vis[i]){
                if(cycleUtil(adj,i,vis,recv)) return true;
            }
        }
        return false;
    }
    public static boolean cycleUtil(ArrayList<ArrayList<Integer>> adj , int curr, boolean[] vis, boolean[] recv){
        vis[curr] = true;
        recv[curr] = true;

        for(int neighbor : adj.get(curr)){
            if(recv[neighbor]) return true;
            if(!vis[neighbor] && cycleUtil(adj,neighbor,vis,recv)) return true;
        }
        recv[curr] = false;
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


    }
}
