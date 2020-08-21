import java.util.*;
import java.lang.*;
import java.io.*;

class Graph
{
    class Edge
    {
        int src, dest, wt;
        Edge()
        {
            src = dest = wt = 0;
        }
    };

    int V, E;
    Edge edge[];

    Graph(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    void solve(Graph graph, int src)
    {
        int V = graph.V, E = graph.E;
        int dist[] = new int[V];

        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int wt = graph.edge[j].wt;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v])
                    dist[v] = dist[u] + wt;
            }
        }

        for (int j = 0; j < E; ++j) {
            int u = graph.edge[j].src;
            int v = graph.edge[j].dest;
            int wt = graph.edge[j].wt;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                System.out.println("Negative cycles exist");
                return;
            }
        }
        printit(dist, V);
    }

    void printit(int dist[], int V)
    {
        System.out.println("Vertex distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args)
    {
        Scanner obj=new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int V = obj.nextInt();
        System.out.println("Enter the number of edges:");
        int E = obj.nextInt();
        Graph graph = new Graph(V, E);
        System.out.println("Enter the source vertex, destination vertex and weight of each edge:");
        for(int i=0;i<E;i++)
        {
            graph.edge[i].src = obj.nextInt();
            graph.edge[i].dest = obj.nextInt();
            graph.edge[i].wt = obj.nextInt();
        }
        obj.close();
        graph.solve(graph, 0);
    }
}
