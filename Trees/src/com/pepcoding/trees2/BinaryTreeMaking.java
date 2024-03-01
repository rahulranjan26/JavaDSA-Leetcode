package com.pepcoding.trees2;

import java.util.ArrayList;


public class BinaryTreeMaking {
    protected static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }



    public BinaryTreeMaking() {
        System.out.println("We will make randomly generated binary tree with n nodes");
        Integer[] nodes = {7, 8, 3, 7, null, null, 2, null, 9, 6, 1, 8, null, null, 14, 16, null, null, null, 4, null, null, null, 9, 4, null, null, null};
        Node root = Deserialize(nodes);
//        preorder(root);
    }



    private static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    private static int count = 0;

    private static Node Deserialize(Integer[] nodes) {
        if (count >= nodes.length || nodes[count] == null) {
            count++;
            return null;
        }
        Node node = new Node(nodes[count++]);
        node.left = Deserialize(nodes);
        node.right = Deserialize(nodes);
        return node;

    }
}
