package com.pepcoding.trees1;

public class IsTreeBST {

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

    public static class BSTPair {
        boolean isBST;
        int min;
        int max;

    }

    public static BSTPair isBSTT(Node node) {
        if (node == null) {
            BSTPair p = new BSTPair();
            p.isBST = true;
            p.min = Integer.MAX_VALUE;
            p.max = Integer.MIN_VALUE;
            return p;
        }

        BSTPair left = isBSTT(node.left);
        BSTPair right = isBSTT(node.right);
        BSTPair mp = new BSTPair();
        mp.isBST = left.isBST && right.isBST && (node.val >= left.max && node.val <= right.min);
        mp.min = Math.min(node.val, Math.min(left.min, right.min));
        mp.max = Math.max(node.val, Math.max(left.max, right.max));
        return mp;
    }

    public static void main(String[] args) {
        System.out.println("Is BST Check");
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
        int hi = 18;
        int lo = 3;
        System.out.println(isBSTT(root).isBST);
    }

}
