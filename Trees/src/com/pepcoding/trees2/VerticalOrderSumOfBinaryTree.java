package com.pepcoding.trees2;

import java.util.HashMap;
import java.util.LinkedList;

public class VerticalOrderSumOfBinaryTree {

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static class Pair {
        int hl;
        Node node;

        public Pair(int hl, Node node) {
            this.hl = hl;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        System.out.println("Left view Of Tree");
        Node root = new Node(8);
        Node n1 = new Node(4);
        Node n2 = new Node(11);
        Node n3 = new Node(2);
        Node n4 = new Node(6);
        Node n5 = new Node(10);
        Node n6 = new Node(12);
        Node n7 = new Node(1);
        Node n8 = new Node(3);
        Node n9 = new Node(5);
        Node n10 = new Node(7);
        Node n11 = new Node(9);

        n5.left = n11;
        n2.left = n5;
        n2.right = n6;
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n3.left = n7;
        n3.right = n8;
        n4.left = n9;
        n4.right = n10;

        LinkedList<Pair> que = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        que.addFirst(new Pair(0, root));

        while (que.size() != 0) {
            Pair pp = que.removeFirst();
            int cl = pp.hl;
            Node node = pp.node;
            map.put(cl, map.getOrDefault(cl, 0) + node.val);
            if (node.left != null) {
                Pair pl = new Pair(cl - 1, node.left);
                que.addLast(pl);
            }
            if (node.right != null) {
                Pair rl = new Pair(cl + 1, node.right);
                que.addLast(rl);
            }
        }
        System.out.println(map);

    }
}
