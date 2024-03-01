package com.pepcoding.trees2;

public class SerializeAndDeserialize {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    static int idx = 0;

    public static void main(String[] args) {
        System.out.println("We will construct a tree from serialized form");
        Integer[] arr = {8, 3, 1, null, null, 6, 4, null, null, 7, null, null, 10, null, 14, 13, null, null, null};

        Node root = createTreeFromSerialzed(arr);
        inorder(root);
    }

    private static Node createTreeFromSerialzed(Integer[] arr) {
        if (idx >= arr.length || arr[idx]==null) {
            idx++;
            return null;
        }
        Node node = new Node(arr[idx++]);
        node.left = createTreeFromSerialzed(arr);
        node.right = createTreeFromSerialzed(arr);
        return node;

    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        inorder(root.left);
        inorder(root.right);
    }
}
