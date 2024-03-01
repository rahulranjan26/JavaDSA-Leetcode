package com.pepcoding.trees2;

import java.util.ArrayList;

public class BurnTrees {
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
//            preorder(root);
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

    private static int time = 0;

    public static void main(String[] args) {
        System.out.println("We will burn the tree and know the max time it took to burn it");

        ArrayList<Node> path = new ArrayList<>();
        nodeToRootPath(MakeTree.getRoot(), 1, path);
        for (int i = 0; i < path.size(); i++) {
            int temp = findtTheDepth(path.get(i), i == 0 ? null : path.get(i - 1));
            time = Math.max(time, temp + i);
            System.out.print(temp + " ");
        }
        System.out.println();
        System.out.println(time);


    }

    private static boolean nodeToRootPath(Node root, int target, ArrayList<Node> path) {
        if (root == null)
            return false;

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

    private static int findtTheDepth(Node root, Node blocknode) {
        if (root == null || root == blocknode)
            return -1;
        return Math.max(findtTheDepth(root.left, blocknode), findtTheDepth(root.right, blocknode)) + 1;
    }
}
