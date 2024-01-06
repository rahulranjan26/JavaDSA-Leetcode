package com.pepcoding.recursionlevel2;

import java.util.ArrayList;
import java.util.Scanner;

public class KPartitionSubsets {
    public static void main(String[] args) {
        System.out.println("We will discuss about the partitioning the array in K subset");
        Scanner scn = new Scanner(System.in);
        int K = scn.nextInt();
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        ArrayList<ArrayList<Character>> subsets = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            subsets.add(new ArrayList<Character>());
        }

        findPartitions(arr, 0, 0, subsets, K);

    }

    private static void findPartitions(char[] arr, int idx, int sssf, ArrayList<ArrayList<Character>> subsets, int K) {
        if (idx == arr.length) {
            if (sssf == K) {
                for (ArrayList<Character> sub : subsets) {
//                    if (sub.size() > 1)
                    System.out.print(sub);
                }
                System.out.println();

            }
            return;
        }


        for (int i = 0; i < subsets.size(); i++) {
            if (subsets.get(i).size() > 0) {
                subsets.get(i).add(arr[idx]);
                findPartitions(arr, idx + 1, sssf, subsets, K);
                subsets.get(i).remove(subsets.get(i).size() - 1);
            } else {
                subsets.get(i).add(arr[idx]);
                findPartitions(arr, idx + 1, sssf + 1, subsets, K);
                subsets.get(i).remove(subsets.get(i).size() - 1);
            }

        }
    }
}
