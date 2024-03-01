package com.pepcoding.trees2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.LinkedTransferQueue;

public class DiagonalLevelTraversal {
    static public class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        System.out.println("Traverse Diagonally");
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
        int hi = 18;
        int lo = 3;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(root);

        while (que.size() != 0) {
            ArrayList<Integer> temp = new ArrayList<>();
            int len = que.size();
            while (len-- > 0) {
                Node node = que.removeFirst();
                while (node != null) {
                    temp.add(node.val);
                    if (node.left != null)
                        que.addLast(node.left);
                    node = node.right;
                }
//                len--;
            }
            ans.add(temp);
        }
        System.out.println(ans);
    }
}
