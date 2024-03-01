package com.pepcoding.trees2;

public class BSTFromInorderTraversal {
    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        System.out.println("Make  Binary search tree from Inorder");
        int[] inorder = {5, 8, 9, 11, 13, 14, 18, 19, 22, 24, 28};

        Node root = buildBSTFromInorder(inorder, 0, inorder.length - 1);
        inorder(root);

    }

    private static Node buildBSTFromInorder(int[] inorder, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        Node root = new Node(inorder[mid]);
        root.left = buildBSTFromInorder(inorder, start, mid - 1);
        root.right = buildBSTFromInorder(inorder, mid + 1, end);
        return root;
    }

    private static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}
