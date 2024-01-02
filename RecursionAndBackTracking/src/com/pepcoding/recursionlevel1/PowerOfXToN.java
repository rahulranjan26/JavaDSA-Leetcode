package com.pepcoding.recursionlevel1;

import java.util.Scanner;

public class PowerOfXToN {
    public static void main(String[] args) {
        System.out.println("We will learn about the X getting raised to power N");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        long ans = powerofXtoN(x, n);
        System.out.println(ans);

    }

    private static long powerofXtoN(int x, int n) {
        if (n == 0)
            return 1;

        long xp2 = powerofXtoN(x, n / 2);
        long xn = xp2 * xp2;
        if (n % 2 == 1)
            xn = x * xn;
        return xn;
    }
}
