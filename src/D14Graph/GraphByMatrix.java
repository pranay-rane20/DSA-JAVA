package D14Graph;

import java.util.Scanner;

public class GraphByMatrix {

    public static void create (int[][] m, int sc, int des, boolean direc){
        if(direc){
            m[sc][des] = 1;
        }else {
            m[sc][des] = 1;
            m[des][sc]=1;
        }
    }

    public static void print(int[][] m){
        for(int i=0; i<m.length; i++){
            for (int j=0; j<m[i].length; j++){
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int[][] m = new int[v][v];

        create(m,1,2,false);
        create(m,0,2,false);
        create(m,1,0,false);

        print(m);
    }
}
