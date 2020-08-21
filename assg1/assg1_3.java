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
		int V = 5;
		int E = 8;

		Graph graph = new Graph(V, E); 

		graph.edge[0].src = 0; 
		graph.edge[0].dest = 1; 
		graph.edge[0].wt = -1; 

		graph.edge[1].src = 0; 
		graph.edge[1].dest = 2; 
		graph.edge[1].wt = 4; 

		graph.edge[2].src = 1; 
		graph.edge[2].dest = 2; 
		graph.edge[2].wt = 3; 

		graph.edge[3].src = 1; 
		graph.edge[3].dest = 3; 
		graph.edge[3].wt = 2; 

		graph.edge[4].src = 1; 
		graph.edge[4].dest = 4; 
		graph.edge[4].wt = 2; 

		graph.edge[5].src = 3; 
		graph.edge[5].dest = 2; 
		graph.edge[5].wt = 5; 

		graph.edge[6].src = 3; 
		graph.edge[6].dest = 1; 
		graph.edge[6].wt = 1; 

		graph.edge[7].src = 4; 
		graph.edge[7].dest = 3; 
		graph.edge[7].wt = -3; 

		for(int i=0; i<5; i++)
		{
			System.out.println("Source vertex="+i);
			graph.solve(graph, i);
		}
	} 
} 
