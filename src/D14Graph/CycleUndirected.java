package D14Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CycleUndirected {
    // Method to create edges in the graph
    public static void create(ArrayList<ArrayList<Integer>> adj, int sc, int des, boolean direct) {
        if (direct) {
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

    public static boolean detectCycle(ArrayList<ArrayList<Integer>> adj){
        boolean visit[] = new boolean[adj.size()];
        for(int i=0;i<adj.size();i++){
            if(!visit[i]){
                if(detectCycleUtil(adj,visit,i,-1))
                    return true;
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<ArrayList<Integer>> adj,boolean visit[],int curr, int parent){
            visit[curr] = true;
        for (int neighbor : adj.get(curr)) {
            // If neighbor is not visited, recursively visit it
            if (!visit[neighbor]) {
                if (detectCycleUtil(adj,visit,neighbor,curr))
                    return true;
            }
            // If visited and not the parent, a cycle is found
            else if ( visit[neighbor] && neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = 5;

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
