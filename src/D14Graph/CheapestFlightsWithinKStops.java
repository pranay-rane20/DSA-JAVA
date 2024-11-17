package D14Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//CheapestFlightsWithinKStops
//There are n citeies connected by soem number of flights . Your are given an array flights where flights[i] = [from, to , price] indicated that ther is a flight.
//You are also given three integers src,dest,and k, return the cheapest price from src to dst with at most k stops . If there is no such route , return -1
//flights = [[0,1,100],[1,2,100],[0,2,500]]
//src =0 , dst = 2 k =1;
//ans = 200;
public class CheapestFlightsWithinKStops {

    static class Edge{
        int src,dest,wt;
        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void create(int flights[][], ArrayList<Edge> graph[]){
        for(int i=0;i< graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i< flights.length;i++){
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src,dest,wt);
            graph[src].add(e);
        }
    }
    static class Info{
        int v;
        int cost;
        int stops;
        public Info(int v,int c,int s){
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }

    public static int cheapest(int n,int flights[][],int src, int dest, int k){
        ArrayList<Edge> g[] = new ArrayList[n];
        create(flights,g);

        int dist[] = new int[n];
        for(int i=0;i<n;i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src,0,0));
        while(!q.isEmpty()){
            Info curr = q.poll();
            if(curr.stops > k) break;

            for(int i=0;i<g[curr.v].size();i++){
                Edge e = g[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if(curr.cost+wt<dist[v] && curr.stops<=k){
                    dist[v] = curr.cost+wt;
                    q.add(new Info(v,dist[v],curr.stops+1));
                }
            }
        }
        if(dist[dest] == Integer.MAX_VALUE) return -1;
        else return dist[dest];
    }


    public static void main(String[] args) {
        int n = 4;
        int flights[][] = {{0,1,100},{2,0,100},{2,3,200}};
        int src =0, dst = 3, k=1;

        ArrayList<Edge> graph[] = new ArrayList[n];
    }
}
