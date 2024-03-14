package com.rahul.pepcoding.graphs2;


import java.util.Arrays;

public class MinSwapsToSort {
    public static class Pair implements Comparable<Pair> {
        int i;
        int idx;

        Pair(int i, int idx) {
            this.i = i;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair o) {
            return this.i - o.i;
        }
    }

    public static void main(String[] args) {
        System.out.println("We will work on minimum swaps to sort an array");
        int[] arr = {5, 9, 1, 4, 7, 3, 6, 8, 0};
        Pair[] pairArr = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pairArr[i] = new Pair(arr[i], i);

        }
        Arrays.sort(pairArr);
        boolean[] vis = new boolean[arr.length];
        int ans = 0;
        for (int i = 0; i < pairArr.length; i++) {
            Pair el = pairArr[i];
            if (vis[i] || i == el.idx)
                continue;
            int j = i;
            int cy = 0;
            while (!vis[j]) {
                vis[j] = true;
                j = pairArr[j].idx;
                cy++;
            }
            ans = ans + cy - 1;
        }
        System.out.println(ans);
    }

}
