package dsdv;

import java.util.Scanner;

public class DSDVMain {
	public static void main(String[] args) {
		int[][] adjacencyMatrix = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		
		Scanner scanner=new Scanner(System.in);
		RoutingTable[] routingTables=new RoutingTable[adjacencyMatrix.length];
		
		for(int i=0;i<adjacencyMatrix.length;i++) {
			dijisktras d=new dijisktras(adjacencyMatrix.length, adjacencyMatrix, i);
			d.applyAlgo();
			d.printSolution(d.dist, d.V, d.parent);
			routingTables[i]=d.createTable();
			
		}
		
		while(true) {
			System.out.println("\n1.Change in cost 2.Link broken 3.Enter CTRL+C to exit\n");
			int input=scanner.nextInt();
			if(input==1) {
				
				System.out.println("Enter value of src,destination, and cost");
				int src=scanner.nextInt();
				int dest=scanner.nextInt();
				int cost=scanner.nextInt();
				
				adjacencyMatrix[src][dest]=cost;
				adjacencyMatrix[dest][src]=cost;
				
				System.out.println("New routing tables after change in cost");
				
				for(int i=0;i<adjacencyMatrix.length;i++) {
					dijisktras d=new dijisktras(adjacencyMatrix.length, adjacencyMatrix, i);
					d.applyAlgo();
//					d.printSolution(d.dist, d.V, d.parent);
					routingTables[i]=d.createTable();
				}
				
				for(int i=0;i<adjacencyMatrix.length;i++) {
					for (int j = 0; j < routingTables.length; j++) {
						System.out.print(routingTables[i].cost[j]+" ");
					}
					System.out.println();
					}
				System.out.println();
								
			}
			if(input==2) {
				System.out.println("Enter value of src,destination for broken link");
				int src=scanner.nextInt();
				int dest=scanner.nextInt();
			
				
				adjacencyMatrix[src][dest]=0;
				adjacencyMatrix[dest][src]=0;
				
				System.out.println("New routing tables after broken link");
				for(int i=0;i<adjacencyMatrix.length;i++) {
					dijisktras d=new dijisktras(adjacencyMatrix.length, adjacencyMatrix, i);
//					d.printSolution(d.dist, d.V, d.parent);
					d.applyAlgo();
					routingTables[i]=d.createTable();
				}
				
				for(int i=0;i<adjacencyMatrix.length;i++) {
					for (int j = 0; j < routingTables.length; j++) {
						System.out.print(routingTables[i].cost[j]+" ");
					}
					System.out.println();
					}
				System.out.println();
					
				
			}
		}
		
    }
}

