package com.rahul.pepcoding.graphs1;

//import com.rahul.pepcoding.graphs1.Graph;

//import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashSet;

public class hasPathInGraph {
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

    public static class Graph {


        private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        int vtx;

        Graph(int vtx) {
            this.vtx = vtx;
//        graph = new ArrayList[]{new ArrayList<>()};
            for (int i = 0; i < this.vtx; i++) {
                graph.add(new ArrayList<>());
            }
        }


        public void addEdge(int src, int dest, int wt) {
            graph.get(src).add(new Node(src, dest, wt));
            graph.get(dest).add(new Node(src, dest, wt));
        }

        public void printGraph() {
            for (var nodes : graph) {
                for (var node : nodes) {
                    System.out.print(node.src + "-->" + node.dest + "-->" + node.wt + " | ");
                }
                System.out.println();
            }
        }

        public ArrayList<Node> getNodes(int vtx) {
            return graph.get(vtx);
        }
    }

    public static void main(String[] args) {
        System.out.println("We will work on finding a path if it exists or not between two vertex of a graph");
//        Graph graph = new Graph(8);
//        graph.addEdge(0, 3, 8);
//        graph.addEdge(0, 1, 5);
//        graph.addEdge(1, 2, 3);
//        graph.addEdge(2, 3, 1);
//        graph.addEdge(3, 4, 7);
//        graph.addEdge(4, 5, 8);
//        graph.addEdge(5, 6, 9);
//        graph.addEdge(4, 6, 12);
//        graph.addEdge(2, 5, 2);
//        boolean[] visited = new boolean[7];

//        System.out.println(hasPath(graph, visited, 0, 6));
//        printPath(graph, visited, 0, 6, "");
//        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
//        for (int i = 0; i < 7; i++) {
//            if (!visited[i]) {
//                ArrayList<Integer> comp = new ArrayList<>();
//                numberOfConnectedComponents(graph, visited, comp, i);
//                comps.add(comp);
//            }
//        }
//        System.out.println(comps);
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            graph.add(new ArrayList());
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


        HashSet<Integer> visited2 = new HashSet<>();
        hamiltonian(graph, visited2, 0, 0, 0 + " ");

    }

    private static boolean hasPath(Graph graph, boolean[] visited, int src, int dest) {
        if (src == dest)
            return true;
        visited[src] = true;
        for (var nodes : graph.getNodes(src)) {
            if (!visited[nodes.dest]) {
                boolean hasP = hasPath(graph, visited, nodes.dest, dest);
                if (hasP)
                    return true;
            }
        }
        return false;
    }

    private static void printPath(Graph graph, boolean[] visited, int src, int dest, String spsf) {
        if (src == dest) {
            System.out.println(spsf);
            return;
        }
        visited[src] = true;
        for (var nodes : graph.getNodes(src)) {
            if (!visited[nodes.dest]) {
                printPath(graph, visited, nodes.dest, dest, spsf + nodes.dest + " ");
            }
        }
        visited[src] = false;
    }

    private static void numberOfConnectedComponents(Graph graph, boolean[] visited, ArrayList<Integer> comp, int src) {
        visited[src] = true;
        comp.add(src);
        for (var node : graph.getNodes(src)) {
            if (!visited[node.dest])
                numberOfConnectedComponents(graph, visited, comp, node.dest);
        }
    }

    private static void hamiltonian(ArrayList<ArrayList<Node>> graph, HashSet<Integer> visited, int src, int osrc, String ssf) {
        if (visited.size() == 6) {
            System.out.print(ssf);
            boolean flag = false;
            for (var node : graph.get(src)) {
                if (node.dest == osrc) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.print("*");
            } else
                System.out.print(".");
            System.out.println();
            return;
        }


        visited.add(src);
        for (Node node : graph.get(src)) {
            if (!visited.contains(node.dest)) {
                hamiltonian(graph, visited, node.dest, osrc, ssf + node.dest + " ");
            }
        }

        visited.remove(src);
    }

}
