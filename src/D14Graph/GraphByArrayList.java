package D14Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class GraphByArrayList {
    public static void create(ArrayList<ArrayList<Integer>> adj , int sc, int des, boolean direct){
        if(direct){
            adj.get(sc).add(des);
        }else {
            adj.get(sc).add(des);
            adj.get(des).add(sc);
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> adj){
        for(int i=0; i<adj.size(); i++){
            System.out.print(i + " : ");
            for(int j : adj.get(i)){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<v; i++){
            adj.add(new ArrayList<Integer>());
        }

        create(adj, 1,2,false);
        create(adj, 0,2,false);
        create(adj, 1,0,false);

        print(adj);
    }
}
