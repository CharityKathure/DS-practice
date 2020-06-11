package graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

//to be optimized. current time complexity is O(V*V)
	
public class TraversalEachVertex {
	
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	static void addEdge(int s, int e){
		graph.get(s).add(e);
	}
	
	static void DFS(int s){
		boolean visited[] = new boolean[graph.size()];
		DFSUtil(visited, s);
	}
	
	static void DFSUtil(boolean visited[], int s) {
		visited[s] = true;
		System.out.print(s + ": ");
		BFS(s);
		Iterator<Integer> i = graph.get(s).listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n]) {
				DFSUtil(visited, n);
			}
		}
		
	}
	
	static void BFS(int s){
		boolean visited[] = new boolean[graph.size()];
		
		Queue<Integer> q = new LinkedList<>();
		visited[s] = true;
		q.add(s);
		
		while(!q.isEmpty()) {
			s = q.peek();
			q.poll();
			
			System.out.print(s+ " ");
			Iterator<Integer> i = graph.get(s).listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) {
					visited[n] = true;
					q.add(n);
				}
			}
		}
		System.out.println();
	}
	
	
	
	public static void main(String args[]) {
		int V = 5;
		for(int i=0; i<V; i++) {
			ArrayList<Integer> a = new ArrayList<>();
			graph.add(a);
		}
		
		addEdge(1, 0);
		addEdge(2, 1);
		addEdge(0, 3);
		addEdge(0, 2);
		addEdge(3, 4);
		
		DFS(1);
	}

}
