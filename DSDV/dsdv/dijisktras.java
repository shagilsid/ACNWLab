package dsdv;

public class dijisktras {
	int dist[];
    boolean sptSet[];
    int parent[];
    int graph[][];
    int V;
    int src;
    
    
    dijisktras(int V,int graph[][],int src){
    	dist=new int[V];
    	sptSet=new boolean[V];
    	parent=new int[V];
    	this.graph=graph;
    	this.V=V;
    	this.src=src;
    }
    
    void applyAlgo() {
    for (int i = 0; i < V; i++)
    {
        
        dist[i] = Integer.MAX_VALUE;
        sptSet[i] = false;
    }
    parent[src] = -1;

    dist[src] = 0;

    for (int count = 0; count < V - 1; count++)
    {
        int u = minDistance(dist, sptSet);
        sptSet[u] = true;
        for (int v = 0; v < V; v++)
            if (!sptSet[v] && graph[u][v]!=0 && 
            		dist[u]!=Integer.MAX_VALUE &&
                dist[u] + graph[u][v] < dist[v])
            {
                parent[v] = u;
                dist[v] = dist[u] + graph[u][v];
            }
    }
    
    }
    
    int minDistance(int dist[], boolean isVisited[])
    {
       int min = Integer.MAX_VALUE, min_index=-1;

       for (int v = 0; v < V; v++)
         if (isVisited[v] ==false && dist[v] <= min) {
             min = dist[v]; 
             min_index = v;
         }

       return min_index;
    }
    
    void printSolution(int dist[], int n,int parent[])
    {
       System.out.print("Vertex\t\tDistance\tNext Hop \n");
       int i;
       for ( i = 0; i < V; i++) {
    	   if(i!=src)
    	   System.out.printf("\n%d -> %d \t\t %d\t\t ",src, i, dist[i]);
       printPath(parent, i);
       }
       System.out.println();
       System.out.println();
    }
    
    

    void printPath(int parent[],int j){
      if (parent[j]==-1) {
        return;
      }
      
      if(parent[j]==src)
    	  System.out.printf("%d ",j);
      printPath(parent,parent[j]);
      
    }
    
 
    int[] getNextHop(int[] parent) {
    	
    	
    	int[] nextHop=new int[V];
    	for(int i=0;i<V;i++) {
    		int j=i;
	    	while(parent[j]!=-1) {
	    		if(parent[j]==src) {
	    			nextHop[i]=j;
	    			break;
	    		}
	    		j=parent[j];
	    	}
    	}
    	return nextHop;
    }
    
    RoutingTable createTable() {
    	int[] nextHop=getNextHop(parent);
    	RoutingTable rt=new RoutingTable(dist,nextHop);
    	return rt;
    }
    
}
