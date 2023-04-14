import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int start, int A, int B, int[][] fares) {
        int[][] distance = new int[n+1][n+1];
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= n; j++){
                distance[i][j] = 20000000;
                if (i == j) distance[i][j] = 0;
            }
        }
        for (int i = 0; i < fares.length; i++){
            int s = fares[i][0];
            int e = fares[i][1];
            int v = fares[i][2];
            distance[s][e] = v;
            distance[e][s] = v;
        }
        
        for (int k = 1; k <= n; k++){
            for (int i = 1; i <= n; i++){
                for (int j = 1; j <= n; j++){
                    if (i == j) break;
                    if (distance[i][j] > distance[i][k] + distance[k][j]){
                        distance[i][j] = distance[i][k] + distance[k][j];
                        distance[j][i] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
        // for (int[] dis: distance) System.out.println(Arrays.toString(dis));
        int min = Integer.MAX_VALUE;
        for (int k = 1; k <= n; k++){
            min = Math.min(min, distance[start][k] + distance[k][A] + distance[k][B]);
            // if (distance[start][k] + distance[k][A] + distance[k][B] < min)
            //     min = 
        }
        // int answer = 0;
        return min;
    }
}