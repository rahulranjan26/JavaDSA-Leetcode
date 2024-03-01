package com.pepcoding.trees2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BottomViewOfBinaryTree {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static class Pair {
        Node node;
        int hl;

        public Pair(Node node, int hl) {
            this.node = node;
            this.hl = hl;
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
        que.addLast(new Pair(root, 0));
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (que.size() != 0) {
            int size = que.size();

            while (size > 0) {
                Pair p = que.removeFirst();
                int level = p.hl;
                Node node = p.node;
                min = Math.min(min, level);
                max = Math.max(max, level);
                map.put(level, node.val);
                if (node.left != null) {
                    Pair pl = new Pair(node.left, level - 1);
                    que.addLast(pl);
                }
                if (node.right != null) {
                    Pair pr = new Pair(node.right, level + 1);
                    que.addLast(pr);
                }
                size--;
            }
        }
        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }
        System.out.println(ans);

    }
}
