package controllers;
import java.util.*;

import models.Node;

public class Graph {

    private Set<Node> nodes;

    public Graph() {
        nodes = new HashSet<>();
    }

    public Node addNode(int value) {
        Node newNode = new Node(value);
        nodes.add(newNode);
        return newNode;
    }

    public void addEdge(Node src, Node dest) {
        src.neighbors.add(dest);
        dest.neighbors.add(src);
    }

    public void addEdgeUni(Node src, Node dest){
        src.neighbors.add(dest);
    }

    public void printGraph() {
        List<Node> sortedNodes = new ArrayList<>(nodes);
        sortedNodes.sort(Comparator.comparingInt(n -> n.value));

        for (Node node : sortedNodes) {
            System.out.print("Vertex " + node.value + ":");

            // Ordenamos los vecinos por valor también
            List<Node> sortedNeighbors = new ArrayList<>(node.neighbors);
            sortedNeighbors.sort(Comparator.comparingInt(n -> n.value));

            for (Node neighbor : sortedNeighbors) {
                System.out.print(" -> " + neighbor.value);
            }

            System.out.println();
        }
    }

    public void printDFSPaths() {
        List<Node> sortedNodes = new ArrayList<>(nodes);
        sortedNodes.sort(Comparator.comparingInt(n -> n.value));

        for (Node node : sortedNodes) {
            Set<Node> visited = new HashSet<>();
            List<Integer> path = new ArrayList<>();
            dfs(node, visited, path);
            System.out.print("Vertex " + node.value + ":");
            for (int val : path) {
                if (val != node.value) {
                    System.out.print(" -> " + val);
                }
            }
            System.out.println();
        }
    }

    private void dfs(Node node, Set<Node> visited, List<Integer> path) {
        visited.add(node);
        path.add(node.value);
        List<Node> neighborsSorted = new ArrayList<>(node.neighbors);
        neighborsSorted.sort(Comparator.comparingInt(n -> n.value));
        for (Node neighbor : neighborsSorted) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited, path);
            }
        }
    }
}