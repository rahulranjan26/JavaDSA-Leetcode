package com.pepcoding.recursionlevel1;

public class FloodFill {
    public static void main(String[] args) {
        System.out.println("We will learn about Flood fill in this piece of code");
        int[][] mat = {{1, 0, 1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1}};
        boolean[][] visited = new boolean[6][7];
        floodFill(mat, visited, 0, 0, "");
    }

    private static void floodFill(int[][] mat, boolean[][] visited, int r, int c, String s) {
        if (r < 0 || c < 0 || r >= mat.length || c >= mat[0].length || mat[r][c] == 0 || visited[r][c]) {
//            System.out.println(s);
            return;
        }
        if (r == mat.length - 1 && c == mat[0].length - 1) {
            System.out.println(s.substring(0, s.length() - 2));
            return;
        }
        visited[r][c] = true;
        floodFill(mat, visited, r - 1, c, s + "U->");
        floodFill(mat, visited, r, c + 1, s + "R->");
        floodFill(mat, visited, r + 1, c, s + "D->");
        floodFill(mat, visited, r, c - 1, s + "L->");
        visited[r][c] = false;
    }
}
