package com.rahul.pepcoding.graphs1;

import java.util.ArrayList;
import java.util.LinkedList;

public class BreadthFirstSearch {
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

        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(0, 1));
        boolean[] visited = new boolean[7];


        while (!queue.isEmpty()) {
            Pair tempNode = queue.removeFirst();
            if (visited[tempNode.v])
                continue;
            visited[tempNode.v] = true;
            System.out.println(tempNode.v + "->" + tempNode.rad);
            for (var node : graph.get(tempNode.v)) {
                if (!visited[node.dest]) {
                    Pair newPair = new Pair(node.dest, tempNode.rad + 1);
                    queue.addLast(newPair);
                }
            }
        }


    }
}
