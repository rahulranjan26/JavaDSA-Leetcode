package com.rahul.pepcoding.graphs2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NumberOfIsland {
    public static void main(String[] args) {
        System.out.println("We will find the number of island in water body. This is perfect example of DSU");
        Scanner scn = new Scanner(System.in);
        int n = 3;
        int m = 5;
        //we have nXm matrix
        int[][] water = new int[3][5];
        for (int i = 0; i < n; i++) {
            Arrays.fill(water[i], 0);
        }
        int[] parent = new int[m * n];
        Arrays.fill(parent, -1);
        int[] rank = new int[m * n];
        int[][] positions = {{0, 3}, {1, 2}, {0, 2}, {1, 4}, {2, 3}, {1, 3}};
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        ArrayList<Integer> ans = new ArrayList<>();
        int count = 0;
        for (int[] pos : positions) {
            int row = pos[0];
            int col = pos[1];
            int cellNo = row * n + col;
            if (parent[cellNo] != -1) {
                ans.add(count);
                continue;
            }
            parent[cellNo] = cellNo;
            rank[cellNo] = 1;
            count++;

            //Now move in 4 directions to see if we have any neighbouring 1's or island that can merge
            for (var dir : dirs) {
                int rowDash = row + dir[0];
                int colDash = col + dir[1];
                int cellDash = rowDash * n + colDash;
                if (rowDash < 0 || colDash < 0 || rowDash >= n || colDash >= m || parent[cellDash] == -1)
                    continue;
                int lx = parent(cellNo, parent);
                int ly = parent(cellDash, parent);

                //Merging process
                if (lx != ly) {
                    if (rank[lx] > rank[ly]) {
                        parent[ly] = lx;
                    } else if (rank[lx] < rank[ly]) {
                        parent[lx] = ly;
                    } else {
                        parent[lx] = ly;
                        rank[ly]++;
                    }
                    count--;
                }
            }
            ans.add(count);
        }
        System.out.println(ans);
    }

    public static int parent(int x, int[] parentX) {
        if (parentX[x] == x)
            return x;
        int temp = parent(parentX[x], parentX);
        parentX[x] = temp;
        return temp;
    }
}
