package com.rahul.pepcoding.graphs1;

public class numberOfIslands {
    public static void main(String[] args) {
        System.out.println("We will count the number of islands in the graph now");
        int[][] island = {
                {1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1}
        };
        boolean[][] visited = new boolean[island.length][];
        for (int i = 0; i < island.length; i++) {
            visited[i] = new boolean[island[i].length];
        }
        int count = 0;
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                if (!visited[i][j] && island[i][j] == 1) {
                    findIslands(island, i, j, visited);
                    count++;
                }

            }
        }
        System.out.println(count);

    }

    private static void findIslands(int[][] island, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= island.length || j >= island[i].length || visited[i][j] || island[i][j] == 0)
            return;
        visited[i][j] = true;
        findIslands(island, i - 1, j, visited);
        findIslands(island, i, j + 1, visited);
        findIslands(island, i + 1, j, visited);
        findIslands(island, i, j - 1, visited);
    }
}
