package com.pepcoding.trees2;

public class TreeFromInOrderAndPreOrder {
    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;

        }
    }

    public static void main(String[] args) {
        System.out.println("We will make tree from preorder and inorder traversal of a tree");
        int[] preorder = {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};
        int[] inorder = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        int n = preorder.length - 1;
        Node root = buildBinaryTreeFromInorderAndPostOrder(preorder, 0, n - 1, inorder, 0, n - 1);
        inorderT(root);
    }

    private static Node buildBinaryTreeFromInorderAndPostOrder(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if (isi > iei) {
            return null;
        }

        int val = preorder[psi];
        Node node = new Node(val);
        int idx = 0;
        for (int i = isi; i <= iei; i++) {
            if (inorder[i] == val) {
                idx = i;
                break;
            }
        }

        node.left = buildBinaryTreeFromInorderAndPostOrder(preorder, psi + 1, psi + idx - isi, inorder, isi, idx - 1);
        node.right = buildBinaryTreeFromInorderAndPostOrder(preorder, psi + idx - isi + 1, pei, inorder, idx + 1, iei);

        return node;

    }

    private static void inorderT(Node node) {
        if (node == null) {
            return;
        }
        inorderT(node.left);
        System.out.print(node.val + " ");
        inorderT(node.right);
    }

}
