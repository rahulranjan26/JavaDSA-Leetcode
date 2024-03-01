package com.pepcoding.trees2;

public class BSTFromInorder {
    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        System.out.println("Build BST from PreOrder");
        int[] pre = {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};
        int lr = -(int) 1e9 - 1;
        int rr = (int) 1e9 + 1;
        Node root = buildBSTFromPreorder(pre, lr, rr);
        inorder(root);
    }

    static int idx = 0;

    private static Node buildBSTFromPreorder(int[] pre, int lr, int rr) {
        if (idx >= pre.length || pre[idx] < lr || pre[idx] > rr)
            return null;
        Node root = new Node(pre[idx++]);
        root.left = buildBSTFromPreorder(pre, lr, root.val);
        root.right = buildBSTFromPreorder(pre, root.val, rr);
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
