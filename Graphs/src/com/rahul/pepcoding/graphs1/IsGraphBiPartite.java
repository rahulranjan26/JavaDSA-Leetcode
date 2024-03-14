package com.rahul.pepcoding.graphs1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class IsGraphBiPartite {
    private static class Node {
        int src;
        int dest;
        int wt;

        public Node(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    private static class Pair {
        int v;
        int rad;

        Pair(int v, int rad) {
            this.v = v;
            this.rad = rad;
        }
    }

    public static void main(String[] args) {
        System.out.println("We will learn about bfs on graph");
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Node(0, 1, 5));
        graph.get(1).add(new Node(1, 0, 5));

        graph.get(0).add(new Node(0, 3, 5));
        graph.get(3).add(new Node(3, 0, 5));

        graph.get(1).add(new Node(1, 2, 5));
        graph.get(2).add(new Node(2, 1, 5));

        graph.get(3).add(new Node(3, 2, 5));
        graph.get(2).add(new Node(2, 3, 5));

        graph.get(3).add(new Node(3, 4, 5));
        graph.get(4).add(new Node(4, 3, 5));

        graph.get(2).add(new Node(2, 5, 5));
        graph.get(5).add(new Node(5, 2, 5));

        graph.get(4).add(new Node(4, 5, 5));
        graph.get(5).add(new Node(5, 4, 5));

        graph.get(4).add(new Node(4, 6, 5));
        graph.get(6).add(new Node(6, 4, 5));

        graph.get(5).add(new Node(5, 6, 5));
        graph.get(6).add(new Node(6, 5, 5));
        int[] radius = new int[7];
        Arrays.fill(radius, -1);
        for (int i = 0; i < 7; i++) {
            if (radius[i] != -1) {
                boolean isBipartite = checkBipartite(graph, i, radius);
                if (!isBipartite)
                    System.out.println(false);
                break;
            }
        }
        System.out.println(true);
    }

    private static boolean checkBipartite(ArrayList<ArrayList<Node>> graph, int src, int[] radius) {
        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(src, 0));

        while (!queue.isEmpty()) {
            Pair temp = queue.removeFirst();
            if (radius[temp.v] != -1) {
                if (radius[temp.v] != temp.rad)
                    return false;
            }
            radius[temp.v] = temp.rad;
            for (var node : graph.get(src)) {
                if (radius[node.dest] == -1) {
                    Pair newPair = new Pair(node.dest, temp.rad + 1);
                    queue.addLast(newPair);
                }
            }
        }
        return true;
    }
}
