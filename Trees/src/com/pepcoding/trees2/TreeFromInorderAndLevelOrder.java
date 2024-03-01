package com.pepcoding.trees2;


import java.util.HashSet;

public class TreeFromInorderAndLevelOrder {
    private static class Node {
        int val;

        Node left;

        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        System.out.println("We will make binary tree using Inorder and Level Order");
        int[] inorder = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[] levelOrder = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};

        Node root = buildTreeFromLevelOrderAndInorder(inorder, levelOrder, 0, inorder.length - 1);
        inorderTra(root);

    }

    private static void inorderTra(Node root) {
        if (root == null) {
            return;
        }
        inorderTra(root.left);
        System.out.print(root.val + " ");
        inorderTra(root.right);
    }

    private static Node buildTreeFromLevelOrderAndInorder(int[] inorder, int[] levelOrder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        Node node = new Node(levelOrder[0]);
        int idx = inStart;
        HashSet<Integer> set = new HashSet<>();
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == levelOrder[0]) {
                idx = i;
                break;
            } else {
                set.add(inorder[i]);
            }
        }
        int[] leftLevel = new int[idx - inStart];
        int[] rightLevel = new int[inEnd - idx];
        int ls = 0, rs = 0;
        for (int i = 1; i < levelOrder.length; i++) {
            if (!set.isEmpty() && set.contains(levelOrder[i])) {
                leftLevel[ls++] = levelOrder[i];
                set.remove(levelOrder[i]);
            } else {
                rightLevel[rs++] = levelOrder[i];
            }
        }
        node.left = buildTreeFromLevelOrderAndInorder(inorder, leftLevel, inStart, idx - 1);
        node.right = buildTreeFromLevelOrderAndInorder(inorder, rightLevel, idx + 1, inEnd);
        return node;
    }
}
