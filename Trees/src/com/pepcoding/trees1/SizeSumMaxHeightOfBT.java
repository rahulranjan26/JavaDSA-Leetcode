package com.pepcoding.trees1;

public class SizeSumMaxHeightOfBT {
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

    public static void main(String[] args) {
        System.out.println("We will find the size,sum,max and height of binary tree in this problem");

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
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n3.left = n7;
        n3.right = n8;
        n4.left = n9;
        n4.right = n10;
//        inorder(root);

        System.out.println(Size(root));
        System.out.println(Sum(root));
        System.out.println(Max(root));
        System.out.println(height(root));
    }


    public static void inorder(Node node) {
        if (node == null)
            return;

        inorder(node.left);
        System.out.println(node.val);
        inorder(node.right);
    }

    public static void preorder(Node node) {
        if (node == null)
            return;
        System.out.println(node.val);
        preorder(node.left);
        preorder(node.right);
    }

    public static void postorder(Node node) {
        if (node == null)
            return;

        postorder(node.left);
        postorder(node.right);
        System.out.println(node.val);
    }

    public static int Size(Node node) {
        if (node == null) {
            return 0;
        }
        return Size(node.left) + Size(node.right) + 1;
    }

    public static int Sum(Node node) {
        if (node == null) {
            return 0;
        }

        return Sum(node.left) + Sum(node.right) + node.val;
    }

    public static int Max(Node node) {
        if (node == null) {
            return 0;

        }
        int left = Max(node.left);
        int right = Max(node.right);
        int temp = Math.max(left, right);
        return Math.max(temp, node.val);
    }

    public static int height(Node node) {
        if (node == null) {
            return 0;
        }

        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
