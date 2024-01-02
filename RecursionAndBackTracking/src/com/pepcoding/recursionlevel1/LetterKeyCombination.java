package com.pepcoding.recursionlevel1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class LetterKeyCombination {
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void main(String[] args) {
        System.out.println("KeyPad Combination question");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        ArrayList<String> ans = findCombination(str);


        System.out.println(ans + " " + ans.size());
    }

    private static ArrayList<String> findCombination(String str) {
        if (str.length() == 0) {
            ArrayList<String> st = new ArrayList<>(List.of(" "));
            return st;
        }

        int idx = str.charAt(0) - '0';
        String ros = str.substring(1);
        ArrayList<String> temp = findCombination(ros);
        String codeString = codes[idx];
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < codeString.length(); i++) {
            for (String s : temp) {
                char ch = codeString.charAt(i);
                String st = s;
                String tempStr = ch + st;
                ans.add(tempStr);
            }
        }
        return ans;
    }

}
