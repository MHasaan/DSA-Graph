import java.util.List;

public class Main 
{
    public static void main(String[] args) 
    {
        // Create a graph
        Graph graph = new Graph(6); // Adjust the size based on your needs

        // Add vertices
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        // Add edges
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "E");
        graph.addEdge("D", "F");
        graph.addEdge("E", "F");

        // Test findPathBFS
        String sourceVertex = "A";
        String destinationVertex = "E";

        System.out.println("Finding path from " + sourceVertex + " to " + destinationVertex);
        List<String> path = graph.findPathBFS(sourceVertex, destinationVertex);

        // Display the result
        if (path != null) {
            System.out.println("Path: " + path);
            System.out.println("Path Length: " + (path.size() - 1)); // Length is the number of edges
        }
    }
}
