package com.pepcoding.trees2;

import java.util.ArrayList;

public class RootToLeafPathSum {

    static public class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    ;

    public static void main(String[] args) {
        System.out.println();
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
        int target = 15;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        isLeafToRootSumPathPresent(root, target, new ArrayList<Integer>(), ans);
        System.out.println(ans);
    }

    private static void isLeafToRootSumPathPresent(Node root, int target, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> ans) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if ((target - root.val) == 0) {
                ArrayList<Integer> base = new ArrayList<>(temp);
                base.add(root.val);
                ans.add(base);

            }
            return;
        }
        temp.add(root.val);
        isLeafToRootSumPathPresent(root.left, target - root.val, temp, ans);
        isLeafToRootSumPathPresent(root.right, target - root.val, temp, ans);
        temp.remove(temp.size() - 1);

    }
}