package graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*Vector implementation*/
public class AdjacencyList {
	
	static void addEdge(ArrayList<ArrayList<Integer>> adj, int a, int b) {
		adj.get(a).add(b);
		adj.get(b).add(a);
	}
	
	static void printGraph(ArrayList<ArrayList<Integer>> adj) {
		int v = adj.size();
		for(int i=0; i<v; i++) {
			System.out.print("vertex " +i);
			ArrayList<Integer> ad = adj.get(i);
			for(int j=0; j<ad.size(); j++) {
				System.out.print(" -> " + ad.get(j));
			}
			System.out.println();
		}
	}
	
	static void BFS(ArrayList<ArrayList<Integer>> adj, int s) {

		boolean visited[] = new boolean[adj.size()];
		
		Queue<Integer> q = new LinkedList<>();		
		visited[s] = true;
		q.add(s);
		
		while(!q.isEmpty()) {
			s = q.poll();
			
			System.out.print(s + " ");
			
			Iterator<Integer> i = adj.get(s).listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) {
					visited[n] = true;
					q.add(n);
				}
			}
		}
	}
	
	static void DFS(ArrayList<ArrayList<Integer>> adj, int s) {
		boolean visited[] = new boolean[adj.size()];
		
		DFSUtil(adj, visited, s);
	}
	static void DFSUtil(ArrayList<ArrayList<Integer>> adj, boolean visited[], int s) {
		
		visited[s] = true;
		System.out.print(s + " ");
		
		Iterator<Integer> i = adj.get(s).listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n]) {
				DFSUtil(adj, visited, n);
			}
		}
	}

	public static void main(String args[]) {
		int V = 5;
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i=0; i<V; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 4);
		addEdge(adj, 1, 2);
		addEdge(adj, 1, 3);
		addEdge(adj, 1, 4);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);
		
		printGraph(adj);
		
		System.out.println();
		
		System.out.print("Breadth First Search: ");
		BFS(adj, 2);
		
		System.out.println();
		
		System.out.print("Depth First Search: ");
		DFS(adj, 2);
	}
}
