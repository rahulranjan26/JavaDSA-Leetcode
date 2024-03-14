package com.rahul.pepcoding.graphs2;

import java.util.LinkedList;

public class RottenOranges {
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
                {0, 0, 1, 0, 1, 2, 1},
                {1, 1, 2, 0, 0, 0, 1},
                {0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 2, 1},
                {1, 1, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 2, 0, 0},
                {1, 0, 0, 1, 1, 0, 1}
        };
        LinkedList<Pair> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < rottenMat.length; i++) {
            for (int j = 0; j < rottenMat[0].length; j++) {
                if (rottenMat[i][j] == 2)
                    queue.addLast(new Pair(i, j));
                if (rottenMat[i][j] == 1)
                    fresh += 1;
            }
        }
        int hours = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            hours++;
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
                        rottenMat[xx][yy] = 2;
                        queue.addLast(new Pair(xx, yy));
                        fresh--;
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
        System.out.println(fresh + " " + hours);
    }

    private static boolean isValid(int[][] rottenMat, int xx, int yy) {
        if (xx >= 0 && yy >= 0 && xx < rottenMat.length && yy < rottenMat[0].length && rottenMat[xx][yy] == 1)
            return true;
        return false;
    }
}
