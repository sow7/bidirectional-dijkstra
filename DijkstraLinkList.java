/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a2wansongsong;

import java.util.LinkedList;

/**
 *
 * @author SONGSONG
 */
public class DijkstraLinkList {

    public static LinkedList<Integer> DijkstraLinkList(int n) {
        final int max = 10000;
        //LinkedList<Integer> p = new LinkedList<Integer>(){{add(6); add(7); add(2); add(2); add(3); add(2); add(1); add(3); add(4); add(1);}}; //test for the graph-2
        /*LinkedList<Integer> p = new LinkedList<Integer>() {     //test for the graph-1
            {
                add(2);
                add(4);
                add(3);
                add(max);
                add(9);
                add(1);
                add(max);
                add(max);
                add(3);
                add(3);
                add(max);
                add(max);
                add(max);
                add(3);
                add(2);
                add(max);
                add(4);
                add(max);
                add(1);
                add(max);
                add(6);
                add(max);
                add(2);
                add(max);
                add(max);
                add(max);
                add(max);
                add(14);
            }
        };*/
        LinkedList<Integer> p = new LinkedList<>();
         int i, j;
         for (i = 1; i < n; i++) {                 //generate the weights
         for (j = 0; j < i; j++) {
         int rand = (int) (Math.random() * 50) + 1;
         p.add((i - 1) * i / 2 + j, rand);
         }
         }
         /*for (i = 1; i < n; i++) {
         for (j = 0; j < i; j++) {
         System.out.print(p.get((i - 1) * i / 2 + j) + " ");
         }
         System.out.print("\n");
         }*/
        return p;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int n = 2000;            //input the number of nodes
        LinkedList<Integer> graph = DijkstraLinkList(n);
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<Integer> tmp = new LinkedList<>();
        int i, j, k, l, min, mark;
        int max = Integer.MAX_VALUE;
        boolean status[] = new boolean[n];
        long startTime = System.currentTimeMillis();
        for (i = 1; i < n; i++) {    //initial the result arrarylist
            for (j = 0; j < i; j++) {
                result.add(0);
            }
        }
        for (i = 0; i < n; i++) {    //initial the tmp arrarylist
            tmp.add(0);
        }
        for (j = 0; j < n; j++) {
            for (i = 0; i < n; i++) {
                if (j == i) {
                    tmp.set(i, 0);
                } else if (i > j) {
                    tmp.set(i, graph.get((i - 1) * i / 2 + j));
                } else {
                    tmp.set(i, graph.get((j - 1) * j / 2 + i));
                }
                status[i] = false;
            }
            status[j] = true;
            for (k = 1; k < n; k++) {
                min = max;
                mark = j;
                for (l = 0; l < n; l++) {
                    if ((!status[l]) && tmp.get(l) < min) {
                        mark = l;
                        min = tmp.get(l);
                    }
                }
                status[mark] = true;
                for (l = 0; l < n; l++) {
                    if ((!status[l]) && graph.get((l - 1) * l / 2 + mark) < max) {
                        if (mark > l) {
                            if (tmp.get(mark) + graph.get((mark - 1) * mark / 2 + l) < tmp.get(l)) {
                                tmp.set(l, tmp.get(mark) + graph.get((mark - 1) * mark / 2 + l));
                            }
                        } else {
                            if (tmp.get(mark) + graph.get((l - 1) * l / 2 + mark) < tmp.get(l)) {
                                tmp.set(l, tmp.get(mark) + graph.get((l - 1) * l / 2 + mark));
                            }
                        }
                    }
                }
            }
            for (i = j + 1; i < n; i++) {
                result.set((i - 1) * i / 2 + j, tmp.get(i));
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Runtime：" + (endTime - startTime) + "ms");    //test the runtime of this algorithm
        System.out.println("Result: ");
        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                System.out.print(result.get((i - 1) * i / 2 + j) + " ");
            }
            System.out.print("\n");
        }
    }
}
