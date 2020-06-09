package graphs;

public class AdjacencyMatrix {
	static int vertices;
	static boolean adjMax[][];
	
	AdjacencyMatrix(int v){
		vertices = v;
		adjMax = new boolean[v][v];
	}
	
	void addEdge(int a, int b) {
		adjMax[a][b] = true;
		adjMax[b][a] = true;		
	}
	
	static void printValues(boolean adj[][]){
		for(int i=0; i<vertices; i++) {
			System.out.print(i + ": ");
			for(int j=0; j<vertices; j++) {
				int val;
				if(adj[i][j] == true) {
					val = 1;
				} else {
					val = 0;
				}
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		AdjacencyMatrix g = new AdjacencyMatrix(5);
		
		g.addEdge(0, 1);
		g.addEdge(0, 4);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		
		printValues(adjMax);
	}
	

}
