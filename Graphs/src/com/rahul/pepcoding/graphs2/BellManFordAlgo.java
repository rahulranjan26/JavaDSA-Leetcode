package com.rahul.pepcoding.graphs2;

import java.util.Arrays;

public class BellManFordAlgo {
    public static void main(String[] args) {
        System.out.println("This is another algorithm to know what is the shortest path " +
                "in terms of edge weights from source to every other point");
        int[][] graph = {
                {0, 3, 6},
                {0, 1, 4},
                {1, 2, 7},
                {2, 3, -18},
                {2, 5, -2},
                {3, 4, 2},
                {4, 5, 3}
        };
        int[] path = new int[6];
        Arrays.fill(path, Integer.MAX_VALUE);
        path[0] = 0;
        for (int i = 0; i < 5; i++) {
            for (int[] ints : graph) {
                int u = ints[0];
                int v = ints[1];
                int wt = ints[2];
                if (path[u] == Integer.MAX_VALUE)
                    continue;
                if (path[u] + wt < path[v])
                    path[v] = path[u] + wt;
            }
        }
        System.out.println(Arrays.toString(path));
        for (int[] ints : graph) {
            int u = ints[0];
            int v = ints[1];
            int wt = ints[2];
            if (path[u] == Integer.MAX_VALUE)
                continue;
            if (path[u] + wt < path[v])
                System.out.println("Negative cycle is present So BF is not applicable");
        }
    }
}
