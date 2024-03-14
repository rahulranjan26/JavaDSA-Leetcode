package com.rahul.pepcoding.graphs1;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
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

    private static class Pair implements Comparable<Pair> {
        int v;

        int wt;

        Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;

        }

        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
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

        graph.get(0).add(new Node(0, 3, 8));
        graph.get(3).add(new Node(3, 0, 8));

        graph.get(1).add(new Node(1, 2, 3));
        graph.get(2).add(new Node(2, 1, 3));

        graph.get(3).add(new Node(3, 2, 1));
        graph.get(2).add(new Node(2, 3, 1));

        graph.get(3).add(new Node(3, 4, 7));
        graph.get(4).add(new Node(4, 3, 7));

//        graph.get(2).add(new Node(2, 5, 5));
//        graph.get(5).add(new Node(5, 2, 5));

        graph.get(4).add(new Node(4, 5, 8));
        graph.get(5).add(new Node(5, 4, 8));

        graph.get(4).add(new Node(4, 6, 12));
        graph.get(6).add(new Node(6, 4, 12));

        graph.get(5).add(new Node(5, 6, 9));
        graph.get(6).add(new Node(6, 5, 9));
        boolean[] visited = new boolean[7];
        String path = "";

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(0, 0));
        int ans = 0;
        int desc = 4;

        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            int v = temp.v;
            int wt = temp.wt;
            if (visited[v])
                continue;
            ans += wt;
            visited[v] = true;
            for (var node : graph.get(v)) {
                if (!visited[node.dest]) {

                    Pair p = new Pair(node.dest, node.wt);
                    pq.offer(p);
                }
            }


        }
        System.out.println(ans);

    }
}
