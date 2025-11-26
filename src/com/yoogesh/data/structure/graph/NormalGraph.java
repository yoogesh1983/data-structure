package com.yoogesh.data.structure.graph;

import java.util.ArrayList;

class Edge {
	int s, d, w;

	Edge(int s, int d, int w) {
		this.s = s;
		this.d = d;
		this.w = w;
	}

	@Override
	public String toString() {
		return "{s=" + s + ", d=" + d + ", w=" + w + "}";
	}

}

public class NormalGraph {

	public static void main(String[] args) {
		int v = 5;

		ArrayList<Edge>[] graph = new ArrayList[v];
		for (int i = 0; i < v; i++) {
			graph[i] = new ArrayList<Edge>();
		}

		// 0th vertex
		graph[0].add(new Edge(0, 1, 5));

		// 1th vertex
		graph[1].add(new Edge(1, 0, 5));
		graph[1].add(new Edge(1, 2, 1));
		graph[1].add(new Edge(1, 3, 3));

		// 2th vertex
		graph[2].add(new Edge(2, 1, 1));
		graph[2].add(new Edge(2, 3, 1));
		graph[2].add(new Edge(2, 4, 2));

		// 3th vertex
		graph[3].add(new Edge(3, 1, 3));
		graph[3].add(new Edge(3, 2, 1));

		// 4th vertex
		graph[4].add(new Edge(4, 2, 2));

		for (int i = 0; i < graph[2].size(); i++) {
			Edge temp = graph[2].get(i);
			System.out.println(temp.d);
		}

		for (ArrayList<Edge> next : graph) {
			System.out.println(next);
		}
	}

}
