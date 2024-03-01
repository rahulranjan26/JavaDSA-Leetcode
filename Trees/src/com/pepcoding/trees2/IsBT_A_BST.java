package com.pepcoding.trees2;

public class IsBT_A_BST {
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
        System.out.println("We will work on house robbing problem on bt");
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
//        int hi = 18;
//        int lo = 3;
        System.out.println(isValidBST_1(root));
//        System.out.println(isValidBST_2(root));
        inorder(root);
    }

    private static boolean isValidBST_2(Node node) {
        return false;
    }

    public static void inorder(Node node) {
        if (node == null) return;


        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }

    public static Node prev = null;

    private static boolean isValidBST_1(Node node) {
        if (node == null) return true;
        boolean left = isValidBST_1(node.left);
        boolean temp = true;
        if (prev == null) {
            prev = node;
        } else {
            temp = prev.val < node.val;
            prev = node;
        }

        boolean right = isValidBST_1(node.right);
        return left && right && temp;

    }
}
