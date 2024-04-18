package com.pepcoding.dplevel2;

import java.util.LinkedList;

public class PathToReachTopStairInMiniJumps {
    private static class Pair {
        int idx;
        int sa;
        int st;
        String psf;

        Pair(int idx, int sa, int st, String psf) {
            this.idx = idx;
            this.st = st;
            this.psf = psf;
            this.sa = sa;
        }
    }

    public static void main(String[] args) {
        System.out.println("We will work on finding the path to the top of the stairs with minimum jumps");
        int[] arr = {3, 3, 0, 2, 1, 2, 4, 2, 0, 0};
        Integer[] dp = new Integer[arr.length];
        dp[arr.length - 1] = 0;

        for (int i = arr.length - 2; i >= 0; i--) {
            int steps = arr[i];

            int tempAns = Integer.MAX_VALUE;
            for (int j = 1; j <= steps && i + j < arr.length; j++) {
                if (dp[j + i] != null && tempAns > dp[j + i])
                    tempAns = dp[i + j];
            }

            if (tempAns != Integer.MAX_VALUE) {
                dp[i] = tempAns + 1;
            }
        }
//        System.out.println(Arrays.toString(dp));
        LinkedList<Pair> queue = new LinkedList<>();
        Pair p = new Pair(0, arr[0], dp[0], "0");
        queue.addFirst(p);

        while (!queue.isEmpty()) {
            Pair pp = queue.removeFirst();
            int idx = pp.idx;
            int sa = pp.sa;
            int st = pp.st;
            String psf = pp.psf;
            if (idx == arr.length - 1) {
                System.out.println(psf);
                continue;
            }
//            int min = Integer.MAX_VALUE;
//            int idxx = 0;
            for (int i = 1; i <= sa && idx + i < arr.length; i++) {
                if (dp[i + idx] != null && dp[i + idx] == st - 1) {
                    int temp = i + idx;
                    Pair pair = new Pair(i + idx, arr[idx + i], dp[idx + i], psf + " " + temp);
                    queue.addLast(pair);
                }
            }
        }
    }
}
