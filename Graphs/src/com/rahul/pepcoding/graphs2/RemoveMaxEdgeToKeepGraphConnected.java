package com.rahul.pepcoding.graphs2;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveMaxEdgeToKeepGraphConnected {
    public static void main(String[] args) {
        System.out.println("We will work on adding the edges");
        int[][] edges = new int[6][3];
        edges = new int[][]{{3, 1, 2}, {1, 1, 3}, {2, 2, 4}, {2, 3, 4}, {1, 1, 2}, {3, 2, 3}};
        int[] parentX = new int[5];
        int[] parentY = new int[5];
        int[] rankX = new int[5];
        int[] rankY = new int[5];
        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));
        for (int i = 1; i < 5; i++) {
            parentX[i] = i;
            parentY[i] = i;
            rankX[i] = 1;
            rankY[i] = 1;

        }
        int count = 0;
        int mergeX = 1;
        int mergeY = 1;
        for (var edge : edges) {
            int flag = edge[0];
            int u = edge[1];
            int v = edge[2];
            if (flag == 3) {
                boolean tempX = union(u, v, parentX, rankX);
                boolean tempY = union(u, v, parentY, rankY);
                if (tempX)
                    mergeX++;
                if (tempY)
                    mergeY++;
                if (!tempX && !tempY)
                    count++;
            } else if (flag == 2) {
                boolean tempX = union(u, v, parentX, rankX);
                if (tempX)
                    mergeX++;
                if (!tempX)
                    count++;
            } else {
                boolean tempY = union(u, v, parentY, rankY);
                if (tempY)
                    mergeY++;
                if (!tempY)
                    count++;
            }
        }
        System.out.println(mergeX + "  " + mergeY);
        if (mergeX != 4 || mergeY != 4)
            System.out.println("Can't do");
        else
            System.out.println(count);

    }

    public static int find(int x, int[] parent) {
        if (parent[x] == x)
            return x;
        int temp = find(parent[x], parent);
        parent[x] = temp;
        return temp;
    }

    public static boolean union(int x, int y, int[] parent, int[] rank) {
        int lx = find(x, parent);
        int ly = find(y, parent);

        if (lx != ly) {
            if (rank[lx] > rank[ly])
                parent[ly] = lx;
            else if (rank[lx] < rank[ly]) {
                parent[lx] = ly;
            } else {
                parent[ly] = lx;
                rank[lx]++;
            }
            return true;
        }
        return false;
    }
}
