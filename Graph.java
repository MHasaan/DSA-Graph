import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Graph
{
    int elements;
    int size;
    int[][] adjMatrix;
    Vertex[] vertexList;

    public Graph()
    {
        size=5;
        elements = 0; //how many vertices are present
        adjMatrix = new int[size][size];  //the graph itself
        vertexList = new Vertex[size]; //list of the vertices in graph
    }

    public Graph(int size)
    {
        this.size=size;
        elements = 0; //how many vertices are present
        adjMatrix = new int[size][size];  //the graph itself
        vertexList = new Vertex[size]; //list of the vertices in graph
    }

    int indexOf(String label)
    {
        for(int i=0;i<this.elements;i++)
        {
            if(vertexList[i].getLabel().equals(label))
            {
                return i;
            }
        }
        return -1;
    }

    public void addVertex(String label)
    {
        if (elements < size) 
        {
            vertexList[elements++] = new Vertex(label);
        } 
        else 
        {
            System.out.println("Graph full.");
        }
    }

    public void addEdge(String source, String destination) 
    {
        int sourceIndex = indexOf(source);
        int destinationIndex = indexOf(destination);

        if (sourceIndex != -1 && destinationIndex != -1) 
        {
            adjMatrix[sourceIndex][destinationIndex] = 1;
            adjMatrix[destinationIndex][sourceIndex] = 1;
        } 
        else 
        {
            System.out.println("Vertices not found.");
        }
    }



    // Finds a path between two nodes using Breadth-First Search.
    public List<String> findPathBFS(String source, String destination) 
    {
        int sourceIndex = indexOf(source);
        int destinationIndex = indexOf(destination);

        if (sourceIndex == -1 || destinationIndex == -1)
        {
            System.out.println("Invalid source or destination vertex.");
            return null;
        }

        boolean[] visited = new boolean[size];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourceIndex);
        visited[sourceIndex] = true;

        int[] parent = new int[size];
        Arrays.fill(parent, -1);

        while (!queue.isEmpty()) 
        {
            int currentVertex = queue.poll();//deque

            if (currentVertex == destinationIndex) 
            {
                // Build and return the path
                return buildPath(parent, sourceIndex, destinationIndex);
            }

            for (int neighbor = 0; neighbor < size; neighbor++) 
            {
                if (adjMatrix[currentVertex][neighbor] == 1 && !visited[neighbor]) 
                {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                    parent[neighbor] = currentVertex;
                }
            }
        }

        System.out.println("Path not found between " + source + " and " + destination);
        return null;
    }

    // Helper method to build the path from the parent array.
    private List<String> buildPath(int[] parent, int sourceIndex, int destinationIndex) 
    {
        List<String> path = new ArrayList<>();
        int currentVertex = destinationIndex;

        while (currentVertex != -1) 
        {
            path.add(vertexList[currentVertex].getLabel());
            currentVertex = parent[currentVertex];
        }

        // Reverse the path to get it from source to destination
        Collections.reverse(path);
        return path;
    }


/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////

    // public boolean isNeighbour(Vertex first, Vertex second) 
    // {
    //     int firstIndex = indexOf(first);
    //     int secondIndex = indexOf(second);

    //     return firstIndex != -1 && secondIndex != -1 && adjMatrix[firstIndex][secondIndex] == 1;
    // }

    
    // public void BFS(Vertex start) 
    // {
    //     int startIndex = indexOf(start);

    //     if (startIndex == -1) 
    //     {
    //         System.out.println("Start vertex not found.");
    //         return;
    //     }

    //     boolean[] visited = new boolean[elements];
    //     Queue<Vertex> queue = new LinkedList<>();

    //     visited[startIndex] = true;
    //     queue.add(start);

    //     while (!queue.isEmpty()) 
    //     {
    //         Vertex current = queue.poll();
    //         System.out.println(current);

    //         int currentIndex = indexOf(current);

    //         for (int i = 0; i < elements; i++) 
    //         {
    //             if (adjMatrix[currentIndex][i] == 1 && !visited[i]) 
    //             {
    //                 visited[i] = true;
    //                 queue.add(vertexList[i]);
    //             }
    //         }
    //     }
    // }
    // 
    // public boolean isPath(Vertex from, Vertex to) 
    // {
    //     int fromIndex = indexOf(from);
    //     int toIndex = indexOf(to);

    //     return fromIndex != -1 && toIndex != -1 && adjMatrix[fromIndex][toIndex] == 1;
    // }

    // public int lengthOfPath(Vertex first, Vertex second) 
    // {
    //     // Implement using a graph traversal algorithm (e.g., BFS or Dijkstra's)
    //     // For simplicity, I'll use a modified BFS to find the shortest path
    //     int startIndex = indexOf(first);
    //     int endIndex = indexOf(second);

    //     if (startIndex == -1 || endIndex == -1) 
    //     {
    //         System.out.println("Vertices not found.");
    //         return -1;
    //     }

    //     boolean[] visited = new boolean[elements];
    //     Queue<Integer> queue = new LinkedList<>();
    //     int[] distances = new int[elements];

    //     visited[startIndex] = true;
    //     queue.add(startIndex);

    //     while (!queue.isEmpty()) 
    //     {
    //         int currentIndex = queue.poll();

    //         for (int i = 0; i < elements; i++) 
    //         {
    //             if (adjMatrix[currentIndex][i] == 1 && !visited[i]) 
    //             {
    //                 visited[i] = true;
    //                 distances[i] = distances[currentIndex] + 1;
    //                 queue.add(i);

    //                 if (i == endIndex) 
    //                 {
    //                     return distances[i];
    //                 }
    //             }
    //         }
    //     }

    //     return -1; // No path found
    // }

    // public int degreeOfVertex(Vertex vertex) 
    // {
    //     int vertexIndex = indexOf(vertex);

    //     if (vertexIndex == -1) 
    //     {
    //         System.out.println("Vertex not found.");
    //         return -1;
    //     }

    //     int degree = 0;
    //     for (int i = 0; i < elements; i++) 
    //     {
    //         if (adjMatrix[vertexIndex][i] == 1) 
    //         {
    //             degree++;
    //         }
    //     }

    //     return degree;
    // }

    // public boolean isSource(Vertex vertex) 
    // {
    //     return degreeOfVertex(vertex) == 0;
    // }

    // public boolean isSink(Vertex vertex) 
    // {
    //     return degreeOfVertex(vertex) == 0;
    // }
}
