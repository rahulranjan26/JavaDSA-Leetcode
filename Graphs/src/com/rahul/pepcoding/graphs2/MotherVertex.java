package com.rahul.pepcoding.graphs2;

import java.util.ArrayList;
import java.util.LinkedList;

public class MotherVertex {
    public static void main(String[] args) {
        System.out.println("Lets find out the mother vertex ==> Vertex from which we can visit every other vertex." +
                "A graph can have multiple mother vertexes");
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 1; i <=9; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(7).add(8);
        graph.get(7).add(1);
        graph.get(7).add(3);
        graph.get(7).add(5);
        graph.get(7).add(6);
        graph.get(5).add(6);
        graph.get(1).add(2);
        graph.get(2).add(3);
        graph.get(3).add(4);
        LinkedList<Integer> stack = new LinkedList<>();
        System.out.println(graph);
        boolean[] vis = new boolean[9];
        for (int i = 1; i < 9; i++) {
            if (!vis[i])
                dfs(graph, stack, i, vis);
        }
        System.out.println(stack);
        int mv = stack.removeFirst();
        boolean[] vis2 = new boolean[9];
        dfs2(graph, vis2, mv);
        if (count == 8)
            System.out.println(mv);
        else
            System.out.println("You don't have a MV");
    }

    private static void dfs2(ArrayList<ArrayList<Integer>> graph, boolean[] vis2, int mv) {
        vis2[mv] = true;
        count++;
        for (var nbr : graph.get(mv))
            if (!vis2[nbr])
                dfs2(graph, vis2, nbr);
    }

    static int count = 0;

    private static void dfs(ArrayList<ArrayList<Integer>> graph, LinkedList<Integer> stack, int src, boolean[] vis) {
        vis[src] = true;
        for (var nbr : graph.get(src)) {
            if (!vis[nbr])
                dfs(graph, stack, nbr, vis);
        }
        stack.addFirst(src);

    }
}
