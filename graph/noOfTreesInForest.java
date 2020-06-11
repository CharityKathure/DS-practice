package graphs;

import java.util.ArrayList;
import java.util.Iterator;

/* 
 * Given n nodes of a forest (collection of trees), find the number of trees in the forest. 
 * Example:
 * Input :  edges[] = {0, 1}, {0, 2}, {3, 4}
 * Output : 2
 * Explanation : There are 2 trees
                   0       3
                  / \       \
                 1   2       4
 * */
public class noOfTreesInForest {
	static ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
	
	static void addEdge(int a, int b) {
		adj.get(a).add(b);
		adj.get(b).add(a);
	}
	
	static int noofTrees() {
		boolean visited[] = new boolean[adj.size()];
		int t=0;
		
		for(int i=0; i<adj.size(); i++) {
			if(!visited[i]) {
				noofTreesUtil(visited, i);
				t++;
			}
		}
		return t;
	}
	
	static void noofTreesUtil(boolean visited[], int s) {
		visited[s] = true;
		
		Iterator<Integer> i = adj.get(s).listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n]) {
				noofTreesUtil(visited, n);
			}
		}
	}
	
	
	public static void main(String args[]) {
		int V = 5;
		for(int i=0; i<V; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		addEdge(0, 1);
		addEdge(0, 2);
		addEdge(3, 4);
		
		System.out.println("No. of trees:- " + noofTrees());
	}
}
