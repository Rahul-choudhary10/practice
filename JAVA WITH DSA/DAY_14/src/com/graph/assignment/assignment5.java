package com.graph.assignment;
import java.util.*;

public class assignment5 {
	static class Graph{
		private int V;
		private LinkedList<Integer> adj[];
		
		Graph(int v){
			V = v;
			adj = new LinkedList[V];
			for(int i=0; i<v; ++i) {
				adj[i] = new LinkedList();
			}
		}
		
		void addEdge(int v, int w) {
			adj[v].add(w);
			adj[w].add(v);
		}
		
		void BFS(int s) {
			boolean visited[] = new boolean[V];
			
			LinkedList<Integer> queue = new LinkedList<Integer>();
			
			visited[s] = true;
			queue.add(s);
			
			while(queue.size()!=0) {
				s = queue.poll();
				System.out.print(s+" ");
				
				Iterator<Integer> i = adj[s].listIterator();
				while(i.hasNext()) {
					int n = i.next();
					if(!visited[n]) {
						visited[n] = true;
						queue.add(n);
					}
				}
			}
		}
	}
	
	public static void main(String args[]) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		System.out.println("Breadth First traversal starting from vertex 2:");
		g.BFS(2);
		
	}

	
	
}
