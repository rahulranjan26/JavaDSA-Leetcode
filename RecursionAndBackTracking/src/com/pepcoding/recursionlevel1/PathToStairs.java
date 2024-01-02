package com.pepcoding.recursionlevel1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PathToStairs {
    public static void main(String[] args) {
        System.out.println("We will find stairs path for this question");

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> ans = findPath(n);
        System.out.println(ans);
    }

    private static ArrayList<String> findPath(int n) {
        if (n == 0) {
            ArrayList<String> ans = new ArrayList<>(List.of(" "));
            return ans;
        }
        if (n < 0) {
            ArrayList<String> ans = new ArrayList<>();
            return ans;
        }
        ArrayList<String> path1 = findPath(n - 1);
        ArrayList<String> path2 = findPath(n - 2);
        ArrayList<String> path3 = findPath(n - 3);
        ArrayList<String> ans = new ArrayList<>();

        for (String pt : path1) {
            ans.add(1 + pt);
        }
        for (String pt : path2) {
            ans.add(2 + pt);
        }
        for (String pt : path3) {
            ans.add(3 + pt);
        }
        return ans;
    }
}
