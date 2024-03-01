package com.pepcoding.trees2;

public class LongestZigZagPathInBT {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        int leftPath = -1;
        int rightPath = -1;
        int maxPath = -1;
    }

    public static void main(String[] args) {
        System.out.println("We will earn about longest zigzag path in binary tree");
        Node root = new Node(8, null, null);
        Node n1 = new Node(4, null, null);
        Node n2 = new Node(11, null, null);
        Node n3 = new Node(2, null, null);
        Node n4 = new Node(6, null, null);
        Node n5 = new Node(10, null, null);
        Node n6 = new Node(12, null, null);
        Node n7 = new Node(1, null, null);
        Node n8 = new Node(3, null, null);
        Node n9 = new Node(5, null, null);
        Node n10 = new Node(7, null, null);
        Node n11 = new Node(9, null, null);

        n5.left = n11;
        n2.left = n5;
        n2.right = n6;
        root.left = n1;
//        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n3.left = n7;
        n3.right = n8;
        n4.left = n9;
        n4.right = n10;
//        n11.right = n2;
        n10.right = n2;
        int hi = 18;
        int lo = 3;


        Pair ans = findZigZagPath(root);
        System.out.println(ans.maxPath);
    }

    private static Pair findZigZagPath(Node node) {
        if (node == null) {
            return new Pair();
        }
        Pair left = findZigZagPath(node.left);
        Pair right = findZigZagPath(node.right);
        Pair myAns = new Pair();
        myAns.leftPath = left.rightPath + 1;
        myAns.rightPath = right.leftPath + 1;
        myAns.maxPath = Math.max(Math.max(myAns.leftPath, myAns.rightPath), Math.max(left.maxPath, right.maxPath) + 1);
        return myAns;
    }
}
