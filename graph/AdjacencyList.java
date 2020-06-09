package graphs;

import java.util.ArrayList;

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
		
	}
}
