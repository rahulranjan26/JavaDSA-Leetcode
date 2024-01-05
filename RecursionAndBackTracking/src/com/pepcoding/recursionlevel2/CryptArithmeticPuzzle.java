package com.pepcoding.recursionlevel2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class CryptArithmeticPuzzle {
    public static void main(String[] args) {
        System.out.println("Lets solve the Crypt arithmetic Puzzle");
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        String s3 = scn.next();
        HashSet<Character> set = new HashSet<>();
        String s = s1 + s2 + s3;
        StringBuilder unique = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!set.contains(ch)) {
                set.add(ch);
                unique.append(ch);
            }
        }
        String unique2 = unique.toString();
        HashMap<Character, Integer> map = new HashMap<>();
        boolean[] visited = new boolean[10];
        findTheMapping(map, unique2, visited, s1, s2, s3, 0);

    }

    private static void findTheMapping(HashMap<Character, Integer> map, String unique, boolean[] visited, String s1, String s2, String s3, int idx) {
        if (idx == unique.length()) {
            int num1 = getNum(s1, map);
            int num2 = getNum(s2, map);
            int num3 = getNum(s3, map);
            if (num1 + num2 == num3) {
                for (int i = 0; i < 26; i++) {
                    char ch = (char) (i + 'a');
                    if (map.containsKey(ch)) {
                        System.out.print(ch + "-" + map.get(ch) + " ");
                    }
                }
                System.out.println();
            }
//
            return;
        }


        char ch = unique.charAt(idx);
        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                visited[i] = true;
                map.put(ch, i);
                findTheMapping(map, unique, visited, s1, s2, s3, idx + 1);
                visited[i] = false;
                map.put(ch, -1);

            }
        }
    }

    private static int getNum(String s, HashMap<Character, Integer> map) {
        String num = "";
        for (int i = 0; i < s.length(); i++) {
            num += map.get(s.charAt(i));
        }
        return Integer.parseInt(num);
    }
}
