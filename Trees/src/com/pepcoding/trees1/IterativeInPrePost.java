package com.pepcoding.trees1;

import java.util.Stack;

public class IterativeInPrePost {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void main(String[] args) {
        System.out.println("Iterative In Pre Post");
        System.out.println("Level order traversal");
        Node root = new Node(8, null, null);
        Node n1 = new Node(4, null, null);
        Node n2 = new Node(11, null, null);
        Node n3 = new Node(2, null, null);
        Node n4 = new Node(6, null, null);
        Node n5 = new Node(10, null, null);
        Node n6 = new Node(12, null, null);
        Node n7 = new Node(1, null, null);
        Node n8 = new Node(3, null, null);
        Node n9 = new Node(5, null, null);
        Node n10 = new Node(7, null, null);
        Node n11 = new Node(9, null, null);

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

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        String pre = "";
        String inorder = "";
        String post = "";
        while (!st.isEmpty()) {

            Pair top = st.peek();

            if (top.state == 1) {
                pre += top.node.val + " ";
                top.state++;

                if (top.node.left != null) {
                    Pair p = new Pair(top.node.left, 1);
                    st.push(p);
                }
            } else if (top.state == 2) {
                inorder += top.node.val + " ";
                top.state++;

                if (top.node.right != null) {
                    Pair p = new Pair(top.node.right, 1);
                    st.push(p);
                }
            } else {
                post += top.node.val + " ";
                st.pop();
            }

        }
        System.out.println(pre);
        System.out.println(inorder);
        System.out.println(post);

    }
}
