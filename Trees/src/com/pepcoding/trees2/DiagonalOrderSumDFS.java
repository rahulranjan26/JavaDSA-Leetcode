package com.pepcoding.trees2;

import java.util.ArrayList;
import java.util.HashMap;

public class DiagonalOrderSumDFS {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        System.out.println("Left view Of Tree");
        Node root = new Node(8);
        Node n1 = new Node(4);
        Node n2 = new Node(11);
        Node n3 = new Node(2);
        Node n4 = new Node(6);
        Node n5 = new Node(10);
        Node n6 = new Node(12);
        Node n7 = new Node(1);
        Node n8 = new Node(3);
        Node n9 = new Node(5);
        Node n10 = new Node(7);
        Node n11 = new Node(9);

        n5.left = n11;
        n2.left = n5;
        n2.right = n6;
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n3.left = n7;
        n3.right = n8;
        n4.left = n9;
        n4.right = n10;
        HashMap<Integer, Integer> map = new HashMap<>();
        diagonalOrderDFS(root, map, 0);
        System.out.println(map);
    }

    private static void diagonalOrderDFS(Node root, HashMap<Integer, Integer> map, int l) {
        if (root == null) {
            return;
        }


        diagonalOrderDFS(root.left, map, l - 1);
        diagonalOrderDFS(root.right, map, l);
        map.put(l, map.getOrDefault(l, 0) + root.val);


    }
}
