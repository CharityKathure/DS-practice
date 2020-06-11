package graphs;

import java.util.ArrayList;
import java.util.Iterator;

/* Count the total number of ways or paths that exist between two vertices in a directed graph. */
public class PathsBetweenVertices {
	
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	
	static void addEdge(int a, int b) {
		adj.get(a).add(b);
	}
	
	static int countPaths(int s, int d) {
		int pathCount = 0;
		pathCount = countPathsUtil(s, d, pathCount);
		return pathCount;
	}
	
	static int countPathsUtil(int s, int d, int pathCount) {
		if(s == d) {
			pathCount++;
		} else {
			Iterator<Integer> i = adj.get(s).listIterator();
			while(i.hasNext()) {
				int n = i.next();
				pathCount = countPathsUtil(n, d, pathCount);
			}
		}
		
		return pathCount;
	}
	
	public static void main(String args[]) {
		int V = 5;
		for(int i=0; i<V; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		 addEdge(0, 1); 
		 addEdge(0, 2); 
		 addEdge(0, 3); 
		 addEdge(1, 3); 
		 addEdge(2, 3); 
		 addEdge(1, 4); 
		 addEdge(2, 4); 
		 
		 int start = 0;
		 int end = 3;
		
		 System.out.println("No. of Paths between " + start + " " + "and " + end + " is:- " + countPaths(start, end));
	}

}
