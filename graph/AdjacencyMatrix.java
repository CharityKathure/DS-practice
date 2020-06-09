package graphs;

import java.util.ArrayList;

/*Vector implementation*/
public class AdjacencyMatrix {
	
	static void addEdge(ArrayList<ArrayList<Integer>> obj, int a, int b) {
		obj.get(a).add(b);
		obj.get(b).add(a);
	}
	
	static void printGraph(ArrayList<ArrayList<Integer>> obj) {
		int v = obj.size();
		for(int i=0; i<v; i++) {
			System.out.print("vertex " +i);
			ArrayList<Integer> ob = obj.get(i);
			for(int j=0; j<ob.size(); j++) {
				System.out.print(" -> " + ob.get(j));
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		int V = 5;
		
		ArrayList<ArrayList<Integer>> obj = new ArrayList<>();
		for(int i=0; i<V; i++) {
			obj.add(new ArrayList<Integer>());
		}
		
		addEdge(obj, 0, 1);
		addEdge(obj, 0, 4);
		addEdge(obj, 1, 2);
		addEdge(obj, 1, 3);
		addEdge(obj, 1, 4);
		addEdge(obj, 2, 3);
		addEdge(obj, 3, 4);
		
		printGraph(obj);
		
	}
}
