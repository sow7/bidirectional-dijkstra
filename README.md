# bidirectional-dijkstra
## Pseudo-code for the bi-directional shortest path search problem
    Input parameters: n, int weight[n][n], start, end
    Output parameter: totalLength

    PROGRAM bi-directional:                               big O
    Read n, graph, start, end;
    INF=99999;                                              1
    FOR i=0 to n-1
       startDistance[i]=weight[start][i];                   n
       endDistance[i]=weight[end][i];                       n
       startVisited[i]=false;                               n
       endVisited[i]=false;                                 n
    ENDFOR;
    startVisited[start]=true;                               1
    endVisited[end]=true;                                   1
    startCurrent=0;                                         1
    endCurrent=0;                                           1
    totalLength=INF;                                        1
    WHILE(startCurrent+endCurrent<totalLength)         n/2*(5n+11)
      DO startnext=0;
          starttmp=INF;
    FOR i=0 to n-1
       IF (the node is not visited by start node, and startDistance[i] <starttmp)
         THEN starttmp=startDistance[i];
               startnext=i;
      ENDIF;
      ENDFOR;
       startCurrent=starttmp;
       startVisited[startnext]=true;
       endnext=0;
       endtmp=INF;
       FOR i=0 to n-1
          IF(this node is not visited by end node, and endDistance[i]<endtmp)
             THEN endtmp=endDistance[i];
                  endnext=i;
          ENDIF;
       ENDFOR;
       endCurrent=endtmp;
       endVisited[endnext]=true;
       min=INF;
       FOR i=0 to n-1
          IF(min>startDistance[i]+endDistance[i])
             THEN min= startDistance[i]+endDistance[i];
          ENDIF;
       ENDFOR;
       IF(min<totalLength)
         THEN totalLength=min;
      ENDIF;
       FOR i=0 to n-1
          IF(this node isn’t visited by start, and startDistance[i] >starttmp+weight[startnext][i])
            THEN startDistance[i] =starttmp+weight[startnext][i]
          ENDIF;
       ENDFOR;
       FOR
          IF(this node isn’t visited by end, and endDistance[i] >endtmp+weight[endnext][i])
             THEN endDistance[i] =endtmp+weight[endnext][i]
         ENDIF;
      ENDFOR
    ENDWHILE;
    OUTPUT totalLength;
    END.

## Time complexity:

### Theoretical Big O notation:
Just sum the result on the left of the Pseudo-code, the result is: 6+4n+2.5n2+5.5n=2.5n2+9.5n+6
So the big O analysis for this algorithm is O(n2)
### Experimental time complexity analysis:
 ![alt tag](https://github.com/sow7/bidirectional-dijkstra/blob/master/Bidi.png)
Even though the plots of time is not as much as precise O(n3), I think it is correct. Because when the complete graph is very large, and the random value is not very big it is not hard to find the shortest path.

Comparing: 
  ![alt tag](https://github.com/sow7/bidirectional-dijkstra/blob/master/Onedi.png)
The graph above is the time consume plots. The whole plot is similar as that of bi-directional shortest path search algorithm. Since their Big O notation is the same O(n3). While, the time needs for specific number of nodes graph is much shorter for bidirectional. The first reason is that the Dijkstra algorithm traverse all the possible path to find the optimal result, with the bi-directional algorithm just traverse a part of the possible path. The other reason is that bi-diractional implementation just find the shortest path between 10% nodes pairs. But for Dijkstra implementation, I not only find the shortest path between the start node to any other nodes but also find the path between any two nodes in the graph. That’s why the time for bi-diractional algorithm is much faster.
