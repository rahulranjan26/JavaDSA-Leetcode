package com.pepcoding.recursionlevel1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAllSubSequences {
    public static void main(String[] args) {
        System.out.println("Print All the subsequences of a string");
//        abc  : [a,b,c,ab,ac,b,bc,_] --> That is for n length we have 2^n subsequences.
        Scanner scn = new Scanner(System.in);
        String string = scn.next();
        ArrayList<String> ans = findSS(string);
        System.out.println(ans);

    }

    private static ArrayList<String> findSS(String string) {
        if (string.length() == 0) {
            ArrayList<String> left;
            left = new ArrayList<>(List.of(" "));
            return left;
        }
        char ch = string.charAt(0);
        String ros = string.substring(1);
        ArrayList<String> temp = findSS(ros);
        ArrayList<String> ans = new ArrayList<>();
        for (String st : temp) {
            String tt = ch + st;
            ans.add(tt);
        }
        for (String st : temp) {
            ans.add(st);
        }
        return ans;

    }
}
