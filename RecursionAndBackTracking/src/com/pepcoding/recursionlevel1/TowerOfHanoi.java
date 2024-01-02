package com.pepcoding.recursionlevel1;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        System.out.println("Print Instructions to move discs from A to B using C as assist");
        Scanner scanner = new Scanner(System.in);
        int disk = scanner.nextInt();
        String from = "A";
        String to = "B";
        String help = "C";
        towerOfHanoi(disk, from, to, help);
    }

    private static void towerOfHanoi(int disk, String A, String B, String C) {
        if (disk == 0) {
            return;
        }
        towerOfHanoi(disk - 1, A, C, B);
        System.out.println("Move disk " + disk + " from " + A + " to " + B);
        towerOfHanoi(disk - 1, C, B, A);

    }
}
