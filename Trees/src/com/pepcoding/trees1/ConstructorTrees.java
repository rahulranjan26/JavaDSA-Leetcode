package com.pepcoding.trees1;

import java.util.Stack;

public class ConstructorTrees {
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
        System.out.println("Here we will work on making a constructor to make tree from given inorder travel");
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);
        Stack<Pair> stack = new Stack<>();
        stack.push(rtp);
        int idx = 0;
        while (!stack.isEmpty()) {
            Pair top = stack.peek();

            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    Integer val = arr[idx];
                    top.node.left = new Node(arr[idx], null, null);

                    stack.push(new Pair(top.node.left, 1));
                } else {
                    top.node.left = null;
                }
                top.state++;

            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {

                    top.node.right = new Node(arr[idx], null, null);

                    stack.push(new Pair(top.node.right, 1));
                } else {
                    top.node.right = null;
                }
                top.state++;

            } else {
                stack.pop();
            }
        }
        display(root);
    }

    public static void display(Node node) {
        if (node == null)
            return;
//        StringBuilder str = new StringBuilder();
        String str = "";
        str += node.left == null ? "." : node.left.val + " ";
        str += "<--" + node.val + "-->";
        str += node.right == null ? "." : node.right.val + " ";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

}
