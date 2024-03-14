package com.rahul.pepcoding.graphs1;

import java.util.ArrayList;

// class Graph {
//    private static class Node {
//        int src;
//        int dest;
//        int wt;
//
//        public Node(int src, int dest, int wt) {
//            this.src = src;
//            this.dest = dest;
//            this.wt = wt;
//        }
//    }
//
//
//    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
//    int vtx;
//
//    Graph(int vtx) {
//        this.vtx = vtx;
////        graph = new ArrayList[]{new ArrayList<>()};
//        for (int i = 0; i < this.vtx; i++) {
//            graph.add(new ArrayList<>());
//        }
//    }
//
//
//    public void addEdge(int src, int dest, int wt) {
//        graph.get(src).add(new Node(src, dest, wt));
//        graph.get(dest).add(new Node(src, dest, wt));
//    }
//
//    public void printGraph() {
//        for (var nodes : graph) {
//            for (var node : nodes) {
//                System.out.print(node.src + "-->" + node.dest + "-->" + node.wt + " | ");
//            }
//            System.out.println();
//        }
//    }
//
//    public ArrayList<Node> getNodes(int vtx) {
//        return graph.get(vtx);
//    }
//}

