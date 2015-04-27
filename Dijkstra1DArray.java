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
public class Dijkstra1DArray {

    public static int[] Dijkstra1DArray(int n) {
        int max = 10000;
        //int p[] = {6, 7, 2, 2, 3, 2, 1, 3, 4, 1};    //test for the graph-2
        //int p[] = {2, 4, 3, max, 9, 1, max, max, 3, 3, max, max, max, 3, 2, max, 4, max, 1, max, 6, max, 2, max, max, max, max, 14};     //test for the graph-1
        int p[] = new int[n * (n - 1) / 2];    //generate the weights
        int i, j;
         for (i = 1; i < n; i++) {
         for (j = 0; j < i; j++) {
         p[(i - 1) * i / 2 + j] = (int) (Math.random() * 50) + 1;
         }
         }
         /*for (i = 1; i < n; i++) {
         for (j = 0; j < i; j++) {
         System.out.print(p[(i - 1) * i / 2 + j] + " ");
         }
         System.out.print("\n");
         }*/
        return p;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int n = 2000;            //input the number of nodes
        int graph[] = Dijkstra1DArray(n);
        int result[] = new int[n * (n - 1) / 2];
        int tmp[] = new int[n];
        int i, j, k, l, min, mark;
        int max = Integer.MAX_VALUE;
        boolean status[] = new boolean[n];
        long startTime = System.currentTimeMillis();
        for (j = 0; j < n; j++) {
            for (i = 0; i < n; i++) {
                if (j == i) {
                    tmp[i] = 0;
                } else if (i > j) {
                    tmp[i] = graph[(i - 1) * i / 2 + j];
                } else {
                    tmp[i] = graph[(j - 1) * j / 2 + i];
                }
                status[i] = false;
            }
            status[j] = true;
            for (k = 1; k < n; k++) {
                min = max;
                mark = j;
                for (l = 0; l < n; l++) {
                    if ((!status[l]) && tmp[l] < min) {
                        mark = l;
                        min = tmp[l];
                    }
                }
                status[mark] = true;
                for (l = 0; l < n; l++) {
                    if ((!status[l]) && graph[(l - 1) * l / 2 + mark] < max) {
                        if (mark > l) {
                            if (tmp[mark] + graph[(mark - 1) * mark / 2 + l] < tmp[l]) {
                                tmp[l] = tmp[mark] + graph[(mark - 1) * mark / 2 + l];
                            }
                        } else {
                            if (tmp[mark] + graph[(l - 1) * l / 2 + mark] < tmp[l]) {
                                tmp[l] = tmp[mark] + graph[(l - 1) * l / 2 + mark];
                            }
                        }
                    }
                }
            }
            for (i = j + 1; i < n; i++) {
                result[(i - 1) * i / 2 + j] = tmp[i];
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Runtime：" + (endTime - startTime) + "ms");  //test the runtime of this algorithm
        System.out.println("Result: ");
         for (i = 1; i < n; i++) {
         for (j = 0; j < i; j++) {
         System.out.print(result[(i - 1) * i / 2 + j] + " ");
         }
         System.out.print("\n");
         }
    }
}
