package com.pepcoding.recursionlevel2;

public class MaximumGoldInPath {
    int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return 0;
        int gold = grid[i][j];
        grid[i][j] = 0;
        int ans = gold + Math.max(dfs(grid, i - 1, j), Math.max(dfs(grid, i, j - 1), Math.max(dfs(grid, i, j + 1), dfs(grid, i + 1, j))));
        grid[i][j] = gold;
        return ans;

    }


    public int getMaximumGold(int[][] grid) {

        int maxi = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {


                    maxi = Math.max(maxi, dfs(grid, i, j));
                }
            }
        }
        return maxi;
    }
}

