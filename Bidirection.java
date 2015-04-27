/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a5wansongsong;

/**
 *
 * @author SONGSONG
 */
public class Bidirection {

    final static int INF = 99999;
    static int node = 99999;

    public int BiDijkstra(int[][] weight, int start, int end) {
        int length = weight.length;
        int[] startDistance = new int[length];
        boolean[] startVisited = new boolean[length];
        int[] endDistance = new int[length];
        boolean[] endVisited = new boolean[length];
        for (int i = 0; i < length; i++) {
            startDistance[i] = weight[start][i];
            endDistance[i] = weight[end][i];
            startVisited[i] = false;
            endVisited[i] = false;
        }
        startVisited[start] = true;
        endVisited[end] = true;
        int startcurr = 0;
        int endcurr = 0;
        int totalLength = INF;
        while (startcurr + endcurr < totalLength) {
            int startnext = 0;
            int starttmp = INF;
            for (int i = 0; i < length; i++) {
                if (!startVisited[i] && startDistance[i] < starttmp) {
                    starttmp = startDistance[i];
                    startnext = i;
                }
            }
            startcurr = starttmp;
            startVisited[startnext] = true;
            int endnext = 0;
            int endtmp = INF;
            for (int i = 0; i < length; i++) {
                if (!endVisited[i] && endDistance[i] < endtmp) {
                    endtmp = endDistance[i];
                    endnext = i;
                }
            }
            endcurr = endtmp;
            endVisited[endnext] = true;
            int min = INF;
            for (int i = 0; i < length; i++) {
                if (min > (startDistance[i] + endDistance[i])) {
                    min = startDistance[i] + endDistance[i];
                    node=i;
                }
            }
            if (min < totalLength) {
                totalLength = min;
            }
            for (int i = 0; i < length; i++) {
                if (!startVisited[i] && (startDistance[i] > starttmp + weight[startnext][i])) {
                    startDistance[i] = starttmp + weight[startnext][i];
                }
            }
            for (int i = 0; i < length; i++) {
                if (!endVisited[i] && (endDistance[i] > endtmp + weight[endnext][i])) {
                    endDistance[i] = endtmp + weight[endnext][i];
                }
            }
        }
        return totalLength;
    }

    public static void main(String[] args) {
//        for(int n=100;n<20000;n=n+200){
//        //int n = 100;
//        int[][] graph = new int[n][n];
//        int i, j, weight;
//        for (i = 0; i < n; i++) {          //generate the weights
//            for (j = i; j < n; j++) {
//                if (j == i) {
//                    graph[i][j] = 0;
//                } else {
//                    weight = (int) (Math.random() * 1000) + 1;
//                    graph[i][j] = weight;
//                    graph[j][i] = weight;
//                }
//            }
//        }
//        long startTime = System.currentTimeMillis();
//        for (i = 0; i < n * 0.1; i++) {
//            int start = (int) (Math.random() * n);
//            int end = (int) (Math.random() * n);
//            while (end == start) {
//                end = (int) (Math.random() * n);
//            }
//            Problem2 test = new Problem2();
//            int path = test.BiDijkstra(graph, start, end);
//            int path1 = test.BiDijkstra(graph, end, start);
//            if (path != path1) {
//                System.out.print("the result is different if the start and end node exchange");
//            }
//            //System.out.println(start+" "+end+"shortest path is " + path + "  ");
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println(n+" Runtime: " + (endTime - startTime) + "ms");   //test the runtime of this algorithm
//        }
//        int[][] graph1 = {   //Test Case 1
//            {0, 79, INF, INF, 86, 117, INF, INF},
//            {79, 0, INF, 178, INF, 83, INF, 55},
//            {INF, INF, 0, INF, 102, 43, 42, 130},
//            {INF, 178, INF, 0, 126, INF, 75, 116},
//            {86, INF, 102, 126, 0, INF, INF, INF},
//            {117, 83, 43, INF, INF, 0, 193, INF},
//            {INF, INF, 42, 75, INF, 193, 0, 138},
//            {INF, 55, 130, 116, INF, INF, 138, 0}
//        };
//        int[][] graph2 = {
//            {0, 1, INF, INF, INF, INF, 2},
//            {1, 0, 4, INF, INF, INF, INF},
//            {INF, 4, 0, 4, INF, INF, INF},
//            {INF, INF, 4, 0, 2, INF, INF},
//            {INF, INF, INF, 2, 0, 1, INF},
//            {INF, INF, INF, INF, 1, 0, 5},
//            {2, INF, INF, INF, INF, 5, 0},};
        int[][] graph3 = {  //Test Case 2
            {0, INF, 40, 120, INF, 95, 129, 140, INF, INF, INF},
            {INF, 0, 103, INF, INF, INF, INF, INF, 72, INF, INF},
            {40, 103, 0, 104, INF, 90, INF, 89, INF, INF, 198},
            {120, INF, 104, 0, INF, INF, INF, INF, INF, INF, INF},
            {INF, INF, INF, INF, 0, 97, INF, INF, 112, INF, INF},
            {95, INF, 90, INF, 97, 0, INF, 146, INF, 200, INF},
            {129, INF, INF, INF, INF, INF, 0, INF, INF, 40, INF},
            {140, INF, 89, INF, INF, 146, INF, 0, INF, INF, INF},
            {INF, 72, INF, INF, 112, INF, INF, INF, 0, INF, INF},
            {INF, INF, INF, INF, INF, 200, 40, INF, INF, 0, INF},
            {INF, INF, 198, INF, INF, INF, INF, INF, INF, INF, 0}
        };
        Bidirection test = new Bidirection();
        int path = test.BiDijkstra(graph3, 6, 8);
        node++;
        System.out.println("The meeting node is node "+node+". ");
        System.out.println("The shortest path from 7 to 9 is " + path + ".");
    }
}
