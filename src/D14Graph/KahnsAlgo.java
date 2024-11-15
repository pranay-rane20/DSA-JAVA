package D14Graph;

import java.util.*;

public class KahnsAlgo {
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

    // Method to perform Kahn's algorithm to find the topological ordering of a DAG
    public static void topSort(ArrayList<ArrayList<Integer>> adj, int v){
        int indeg[] = new int[v];
        calindeg(adj, indeg);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr + " ");
            for(int i : adj.get(curr)){
                indeg[i]--;
                if(indeg[i]==0){
                    q.add(i);
                }
            }
        }
        System.out.println();
    }

    public static void calindeg(ArrayList<ArrayList<Integer>> adj , int indeg[]){
        for(int i=0; i<adj.size(); i++){
            for(int j : adj.get(i)){
                indeg[j]++;
            }
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
