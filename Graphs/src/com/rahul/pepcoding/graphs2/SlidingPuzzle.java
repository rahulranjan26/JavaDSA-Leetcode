package com.rahul.pepcoding.graphs2;

import java.util.HashSet;
import java.util.LinkedList;

public class SlidingPuzzle {
    public static void main(String[] args) {
        System.out.println("We will solve the sliding puzzle");
        int[][] puzzle = {{4, 1, 2}, {5, 0, 3}};
        StringBuilder st = new StringBuilder();
        for (int[] ints : puzzle) {
            for (int anInt : ints) {
                st.append(anInt);
            }
        }
        String newString = st.toString();
        HashSet<String> set = new HashSet<>();
        set.add(newString);
        String strFinal = "123450";
        int[][] swapIdx = {{1, 5}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        int level = 0;
        LinkedList<String> queue = new LinkedList<>();
        queue.addLast(newString);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String str = queue.removeFirst();
                if (str.equals(strFinal)) {
                    System.out.println(level);
                    break;
                }

                int idx = -1;
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '0') {
                        idx = i;
                        break;
                    }
                }
                int[] swap = swapIdx[idx];
                for (int j : swap) {
                    String getStr = swappedString(str, j, idx);
                    if (set.contains(getStr)) {
                        continue;
                    }
                    queue.addLast(getStr);
                    set.add(str);
                }
            }
            level++;
        }
        System.out.println(-1);
    }

    private static String swappedString(String str, int i, int idx) {
        StringBuilder newStr = new StringBuilder(str);
        newStr.setCharAt(i, str.charAt(idx));
        newStr.setCharAt(idx, str.charAt(i));
        return newStr.toString();
    }
}
