package com.pepcoding.trees2;


public class BSTFromPostorder {
    public static class Node {
        int val;
        Node left;

        Node right;

        Node(int val) {
            this.val = val;
        }

    }

    static int idx = 0;

    public static void main(String[] args) {
        System.out.println("We will make a tree using the Postorder traversal");
        int[] postorder = {1, 3, 2, 5, 7, 6, 4, 9, 11, 10, 13, 15, 14, 12, 8};
        idx = postorder.length - 1;
        int lr = -(int) 1e9 - 1;
        int rr = (int) 1e9 + 1;
        Node root = buildBSTFromPostOrder(postorder, lr, rr);
        inorder(root);
    }

    private static Node buildBSTFromPostOrder(int[] postorder, int lr, int rr) {
        if (idx < 0 || postorder[idx] < lr || postorder[idx] > rr) {
            return null;
        }
        Node node = new Node(postorder[idx--]);
        node.right = buildBSTFromPostOrder(postorder,   node.val, rr);
        node.left = buildBSTFromPostOrder(postorder,  lr, node.val);
        return node;
    }

    private static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}
