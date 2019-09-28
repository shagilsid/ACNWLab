package dsdv;

public class BellmanFord {
	 int[][] graph;
     int V;
     int[][] nextHop;
     private int INF=9999;

     BellmanFord(int[][] graph,int V){
         this.graph=graph;
         this.V=V;
         this.nextHop=new int[V][V];
     }

     int[][] createAS(){
         int dist[][]=new int[V][V];
         
         for(int i=0;i<V;i++){
             for(int j=0;j<V;j++){
                 dist[i][j]=graph[i][j];
                 if(graph[i][j]!=INF)
                	 nextHop[i][j]=j;
                 else
                	 nextHop[i][j]=INF;
             }
             
         }

         for(int k=0;k<V;k++){
        	 System.out.print("k: "+k);
             for(int i=0;i<V;i++){
            	 System.out.print("i: "+i);
                 for(int j=0;j<V;j++){
                	 System.out.print("j: "+j);
                     if(dist[i][k]+dist[k][j]<dist[i][j]){
                    	 nextHop[i][j]=k;
                         dist[i][j]=dist[i][k]+dist[k][j];
                         System.out.print("dist: "+dist[i][j]);
                     }
                     System.out.println();
                 }
                 System.out.println();
             }
         }
         
         RoutingTable[] rt=new RoutingTable[V];
         for(int i=0;i<V;i++) {
        	 rt[i]=new RoutingTable();
//        	 rt[i].createRoutingTable(dist[i], nextHop[i],i);
         }
         return dist;

     }
     
     int[][] getNextHop() {
    	 return nextHop;
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
         System.out.println("Parent array");
         for(int i=0;i<V;i++) {
        	 for(int j=0;j<V;j++) {
        		 System.out.printf("%d",nextHop[i][j]);
        	 }
        	 System.out.println();
         }
         

         System.out.println();
         System.out.println();
     }
     
//     void printPath(int[] parent,int i) {
//    	 if(parent[i]==-1)
//    		 return;
//     
//     printPath(parent,parent[i]);
//     System.out.println(i);
//     }
}
