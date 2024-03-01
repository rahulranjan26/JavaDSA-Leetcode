package com.pepcoding.trees2;

import com.pepcoding.trees1.DiameterOfTree;
import com.pepcoding.trees1.NodeToRootPath;

public class MorrisInorderTraversal {
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
        System.out.println("We will learn about Morris Inorder traversal");

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
        morrisInorder(root);

    }

    public static void morrisInorder(Node node) {

        Node curr = node;
        while (curr != null) {
            Node currLeft = curr.left;
            if (currLeft == null) {
                System.out.print(curr.val + " ");
                curr = curr.right;
            } else {
                Node rightMost = findRightMostNode(currLeft, curr);
                if (rightMost.right == null) {
                    rightMost.right = curr;
//                    For Pre order give print statement here
//                    System.out.print(curr.val + " ");
                    curr = curr.left;

                } else {
                    rightMost.right = null;
//                    For inorder give statement pf print here
//                    System.out.print(curr.val + " ");
                    curr = curr.right;
                }
            }
        }


    }

    private static Node findRightMostNode(Node node, Node curr) {
        while (node.right != null && node.right != curr){
            node = node.right;
        }
        return node;
    }
}
