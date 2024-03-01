package com.pepcoding.trees2;

public class BinaryTreeFromPreAndPostOrder {
    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        System.out.println("Tree from inorder and postorder");
        int[] pre = {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};
        int[] post = {1, 3, 2, 5, 7, 6, 4, 9, 11, 10, 13, 15, 14, 12, 8};
        Node root = buildTreeFromPreAndPostOrder(pre, 0, pre.length - 1, post, 0, post.length - 1);
        inorder(root);
    }

    private static Node buildTreeFromPreAndPostOrder(int[] pre, int preStart, int preStop, int[] post, int postStart, int postEnd) {
        if (preStart > preStop) {
            return null;
        }
        int val = pre[preStart];
        Node node = new Node(val);
        if (preStart == preStop)
            return node;
        int val2 = pre[preStart + 1];

        int idx = postStart;
        for (int i = postStart; i <= postEnd; i++) {
            if (post[i] == val2) {
                idx = i;
                break;
            }
        }
        int te = idx - postStart + 1;
        node.left = buildTreeFromPreAndPostOrder(pre, preStart + 1, preStart + te, post, postStart, idx);
        node.right = buildTreeFromPreAndPostOrder(pre, preStart + te + 1, preStop, post, idx + 1, postEnd - 1);
        return node;
    }

    private static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}

