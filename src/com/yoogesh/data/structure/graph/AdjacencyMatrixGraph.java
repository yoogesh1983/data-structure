package com.yoogesh.data.structure.graph;

class Graph {
	int v;
	int[][] adj;
	
	Graph(int v){
		this.v = v;
		adj = new int[v][v];
	}
	
	void addDirectedEdge(int s, int d, int w) {
		adj[s][d] = w;
	}
	
	void addUnDirectedEdge(int s, int d, int w) {
		addDirectedEdge(s, d, w);
		addDirectedEdge(d, s, w);
	}
	
	void printGraph() {
		for(int i=0; i<v; i++) {
			System.out.print("Vertex "+i+" is connected to: ");
			for(int j=0; j<v; j++) {
				if(adj[i][j] != 0) {
					System.out.print("("+j+ "," +adj[i][j]+") ");
				}
			}
			System.out.println();
		}
	}
}



public class AdjacencyMatrixGraph {
	public static void main(String[] args) {
		Graph g = new Graph(4);
		
		//from vertex 0
		g.addUnDirectedEdge(0, 1, 1);
		g.addUnDirectedEdge(0, 2, 1);
		
		
		//from vertex 1
		g.addUnDirectedEdge(1, 2, 1);
		g.addUnDirectedEdge(1, 3, 1);
		
		//from vertex 2
		g.addUnDirectedEdge(2, 3, 1);
		
		g.printGraph();
		
		
	}
}
