package D14Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
    static class Edge{
        int s,d,w;
        public Edge(int s, int d, int w){
            this.s = s;
            this.d = d;
            this.w = w;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        // Initialize the adjacency list for each vertex
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges to the graph
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    static class Pair implements Comparable<Pair>{
        int v;
        int cost;
        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair o) {
            return this.cost - o.cost; //ascending
            //return o.cost - this.cost; //descending order
        }
    }


    public static void P(ArrayList<Edge> g[]){
        boolean vis[] = new boolean[g.length];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        pq.add(new Pair(0,0));
        int finalcost = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.v]){
                vis[curr.v] = true;
                finalcost += curr.cost;

                for(int i=0;i<g[curr.v].size();i++){
                    Edge e = g[curr.v].get(i);
                    pq.add(new Pair(e.d,e.w));
                }
            }
        }
        System.out.println(finalcost);
    }

    public static void main(String[] args) {
        int v= 4;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
    }

}
