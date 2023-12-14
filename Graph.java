class Graph
{
    int elements;
    int size;
    int[][] adjMatrix;
    Vertex[] vertexList;

    public Graph()
    {
        size=5;
        elements = 0;//how man vertices are present
        adjMatrix = new int[5][5];  //the gaph itself
        vertexList = new String[5]; //list of the vertices in graph
    }


    int indexof(String label)
    {
        for(int i=0;i<this.size;i++)
        {
            if(vertexList[i].equals(label))
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
            vertexList[elements++] = label;
        } else 
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
            System.out.println("vertices not found.");
        }
    }
}
