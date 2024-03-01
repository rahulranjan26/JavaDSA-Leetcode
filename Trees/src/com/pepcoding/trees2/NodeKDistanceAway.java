package com.pepcoding.trees2;


import java.util.ArrayList;
import java.util.*;

public class NodeKDistanceAway {
    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }


    private static class MakeTree {
//        private static Node root = null;


        private static Node getRoot() {
            Integer[] nodes = {1, 3, 5, 7, null, null, null, 9, 29, 31, 35, null, null, 37, null, null, 39, 41,
                    null, null, null, 11, 13, 15, 17, null, null, 19, 21, null, null, null, 23, null, null, null, 25, 27, null, null, null};
            Node root = Deserialize(nodes);
            preorder(root);
            System.out.println();
            return root;
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

    public static void main(String[] args) {
        System.out.println("Traverse Diagonally");
//        MakeTree mt = new MakeTree();
//        System.out.println(MakeTree.getRoot().val);
        Node root = MakeTree.getRoot();
        ArrayList<Node> path = new ArrayList<>();
        nodeToRootPath(root, 29, path);
        for (var v : path)
            System.out.print(v.val + " ");
        System.out.println();

        int K = 2;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < path.size(); i++) {
            KDistantElements(path.get(i), ans, K - i, i == 0 ? null : path.get(i - 1));
        }


//        KDistantElements(path.get(1), ans, 2, path.get(0));
        System.out.println(ans);
    }

    private static boolean nodeToRootPath(Node root, int target, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }

        if (root.val == target) {
            path.add(root);
            return true;
        }
        if (nodeToRootPath(root.left, target, path) || nodeToRootPath(root.right, target, path)) {
            path.add(root);
            return true;
        }
        return false;

    }

    private static void KDistantElements(Node root, ArrayList<Integer> ans, int K, Node blockNode) {
        if (root == null || root == blockNode || K < 0)
            return;
        if (K == 0) {
            ans.add(root.val);
            return;
        }
        KDistantElements(root.left, ans, K - 1, blockNode);
        KDistantElements(root.right, ans, K - 1, blockNode);
    }


}