package com.rahul.pepcoding.graphs2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class KosarajuAlgorithm {
    public static void main(String[] args) {
        System.out.println("We will learn about the Kosaraju algorithm to find the strongly connected " +
                "components in directed graph");
        int vtx = 13;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vtx; i++) {
            graph.add(new ArrayList<>());
        }
        Scanner scn = new Scanner(System.in);
        int edges = scn.nextInt();
        for (int i = 0; i < edges; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();
            graph.get(u).add(v);
        }
        LinkedList<Integer> stack = new LinkedList<>();
        boolean[] vis = new boolean[vtx];
        for (int i = 0; i < vtx; i++) {
            if (!vis[i]) {
                dfs1(graph, vis, stack, i);
            }
        }
//        System.out.println(stack);
        ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();
        for (int i = 0; i < vtx; i++) {
            graph2.add(new ArrayList<>());
        }
        for (int i = 0; i < vtx; i++) {
            for (var nbr : graph.get(i)) {
                graph2.get(nbr).add(i);
            }
        }
//        System.out.println(graph + "   " + graph2);
        int ans = 0;
        boolean[] vis2 = new boolean[vtx];

        while (!stack.isEmpty()) {
            int rem = stack.removeFirst();
            if (!vis2[rem]) {
                dfs2(graph2, vis2, rem);
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static void dfs2(ArrayList<ArrayList<Integer>> graph2, boolean[] vis2, int rem) {
        vis2[rem] = true;
        for (var nbr : graph2.get(rem)) {
            if (!vis2[nbr]) {
                dfs2(graph2, vis2, nbr);
            }
        }
    }

    private static void dfs1(ArrayList<ArrayList<Integer>> graph, boolean[] vis, LinkedList<Integer> stack, int src) {
        vis[src] = true;
        for (var nbr : graph.get(src)) {
            if (!vis[nbr])
                dfs1(graph, vis, stack, nbr);
        }
        stack.addLast(src);
    }
}
