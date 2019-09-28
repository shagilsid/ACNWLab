package BGP;
import java.util.*;
class Autonomous{
	int[][] graph;
	int V;
	private int INF=9999;
	Autonomous(int[][] graph,int V){
		this.graph=graph;
		this.V=V;
	}

	Autonomous createAS(){
		int dist[][]=new int[V][V];
		
		for(int i=0;i<V;i++){
			for(int j=0;j<V;j++){
				dist[i][j]=graph[i][j];
			}
		}

		for(int k=0;k<V;k++){
			for(int i=0;i<V;i++){
				for(int j=0;j<V;j++){
					if(dist[i][k]+dist[k][j]<dist[i][j]){
						dist[i][j]=dist[i][k]+dist[k][j];
					}
				}
			}
		}

		return new Autonomous(dist,V);
	}

	void printSolution(int[][] dist){
		  for (int i=0; i<V; ++i) 
        { 
            for (int j=0; j<V; ++j) 
            { 
                if (dist[i][j]==INF) 
                    System.out.print("INF "); 
                else
                    System.out.print(dist[i][j]+"   "); 
            } 
            System.out.println(); 
        } 

	}
}	