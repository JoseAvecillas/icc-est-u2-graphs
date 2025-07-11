import controllers.Graph;
import models.Node;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        runGrafo(); 
    }

    private static void runGrafo() {
    Graph g = new Graph();

    Node n0 = g.addNode(0);
    Node n1 = g.addNode(1);
    Node n2 = g.addNode(2);
    Node n3 = g.addNode(3);
    Node n4 = g.addNode(4);
    Node n5 = g.addNode(5);
    Node n7 = g.addNode(7);
    Node n8 = g.addNode(8);
    Node n9 = g.addNode(9);

    g.addEdge(n0, n1);
    g.addEdge(n0, n5);
    g.addEdge(n1, n2);
    g.addEdge(n1, n4);
    g.addEdge(n2, n3);
    g.addEdge(n3, n0);
    g.addEdge(n3, n9);
    g.addEdge(n4, n7);
    g.addEdge(n4, n8);
    g.addEdge(n7, n3);

    System.out.println("\n--- Grafo Dirigido (de la imagen) ---");
    System.out.println("Jose Avecillas");
    g.printGraph();

    
    }
}