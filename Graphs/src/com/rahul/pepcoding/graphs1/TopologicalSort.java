package com.rahul.pepcoding.graphs1;

import java.util.ArrayList;

public class TopologicalSort {
    private static class Node {
        int src;
        int dest;
//        int wt;

        public Node(int src, int dest) {
            this.src = src;
            this.dest = dest;
//            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        System.out.println("Lets learn about topological sort");
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Node(0, 3));
        graph.get(0).add(new Node(0, 1));
        graph.get(1).add(new Node(1, 2));
        graph.get(2).add(new Node(2, 3));
        graph.get(4).add(new Node(4, 3));
        graph.get(4).add(new Node(4, 5));
        graph.get(4).add(new Node(4, 6));
        graph.get(5).add(new Node(5, 6));
        boolean[] visited = new boolean[7];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            if (!visited[i]) {
                findTopSort(graph, i, visited, ans);
            }

        }
        System.out.println(ans);
    }

    private static void findTopSort(ArrayList<ArrayList<Node>> graph, int src, boolean[] visited, ArrayList<Integer> ans) {
        visited[src] = true;
        for (var node : graph.get(src)) {
            if (!visited[node.dest]) {
                findTopSort(graph, node.dest, visited, ans);
            }
        }
        ans.add(src);
    }
}
