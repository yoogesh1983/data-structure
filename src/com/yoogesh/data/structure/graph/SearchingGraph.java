package com.yoogesh.data.structure.graph;

import java.util.LinkedList;
import java.util.Stack;

import com.yoogesh.data.structure.graph.Graph1.Edge;

public class SearchingGraph {

	private static void breathFirstSearch(Graph1 g, int source) {
		int v = g.v;
		boolean[] visited = new boolean[v];
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(source);
		visited[source] = true;
		while (!q.isEmpty()) {
			int curr = q.remove();
			System.out.print(curr + " ");
			LinkedList<Edge> temp = Graph1.adj.get(curr);
			for (Edge e : temp) {
				if (visited[e.dest] == false) {
					visited[e.dest] = true;
					q.add(e.dest);
				}
			}
		}
	}

	private static void depthFirstSearch(Graph1 g, int curr, boolean[] visited) {
		System.out.print(curr + " ");
		visited[curr] = true;
		LinkedList<Edge> temp = g.adj.get(curr);
		for (Edge e : temp) {
			if (visited[e.dest] == false) {
				depthFirstSearch(g, e.dest, visited);
			}
		}
	}

	private static boolean hasPath(Graph1 g, int source, int dest) {
		boolean[] visited = new boolean[g.v];
		dfsUtil(g, source, visited);
		return visited[dest];
	}

	private static void dfsUtil(Graph1 g, int curr, boolean visited[]) {
		visited[curr] = true;
		LinkedList<Edge> temp = g.adj.get(curr);
		for (Edge next : temp) {
			if (visited[next.dest] == false) {
				dfsUtil(g, next.dest, visited);
			}
		}
	}

	private static int countAllPaths(Graph1 g, int source, int dest) {
		boolean[] visited = new boolean[g.v];
		return countAllPaths(g, visited, source, dest);
	}

	private static int countAllPaths(Graph1 g, boolean[] visited, int source, int dest) {
		if (source == dest) {
			return 1;
		}
		int c = 0;
		visited[source] = true;

		// Recursion logic
		LinkedList<Edge> temp = g.adj.get(source);
		for (Edge next : temp) {
			if (visited[next.dest] == false) {
				c = c + countAllPaths(g, visited, next.dest, dest);
			}
		}

		// Backtracking logic
		visited[source] = false;
		return c;
	}

	private static void printAllPaths(Graph1 g, int source, int dest) {
		boolean[] visited = new boolean[g.v];
		Stack<Integer> path = new Stack<>();
		printAllPaths(g, visited, source, dest, path);
	}

	private static void printAllPaths(Graph1 g, boolean[] visited, int source, int dest, Stack<Integer> path) {
		path.push(source);
		if (source == dest) {
			System.out.println(path);
			path.pop();
			return;
		}
		visited[source] = true;

		// Recursion logic
		LinkedList<Edge> temp = g.adj.get(source);
		for (Edge next : temp) {
			if (visited[next.dest] == false) {
				printAllPaths(g, visited, next.dest, dest, path);
			}
		}

		// Backtracking logic
		visited[source] = false;
		path.pop();
	}

	public static boolean detectCycle(Graph1 g) {
		boolean[] visited = new boolean[g.v];
		for (int i = 0; i < g.v; i++) {
			if (!visited[i]) {
				if (detectCycleUtil(g, visited, i, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean detectCycleUtil(Graph1 g, boolean[] visited, int curr, int parent) {
		visited[curr] = true;
		LinkedList<Edge> temp = g.adj.get(curr);
		for (Edge e : temp) {
			if (!visited[e.dest]) {
				if (detectCycleUtil(g, visited, e.dest, curr)) {
					return true;
				}
			} else if (visited[e.dest] && e.dest != parent) {
				return true;
			}
		}
		return false;
	}

	public static boolean detectDirectedGraphCycle(Graph1 g) {
		boolean[] visited = new boolean[g.v];
		boolean[] stack = new boolean[g.v];
		for (int i = 0; i < g.v; i++) {
			if (!visited[i]) {
				if (detectDirectedGraphCycleUtil(g, visited, stack, i)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean detectDirectedGraphCycleUtil(Graph1 g, boolean[] visited, boolean[] stack, int curr) {
		visited[curr] = true;
		stack[curr] = true;
		LinkedList<Edge> temp = g.adj.get(curr);
		
		for (Edge e : temp) {
			if (stack[e.dest]) {
					return true;
			} 
			if (!visited[e.dest] && detectDirectedGraphCycleUtil(g, visited, stack, e.dest)) {
				return true;
			}
		}
		stack[curr] = false;  // backtracking
		return false;
	}

	public static void main(String[] args) {
		Graph1 g = new Graph1(5);

		// from vertex 0
		g.addUnDirectedEdge(0, 1);

		// from vertex 1
		g.addUnDirectedEdge(1, 2);
		g.addUnDirectedEdge(1, 4);

		// from vertex 2
		g.addUnDirectedEdge(2, 3);

		// from vertex 3
		g.addUnDirectedEdge(3, 4);

		// g.printGraph();

		System.out.println("BSF ------------- Start");
		SearchingGraph.breathFirstSearch(g, 0); // 0 1 2 4 3
		System.out.println("\nBSF ------------- End\n");

		System.out.println("\nDSF ------------- Start");
		SearchingGraph.depthFirstSearch(g, 0, new boolean[g.v]); // 0 1 2 3 4
		System.out.println("\nDSF ------------- End\n");

		System.out.println("IsPathExist ------------- Start");
		System.out.println(SearchingGraph.hasPath(g, 0, 4)); // true
		System.out.println("IsPathExist ------------- End\n");

		System.out.println("CountAllPaths ------------- Start");
		System.out.println(SearchingGraph.countAllPaths(g, 0, 4)); // 2
		System.out.println("CountAllPaths ------------- End\n");

		System.out.println("PrintAllPaths ------------- Start");
		SearchingGraph.printAllPaths(g, 0, 4); // [0, 1, 2, 3, 4] and [0, 1, 4]
		System.out.println("PrintAllPaths ------------- End\n");

		System.out.println("Detect Cycle in Undirected graph ------------- Start");
		Graph1 g1 = new Graph1(4);
		g1.addUnDirectedEdge(0, 1);
		g1.addUnDirectedEdge(0, 2);
		g1.addUnDirectedEdge(1, 2);
		g1.addUnDirectedEdge(2, 3);
		System.out.println("Cycle detected: " + SearchingGraph.detectCycle(g1)); // true
		System.out.println("Detect Cycle Undirected ------------- End\n\n");

		System.out.println("Detect Cycle in Directed graph ------------- Start");
		Graph1 g2 = new Graph1(4);
		g2.addDirectedEdge(0, 1);
		g2.addDirectedEdge(0, 2);
		g2.addDirectedEdge(2, 3);
		g2.addDirectedEdge(3, 0);
		System.out.println("Cycle detected: " + SearchingGraph.detectDirectedGraphCycle(g2)); // true
		System.out.println("Detect Cycle Directed ------------- End");
		
		// Last two videos of shortest path has not been coded yet

	}

}
