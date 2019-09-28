package wrp;

import java.util.Scanner;

public class WRPmain {
	static int INF=9999;

	public static void main(String[] args) {
		int v, e;
		Scanner scan=new Scanner(System.in);
		//create graph
		
		//total vertices
		System.out.printf("Enter the number of verticies\n");
		v=scan.nextInt();
		
		//total edges
		System.out.printf("Enter the number of Edges\n");
		e=scan.nextInt();
		
		
		Graph g=new Graph(v,e);

		
		int e1, e2, w;
		
		for (int i = 0; i < e; i++) {
			System.out.printf("Enter the Starting vertex number,Ending Vertex number and edge weight\n");
			e1=scan.nextInt();
			g.edge[i].u = e1;
			
			e2=scan.nextInt();
			g.edge[i].v = e2;
			
			w=scan.nextInt();
			g.edge[i].w = w;
		}

		WRP wrp=new WRP();
		wrp.createWRP(g);
		System.out.println("Enter source vertex");
		int s=scan.nextInt();
		wrp.createWRP2(g,s);
		
		System.out.printf("Enter the source node, destination node and weight\n");
		e1=scan.nextInt();
		e2=scan.nextInt();
		w=scan.nextInt();
		
		for (int i = 0; i < e; i++) {
		
			if(g.edge[i].u == e1 && g.edge[i].v == e2)
				g.edge[i].w = w;
		}
		wrp.createWRP2(g, s);

	}
	

}
