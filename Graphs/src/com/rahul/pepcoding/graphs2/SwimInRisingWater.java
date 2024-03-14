package com.rahul.pepcoding.graphs2;

import java.util.PriorityQueue;

public class SwimInRisingWater {
    public static class Pair implements Comparable<Pair> {
        int row;
        int col;
        int msf;

        Pair(int row, int col, int msf) {
            this.row = row;
            this.msf = msf;
            this.col = col;
        }

        @Override
        public int compareTo(Pair o) {
            return this.msf - o.msf;
        }
    }

    public static void main(String[] args) {
        System.out.println("We will swim now in this question");
        int[][] water = {
                {0, 1, 2, 25, 7},
                {22, 26, 27, 28, 8},
                {23, 17, 18, 20, 26},
                {24, 3, 9, 12, 15},
                {32, 31, 30, 33, 5}
        };
        int ans = 0;
        int n = water.length;
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(0, 0, water[0][0]));
        boolean[][] visited = new boolean[water.length][water.length];
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            Pair rem = queue.remove();

            if (rem.row == n - 1 && rem.col == n - 1) {
                System.out.println(rem.msf);
                break;
            }
            if (visited[rem.row][rem.col])
                continue;
            visited[rem.row][rem.col] = true;
            for (int[] dir : dirs) {
                int ro = rem.row + dir[0];
                int co = rem.col + dir[1];
                if (isValid(ro, co, n, visited)) {
                    queue.add(new Pair(ro, co, Math.max(rem.msf, water[ro][co])));

                }

            }
        }
    }

    private static boolean isValid(int ro, int co, int n, boolean[][] visited) {
        if (ro >= 0 && co >= 0 && ro < n && co < n && !visited[ro][co])
            return true;
        return false;
    }
}
