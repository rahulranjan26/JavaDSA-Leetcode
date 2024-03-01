package com.pepcoding.trees2;

public class TreeFromInOrderAndPostOrder {
    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        System.out.println("We will make tree using Inorder and Postorder");
        int[] postorder = {1, 3, 2, 5, 7, 6, 4, 9, 11, 10, 13, 15, 14, 12, 8};
        int[] inorder = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int n = postorder.length - 1;
        Node root = buildTreeFromPostOrderAndInOrder(postorder, inorder, 0, n, 0, n);
        inorderTT(root);
    }

    private static Node buildTreeFromPostOrderAndInOrder(int[] postorder, int[] inorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int val = postorder[postEnd];
        Node node = new Node(val);
        int idx = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == val) {
                idx = i;
                break;
            }
        }
        int te = idx - inStart;
        node.left = buildTreeFromPostOrderAndInOrder(postorder, inorder, inStart, idx - 1, postStart, postStart + te - 1);
        node.right = buildTreeFromPostOrderAndInOrder(postorder, inorder, idx + 1, inEnd, postStart + te, postEnd - 1);
        return node;
    }

    private static void inorderTT(Node node) {
        if (node == null) {
            return;
        }
        inorderTT(node.left);
        System.out.print(node.val + " ");
        inorderTT(node.right);
    }
}
