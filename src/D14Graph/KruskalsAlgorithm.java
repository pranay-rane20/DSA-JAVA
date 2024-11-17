package D14Graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class KruskalsAlgorithm {
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
        @Override
        public int compareTo(Edge e) {
            return this.wt - e.wt;
        }

        static void createGraph(ArrayList<Edge> edges){
            edges.add(new Edge(0,1,10));
            edges.add(new Edge(0,2,15));
            edges.add(new Edge(0,3,30));
            edges.add(new Edge(1,3,40));
            edges.add(new Edge(2,3,50));
        }

        static int n = 4;
        static int par[] = new int[n];
        static int rank[] = new int[n];

        public static void init(){
            for(int i = 0; i < n; i++){
                par[i] = i;
            }
        }
        public static int find(int x){
            if(par[x] == x) return x;
            return par[x] = find(par[x]);
        }

        public static void union(int a,int b){
            int parA = find(a);
            int parB = find(b);

            if(rank[parA] == rank[parB]){
                par[parA] = parB;
                rank[parB]++;
            }else if(rank[parA]<rank[parB]){
                par[parA] = parB;
            }else {
                par[parB] = parA;
            }
        }

        public static void kruskals(ArrayList<Edge> edges,int v){
            init();
            Collections.sort(edges);
            int cost = 0;
            int count = 0;
            for(int i=0;count<v-1;i++){
                Edge e = edges.get(i);
                int parA = find(e.src);
                int parB = find(e.dest);
                if(parA!= parB){
                    count++;
                    cost += e.wt;
                    union(e.src,e.dest);
                }
            }
            System.out.println(cost);
        }
        public static void main(String[] args) {
            int v = 4;
            ArrayList<Edge> edges = new ArrayList<>();
            createGraph(edges);
            kruskals(edges,v);
        }
    }
}
