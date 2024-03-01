package com.pepcoding.trees2;

public class LCAOfBinaryTree {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        System.out.println("lca  Of Tree");
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
        Node ans = lcaOfBTree(root,2,12);
        System.out.println(ans.val);
    }

    private static Node lcaOfBTree(Node root, int a, int b) {
        if (root == null)
            return null;
        if (root.val == a || root.val == b)
            return root;
        Node left = lcaOfBTree(root.left, a, b);
        Node right = lcaOfBTree(root.right, a, b);

        if (left != null && right != null)
            return root;
        else
            if (left == null)
                return right;
            else
                return left;
    }
}