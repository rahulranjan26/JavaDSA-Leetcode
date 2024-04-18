package com.pepcoding.dplevel2;

public class ScrambleStrings {
    public static void main(String[] args) {
        System.out.println("We will work on scramble strings on this question");
        String s1 = "great";
        String s2 = "aterg";
        System.out.println(isScramble(s1, s2));

    }


    private static boolean isScramble(String s1, String s2) {
        if (s1.equals(s2))
            return true;

        for (int i = 1; i < s1.length(); i++) {
            if ((isScramble(s1.substring(0, i), s2.substring(0, i))
                    &&
                    isScramble(s1.substring(i), s2.substring(i))
            ) ||
                    (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
                            &&
                            isScramble(s1.substring(s1.length() - i), s2.substring(0, i)))
            )
                return true;

        }
        return false;
    }
}

// Memoization
