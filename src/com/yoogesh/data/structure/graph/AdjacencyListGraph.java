package com.yoogesh.data.structure.graph;

import java.util.LinkedList;

class Graph1 {

	static class Edge {
		int dest;
		int cost;

		Edge(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}

	int v;
	static LinkedList<LinkedList<Edge>> adj;

	Graph1(int v) {
		this.v = v;
		adj = new LinkedList<LinkedList<Edge>>();
		for (int i = 0; i < v; i++) {
			adj.add(new LinkedList<Edge>());
		}
	}

	void addDirectedEdge(int s, int d, int w) {
		Edge edge = new Edge(d, w);
		adj.get(s).add(edge);
	}

	void addDirectedEdge(int s, int d) {
		Edge edge = new Edge(d, 1);
		adj.get(s).add(edge);
	}

	void addUnDirectedEdge(int s, int d, int w) {
		addDirectedEdge(s, d, w);
		addDirectedEdge(d, s, w);
	}

	void addUnDirectedEdge(int s, int d) {
		addDirectedEdge(s, d, 1);
		addDirectedEdge(d, s, 1);
	}

	void printGraph() {
		for (int i = 0; i < v; i++) {
			LinkedList<Edge> temp = adj.get(i);

			System.out.print("Vertex " + i + " is connected to: ");
			for (Edge next : temp) {
				System.out.print("(" + next.dest + "," + next.cost + ") ");
			}
			System.out.println();
		}
	}
}

public class AdjacencyListGraph {
	public static void main(String[] args) {
		Graph1 g = new Graph1(4);

		// from vertex 0
		g.addUnDirectedEdge(0, 1, 1);
		g.addUnDirectedEdge(0, 2, 1);

		// from vertex 1
		g.addUnDirectedEdge(1, 2, 1);
		g.addUnDirectedEdge(1, 3, 1);

		// from vertex 2
		g.addUnDirectedEdge(2, 3, 1);

		g.printGraph();
	}
}
