package D14Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BipartitieGraph {
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

    public static boolean Bipartite(ArrayList<ArrayList<Integer>> adj , int v){
        int[] clr = new int[v];
        for(int i=0;i<v;i++) clr[i] = -1;
        Queue<Integer> q = new LinkedList<>();

        for(int i=0 ;i<v;i++){
            if(clr[i] == -1){
                q.add(i);
                clr[i] = 0;
                while(!q.isEmpty()){
                    int curr = q.poll();
                    for(int neighbor : adj.get(curr)){
                        if(clr[neighbor] == -1){
                            int nxt = clr[curr] ==0 ? 1:0;
                            clr[neighbor] = nxt;
                            q.add(neighbor);
                        }
                        else if(clr[neighbor] == clr[curr]){
                            System.out.println("Graph is not bipartite");
                            return false;
                        }
                    }
                }
            }
        }
        return true;
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
