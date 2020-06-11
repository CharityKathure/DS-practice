package graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* Given a tree represented as undirected graph. Count the number of nodes at given level l */

public class LevelNodesCount {
	
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int V = 7;
	
	static void addEdge(int s, int e){
		graph.get(s).add(e);
		graph.get(e).add(s);
	}
	
	static int bfs(int s, int l){
		boolean visited[] = new boolean[graph.size()];
		int level[] = new int[graph.size()];
		for(int i=0; i<graph.size(); i++) {
			level[i] = 0;
			visited[i] = false;
		}	
		
		Queue<Integer> q = new LinkedList<>();
		visited[s] = true;
		level[s] = 0;
		
		q.add(s);
		
		while(!q.isEmpty()) {
			s = q.peek();
			q.poll();
			
			Iterator<Integer> i = graph.get(s).listIterator();
			
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) {
					visited[n] = true;
					level[n] = level[s] + 1;
					
					q.add(n);
				}
			}
		}
		int count = 0;
		for(int i=0; i<graph.size(); i++) {
			if(level[i] == l) {
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String args[]) {
		
		for(int i=0; i<V; i++) {
			ArrayList<Integer> a = new ArrayList<>();
			graph.add(a);
		}
		
		addEdge(0, 1);
		addEdge(0, 2);
		addEdge(1, 3);
		addEdge(1, 4);
		addEdge(1, 5);
		addEdge(2, 6);
		
		int level = 2;
		System.out.print(bfs(0, level));
	}

}
