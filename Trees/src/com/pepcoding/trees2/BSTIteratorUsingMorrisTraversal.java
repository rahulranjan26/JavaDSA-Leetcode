package com.pepcoding.trees2;

public class BSTIteratorUsingMorrisTraversal {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    private static Node curr = null;

    public static void main(String[] args) {
        System.out.println("We will find the BST Iterator with Morris Traversal");
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
        curr = root;
//        System.out.println(curr.val);

        while (hasNext())
            System.out.print(next() + " ");
    }

    private static Node morrisTraversalFind() {
        Node res = null;
        while (curr != null) {
            Node currLeft = curr.left;
            if (currLeft == null) {
                res = curr;
                curr = curr.right;
                break;
            } else {
                Node rightMostNode = RightMostNode(currLeft);
                if (rightMostNode.right == null) {
                    rightMostNode.right = curr;
                    curr = curr.left;
                } else {
                    res = curr;
                    rightMostNode.right = null;
                    curr = curr.right;
                    break;
                }
            }
        }
        return res;
    }

    private static Node RightMostNode(Node node) {
        while (node.right != null && node.right != curr)
            node = node.right;
        return node;
    }

    private static boolean hasNext() {
        return curr != null;
    }

    private static int next() {
        return morrisTraversalFind().val;
    }
}
