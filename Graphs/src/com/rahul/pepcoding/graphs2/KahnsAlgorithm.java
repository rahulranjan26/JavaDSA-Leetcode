package com.rahul.pepcoding.graphs2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class KahnsAlgorithm {
    public static class Node {
        int u;
        int v;

        Node(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    public static void main(String[] args) {
        System.out.println("We will learn about the Kahn Algorithm in the Graphs");
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        int vrtx = 6;
        for (int i = 0; i < vrtx; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Node(0, 2));
        graph.get(0).add(new Node(0, 3));

        graph.get(3).add(new Node(3, 4));
        graph.get(4).add(new Node(4, 5));

        graph.get(1).add(new Node(1, 2));
        graph.get(1).add(new Node(1, 5));
        int[] inDegree = new int[vrtx];
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < vrtx; i++) {
            for (var node : graph.get(i)) {
                inDegree[node.v]++;
            }
        }
//        System.out.println(Arrays.toString(inDegree));

        for (int i = 0; i < vrtx; i++) {
            if (inDegree[i] == 0)
                queue.addLast(i);
        }
        int[] ans = new int[vrtx];
        int idx = 0;
        while (!queue.isEmpty()) {
            int rem = queue.removeFirst();
            ans[idx++] = rem;
            for (var node : graph.get(rem)) {
                inDegree[node.v]--;
                if (inDegree[node.v] == 0)
                    queue.addLast(node.v);
            }
        }
        if (idx == vrtx)
            System.out.println(Arrays.toString(ans) + " " + idx);
        else
            System.out.println("Not Possible");

    }
}
