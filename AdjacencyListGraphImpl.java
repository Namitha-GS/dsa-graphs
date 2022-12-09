package graphs;

public class AdjacencyListGraphImpl {
	
	static class Node {
		int data;
		Node next;
	}
	
	static final int v = 5;
	
	Node adjlist[] = new Node[5];
	
	public void addEdge(int src, int dest) {
		
/*      Time complexity = O(n)     */
//		Node newNode = new Node();
//		newNode.data = dest;
//		newNode.next = null;
//		
//		if(adjlist[src] == null) 
//			adjlist[src] = newNode;
//		else {
//			Node last = adjlist[src];
//			while(last.next != null) {
//				last = last.next;
//			}
//			last.next = newNode;
//		}
		
/*      Time complexity = O(1)     */
		Node newNode = new Node();
		newNode.data = dest;
		newNode.next = adjlist[src];
		adjlist[src] = newNode;
	}
	
	public void printGraph() {
		for(int i=0; i< v; i++) {
			Node temp = adjlist[i];
			System.out.print("adjlist["+i+"]->");
			while(temp != null) {
				System.out.print(temp.data+"->");
				temp = temp.next;
			}
			System.out.println("null");
		}
	}
	
	public int hasEdge(int src, int dest) {
		Node temp = adjlist[src];
		while(temp != null) {
			if(temp.data == dest)
				return 1;
			
			temp = temp.next;
		}
		return 0;
	}
	
	public void removeEdge(int src, int dest) {
		if(adjlist[src] == null)
			return;
		
		if(adjlist[src].data == dest) {
			adjlist[src] = adjlist[src].next;
		} else {
			Node current = adjlist[src], temp;
			while(current.next != null) {
				if(current.next.data == dest) {
					temp = current.next;
					current.next = temp.next;
					break;
				} else {
					current = current.next;
				}
			}		 	
		}
	}
	
	public void addEdgeUndirectedGraph(int src, int dest) {
		Node newNode = new Node();
		newNode.data = dest;
		newNode.next = adjlist[src];
		adjlist[src] = newNode;
		
		newNode = new Node();
		newNode.data = src;
		newNode.next = adjlist[dest];
		adjlist[dest] = newNode;
	}

	public static void main(String[] args) {
		AdjacencyListGraphImpl obj = new AdjacencyListGraphImpl();
		obj.addEdge(0, 1);
		obj.addEdge(0, 2);
		obj.addEdge(0, 3);
		obj.addEdge(1, 3);
		obj.addEdge(1, 4);
		obj.addEdge(2, 3);
		obj.addEdge(3, 4);
		System.out.println("Adjacency List Impl for Directed Graph: ");
		obj.printGraph();
		
		System.out.println();
		System.out.println("Has Edge(0,3): "+obj.hasEdge(0, 3));
		System.out.println("Has Edge(0,1): "+obj.hasEdge(0, 1));
		
		System.out.println();
		System.out.println("Remove Edge: ");
		obj.removeEdge(0, 3);
		obj.removeEdge(0, 1);
		obj.printGraph();
		
		System.out.println();
		System.out.println("Undirected Graph Adjacency list: ");
		obj = new AdjacencyListGraphImpl();
		obj.addEdgeUndirectedGraph(0, 1);
		obj.addEdgeUndirectedGraph(0, 2);
		obj.addEdgeUndirectedGraph(0, 3);
		obj.addEdgeUndirectedGraph(1, 3);
		obj.addEdgeUndirectedGraph(1, 4);
		obj.addEdgeUndirectedGraph(2, 3);
		obj.addEdgeUndirectedGraph(3, 4);
		obj.printGraph();
	}

}
