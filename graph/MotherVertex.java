package graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

	
public class MotherVertex {
	
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int V = 5;
	static void addEdge(int s, int e){
		graph.get(s).add(e);
	}
	
	/**START BRUTEFORCE APPROACH**/
	static void DFS(int s){
		boolean visited[] = new boolean[graph.size()];
		DFSUtilBruteForce(visited, s);
	}
	
	static void DFSUtilBruteForce(boolean visited[], int s) {
		visited[s] = true;
		Queue<Integer> allVerticesofS = BFS(s);
		
		Iterator<Integer> i = graph.get(s).listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n]) {
				DFSUtilBruteForce(visited, n);
			}
		}
		if(allVerticesofS.size() == graph.size()) {
			System.out.println("\t"+s);
		}
	}
	
	static Queue<Integer> BFS(int s){
		boolean visited[] = new boolean[graph.size()];
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> allVertices = new LinkedList<>();
		
		visited[s] = true;
		q.add(s);
		
		while(!q.isEmpty()) {
			s = q.peek();
			q.poll();
			allVertices.add(s);
			Iterator<Integer> i = graph.get(s).listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) {
					visited[n] = true;
					q.add(n);
				}
			}
		}
		return allVertices;
	}
	/**END BRUTEFORCE APPROACH**/
	
	
	/**START KOSORAJU STRONGLY CONNECTED APPROACH**/
	static int findMother() {
		boolean visited[]= new boolean[graph.size()];
		
		/*get last finished vertex*/
		int lfv = 0;
		for(int i=0; i<graph.size(); i++) {
			DFSUtil(visited, i);
			lfv = i;
		}
		
		/*check if the last finished vertex is a mother vertex*/
		//Step 1: reset all visited vertices to false
		for(int i=0; i<graph.size(); i++)
			visited[i] = false;
		
		//Step 2: Call DFSUtil of last visited vertex
		DFSUtil(visited, lfv);
		
		//Step 3: iterate through the visited array, if any vertex not visited return -1... to mean the is no mother vertex, 
		for(int i=0; i<graph.size(); i++) {
			if(!visited[i]) {
				return -1;
			}
		}
		return lfv;
	}
	static void DFSUtil(boolean visited[], int s) {
		visited[s] = true;
		
		Iterator<Integer> i = graph.get(s).listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n]) {
				visited[n] = true;
				DFSUtil(visited, n);
			}
		}
	}
	/**END KOSORAJU STRONGLY CONNECTED APPROACH**/
	
	public static void main(String args[]) {
		
		for(int i=0; i<V; i++) {
			ArrayList<Integer> a = new ArrayList<>();
			graph.add(a);
		}
		
		addEdge(1, 0);
		addEdge(2, 1);
		addEdge(0, 3);
		addEdge(0, 2);
		addEdge(3, 4);
		
		
		System.out.println("Mother Vertices(Using BruteForce Method): ");
		DFS(1);
		
		System.out.println();
		System.out.println("Mother Vertices(KOSORAJU STRONGLY CONNECTED Method O(V)): " + findMother());
		
	}

}
