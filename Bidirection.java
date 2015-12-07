/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a5wansongsong;

/**
 * This is my solution for the Bi-directional shortest path problem 
 * @author SONGSONG
 */
public class Bidirection {

    final static int INF = 99999; //INF means the node is not connect
    static int meetNode = 0; // This is the node that two directions meet at

    /**
     *
     * @param graph
     * @param start
     * @param end
     * @return the shortest length between start node and end node
     */
    public int BiDijkstra(int[][] graph, int startNode, int endNode) {
        int length = graph.length;
        int startIdx = startNode - 1;
        int endIdx = endNode - 1;

        // startDistance[i] means the distance between startNode and i node, same for endDistance array
        int[] startDistance = new int[length];
        int[] endDistance = new int[length];

        // startVisited record whether or not the node already visited by startNode and endNode
        boolean[] startVisited = new boolean[length];
        boolean[] endVisited = new boolean[length];

        for (int i = 0; i < length; i++) {
            startDistance[i] = graph[startIdx][i];
            endDistance[i] = graph[endIdx][i];
        }
        startVisited[startIdx] = true;
        endVisited[endIdx] = true;
        int startCurr = 0;
        int endCurr = 0;
        int shortestLength = INF;

        // if next shortest distance for startNode plus next shortest distance for endNode is not smaller than current shortestLength, return it
        while (startCurr + endCurr < shortestLength) {
            // find next unvisited shortest distance for startNode
            int startNext = 0;
            int startTmp = INF;
            for (int i = 0; i < length; i++) {
                if (!startVisited[i] && startDistance[i] < startTmp) {
                    startTmp = startDistance[i];
                    startNext = i;
                }
            }
            startCurr = startTmp;
            startVisited[startNext] = true;
            
            // find next unvisited shortest distance for endNode
            int endNext = 0;
            int endTmp = INF;
            for (int i = 0; i < length; i++) {
                if (!endVisited[i] && endDistance[i] < endTmp) {
                    endTmp = endDistance[i];
                    endNext = i;
                }
            }
            endCurr = endTmp;
            endVisited[endNext] = true;
            
            // if shortestLength is greater than startDistance[i] + endDistance[i] replace it
            for (int i = 0; i < length; i++) {
                if (shortestLength > (startDistance[i] + endDistance[i])) {
                    shortestLength = startDistance[i] + endDistance[i];
                    meetNode = i + 1;
                }
            }

            // Update The startDistance Array, if the startDistance[i] is greater than startDistance[startNext] + graph[startNext][i]
            for (int i = 0; i < length; i++) {
                if (!startVisited[i] && (startDistance[i] > startTmp + graph[startNext][i])) {
                    startDistance[i] = startTmp + graph[startNext][i];
                }
            }

            // Update The endDistance Array, if the endDistance[i] is greater than endDistance[endnext] + graph[endnext][i]
            for (int i = 0; i < length; i++) {
                if (!endVisited[i] && (endDistance[i] > endTmp + graph[endNext][i])) {
                    endDistance[i] = endTmp + graph[endNext][i];
                }
            }
        }
        return shortestLength;
    }

    public static void main(String[] args) {
        // Test Case
        int[][] graph = {
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
        int startNode = 7;
        int endNode = 9;
        Bidirection test = new Bidirection();
        int path = test.BiDijkstra(graph, startNode, endNode);
        System.out.println("The meeting node is node " + meetNode + ". ");
        System.out.println("The shortest path from " + startNode + " to " + endNode + " is " + path + ".");
    }
}

