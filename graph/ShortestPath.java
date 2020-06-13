package graphs;

public class ShortestPath {
	
	static int minDistance(int dist[], Boolean sptSet[]) {
		int min = Integer.MAX_VALUE, minIndex = -1;
		
		for(int i=0; i<dist.length; i++) {
			if(!sptSet[i] && dist[i] <= min) {
				min = dist[i];
				minIndex = i;
			}
		}
		
		return minIndex;
	}
	
	static void dijkstra(int graph[][], int s){
		int V = graph.length;
		
		int dist[] = new int[V];
		Boolean sptSet[] = new Boolean[V];
		
		for(int i=0; i<V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		
		//initialize value of distance from source to source as 0
		dist[s] = 0;
		
		//find shortest distance for all vertices
		for(int i=0; i<V-1; i++) {
			//pick a minimum distance vertex from a set of unvisited vertices
			int u = minDistance(dist, sptSet);
			
			//mark the selected vertex as visited
			sptSet[u] = true;
			
			//update distances for vertices adjacent to selected vertex
			for(int v=0; v<V; v++) {
				if(!sptSet[v] && graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
					dist[v] = dist[u] + graph[u][v];
				}
			}
		}
		
		printArray(dist);
	}
	
	static void printArray(int dist[]) {
		System.out.println("Vertex \t Distance from Source"); 
		for(int i=0; i<dist.length; i++) {
			System.out.println(i + " \t " + dist[i]);
		}
	}
	
	
	public static void main(String args[]) {
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
				
		dijkstra(graph, 0);
	}

}
