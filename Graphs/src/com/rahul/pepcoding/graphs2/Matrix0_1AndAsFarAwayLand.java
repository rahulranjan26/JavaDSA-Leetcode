package com.rahul.pepcoding.graphs2;

import java.util.LinkedList;

public class Matrix0_1AndAsFarAwayLand {
    public static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        System.out.println("We will see rotten oranges problem");
        int[][] rottenMat = {
                {0, 0, 0, 1},
                {1, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 1, 0, 0}
        };
        LinkedList<Pair> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < rottenMat.length; i++) {
            for (int j = 0; j < rottenMat[0].length; j++) {
                if (rottenMat[i][j] ==1)
                    queue.addLast(new Pair(i, j));
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Pair coords = queue.removeFirst();
                int x = coords.i;
                int y = coords.j;
                int[][] diff = {
                        {-1, 0},
                        {0, 1},
                        {1, 0},
                        {0, -1}
                };
                for (int i = 0; i < diff.length; i++) {
                    int xx = x + diff[i][0];
                    int yy = y + diff[i][1];

                    if (isValid(rottenMat, xx, yy)) {
                        rottenMat[xx][yy] = rottenMat[x][y]+1;
                        queue.addLast(new Pair(xx, yy));
                    }
                }
            }
        }
        for (int i = 0; i < rottenMat.length; i++) {
            for (int j = 0; j < rottenMat[0].length; j++) {
                System.out.print(rottenMat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isValid(int[][] rottenMat, int xx, int yy) {
        if (xx >= 0 && yy >= 0 && xx < rottenMat.length && yy < rottenMat[0].length && rottenMat[xx][yy] == 0)
            return true;
        return false;
    }
}
