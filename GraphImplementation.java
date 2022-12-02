package graphs;

public class GraphImplementation {
	
	// this is Graph Implementation using Adjacency matrix
	static final int v=5;
	
	private void addEdge(int arr[][], int src, int dest) {
		arr[src][dest] = 1;
	}
	
	private void addEdgeUndirectedGraph(int arr[][], int src, int dest) {
		arr[src][dest] = 1;
		arr[dest][src] = 1;
	}
	
	private void printAdjMatrix(int arr[][]) {
		for(int i=0; i<v; i++) {
			for(int j=0; j<v; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private int hasEdge(int arr[][], int src, int dest) {
		if(arr[src][dest] == 1)
			return 1;
		
		return 0;
	}
	
	private void removeEdge(int arr[][], int src, int dest) {
		arr[src][dest] = 0;
	}

	public static void main(String[] args) {
		int [][] adj = new int[v][v];
		
		GraphImplementation obj = new GraphImplementation();
		// Directed Graph
		obj.addEdge(adj, 0, 1);
		obj.addEdge(adj, 0, 2);
		obj.addEdge(adj, 0, 3);
		obj.addEdge(adj, 1, 3);
		obj.addEdge(adj, 1, 4);
		obj.addEdge(adj, 2, 3);
		obj.addEdge(adj, 3, 4);
		
		System.out.println("Adjacency matrix: ");
		obj.printAdjMatrix(adj);
		
		// check No. of edges
		System.out.println("No. of Edges from 2 to 3 are: "+obj.hasEdge(adj, 2, 3));
		System.out.println("No. of Edges from 3 to 3 are: "+obj.hasEdge(adj, 3, 3));
		
		// remove an edge
		obj.removeEdge(adj, 0, 3);
		obj.removeEdge(adj, 2, 3);
		System.out.println("After removing edges: ");
		obj.printAdjMatrix(adj);
		
		// Undirected graph
		obj = new GraphImplementation();
		obj.addEdgeUndirectedGraph(adj, 0, 1);
		obj.addEdgeUndirectedGraph(adj, 0, 2);
		obj.addEdgeUndirectedGraph(adj, 0, 3);
		obj.addEdgeUndirectedGraph(adj, 1, 3);
		obj.addEdgeUndirectedGraph(adj, 1, 4);
		obj.addEdgeUndirectedGraph(adj, 2, 3);
		obj.addEdgeUndirectedGraph(adj, 3, 4);
		System.out.println("Adjacency matrix for Undirected graph: ");
		obj.printAdjMatrix(adj);
	}

}
