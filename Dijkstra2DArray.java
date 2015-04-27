/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a2wansongsong;

/**
 *
 * @author SONGSONG
 */
public class Dijkstra2DArray {

    public static int[][] Dijkstra2DArray(int n) {
        int p[][] = new int[n][n];
        int i, j, weight;
        for (i = 0; i < n; i++) {          //generate the weights
            for (j = i; j < n; j++) {
                if (j == i) {
                    p[i][j] = 0;
                } else {
                    weight = (int) (Math.random() * 50) + 1;
                    p[i][j] = weight;
                    p[j][i] = weight;
                }
            }
        }
        /*for (i = 0; i < n; i++) {                      //print the two-dimensional array
            for (j = 0; j < n; j++) {
                System.out.print(p[i][j] + " ");
            }
            System.out.print("\n");
        }*/
        return p;
    }

    public static void main(String[] args) {
        // TODO code application logic here
         int n = 2100;             //input the number of nodes
         int max = 10000;
         int graph[][] = Dijkstra2DArray(n);
         /*int graph[][]=new int[n][n];
         for(int i=0;i<n;i++)     //test for the graph-2
         graph[i][i]=0;
         graph[0][1]=6;graph[1][0]=6;
         graph[0][2]=7;graph[2][0]=7;
         graph[0][3]=2;graph[3][0]=2;
         graph[0][4]=1;graph[4][0]=1;
         graph[1][2]=2;graph[2][1]=2;
         graph[1][3]=3;graph[3][1]=3;
         graph[1][4]=3;graph[4][1]=3;
         graph[2][3]=2;graph[3][2]=2;
         graph[2][4]=4;graph[4][2]=4;
         graph[3][4]=1;graph[4][3]=1;*/
         /*for(int i=0;i<n;i++)      //test for the graph-1
         graph[i][i]=0;
         graph[0][1]=2;graph[1][0]=2;
         graph[0][2]=4;graph[2][0]=4;
         graph[0][3]=max;graph[3][0]=max;
         graph[0][4]=max;graph[4][0]=max;
         graph[0][5]=max;graph[5][0]=max;
         graph[0][6]=max;graph[6][0]=max;
         graph[0][7]=max;graph[7][0]=max;
         graph[1][2]=3;graph[2][1]=3;
         graph[1][3]=9;graph[3][1]=9;
         graph[1][4]=max;graph[4][1]=max;
         graph[1][5]=max;graph[5][1]=max;
         graph[1][6]=4;graph[6][1]=4;
         graph[1][7]=2;graph[7][1]=2;
         graph[2][3]=1;graph[3][2]=1;
         graph[2][4]=3;graph[4][2]=3;
         graph[2][5]=max;graph[5][2]=max;
         graph[2][6]=max;graph[6][2]=max;
         graph[2][7]=max;graph[7][2]=max;
         graph[3][4]=3;graph[4][3]=3;
         graph[3][5]=3;graph[5][3]=3;
         graph[3][6]=1;graph[6][3]=1;
         graph[3][7]=max;graph[7][3]=max;
         graph[4][5]=2;graph[5][4]=2;
         graph[4][6]=max;graph[6][4]=max;
         graph[4][7]=max;graph[7][4]=max;
         graph[5][6]=6;graph[6][5]=6;
         graph[5][7]=max;graph[7][5]=max;
         graph[6][7]=14;graph[7][6]=14;*/
         
        int result[][] = new int[n][n];
        int i, j, k, l, min, mark;
        boolean status[] = new boolean[n];
        long startTime = System.currentTimeMillis();
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                result[i][j] = graph[i][j];
                status[j] = false;
            }
            result[i][i] = 0;
            status[i] = true;
            for (k = 1; k < n; k++) {
                min = max;
                mark = i;
                for (l = 0; l < n; l++) {
                    if ((!status[l]) && result[i][l] < min) {
                        mark = l;
                        min = result[i][l];
                    }
                }
                status[mark] = true;
                for (l = 0; l < n; l++) {
                    if ((!status[l]) && graph[mark][l] < max) {
                        if (result[i][mark] + graph[mark][l] < result[i][l]) {
                            result[i][l] = result[i][mark] + graph[mark][l];
                        }
                    }
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Runtime：" + (endTime - startTime) + "ms");   //test the runtime of this algorithm
        System.out.println("Result: ");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.print("\n");
        }
        Problem2 p = new Problem2();
        System.out.println( p.BiDijkstra(graph, 0, 10));
    }
}
