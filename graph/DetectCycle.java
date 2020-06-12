package graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DetectCycle {
	
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	
	static void addEdge(int a, int b) {
		adj.get(a).add(b);
	}
	
	static boolean isCyclic() {
		boolean visited[] = new boolean[adj.size()];
		boolean recursion[] = new boolean[adj.size()];
		
		for(int i=0; i<adj.size(); i++) {
			if(isCyclicUtil(visited, recursion, i)) {
				return true;
			}
		}
		
		return false;
	}
	
	static boolean isCyclicUtil(boolean visited[], boolean recursion[], int s) {
		if(recursion[s]) {
			return true;
		}
		
		visited[s] = true;
		recursion[s] = true;
		
		Iterator<Integer> i = adj.get(s).listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if(isCyclicUtil(visited, recursion, n)) {
				return true;
			}
		}
		
		recursion[s] = false; 
		
		return false;
	}
	
	public static void main(String args[]) {
		int V = 4;
		
		for(int i=0; i<V; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		/*addEdge(0, 1);
		addEdge(0, 2);
		addEdge(1, 2);
		addEdge(2, 0);
		addEdge(2, 3);
		addEdge(3, 3);*/
		
		
		addEdge(0, 1);
		addEdge(0, 2);
		addEdge(1, 2);
		addEdge(2, 3);
		
		System.out.println(isCyclic());
	}

}
