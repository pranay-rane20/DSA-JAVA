package D14Graph;

//Find the mini cost for connecting all cities on the map

//cities[][] = {{0,1,2,3,4},
//        {1,0,5,0,7},
//        {2,5,0,6,0},
//        {3,0,6,0,0},
//        {4,7,0,0,0}};

//ans = 10

import java.util.PriorityQueue;

public class ConnectingCitiesWithMiniCost {

    static class Edge implements Comparable<Edge>{
        int d;
        int c;
        public Edge(int d,int c){
            this.c = c;
            this.d = d;
        }

        @Override
        public int compareTo(Edge o) {
            return this.c - o.c;
        }
    }

    public static int connect(int cities[][]){
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        boolean vis[] = new boolean[cities.length];

        pq.add(new Edge(0,0));
        int finalcost = 0;
        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            if(!vis[curr.d]){
                vis[curr.d] = true;
                finalcost += curr.c;
                for(int i=0;i<cities[curr.d].length;i++){
                    if(cities[curr.d][i] != 0){
                        pq.add(new Edge(i,cities[curr.d][i]));
                    }
                }
            }
        }
        System.out.println(finalcost);
        return finalcost;
    }


    public static void main(String[] args) {
        int cities[][] = {{0,1,2,3,4},
                {1,0,5,0,7},
                {2,5,0,6,0},
                {3,0,6,0,0},
                {4,7,0,0,0}};


        System.out.println(connect(cities));
    }
}
