package wrp;

public class WRP {
	static int INF=9999;
	
	void createWRP(Graph g) {
		int i, j, u, v, w;

		int tV = g.V;

		int tE = g.E;

		//distance array
		int d[]=new int[tV];

		//predecessor array
		int p[]=new int[tV];

	for(int k = 0; k < g.V; k++){

		for (i = 0; i < tV; i++) {
			d[i] = INF;
			p[i] = 0;
		}


		d[k] = 0;


		for (i = 1; i <= tV - 1; i++) {
			for (j = 0; j < tE; j++) {

				u = g.edge[j].u;
				v = g.edge[j].v;
				w = g.edge[j].w;

				if (d[u] != INF && d[v] > d[u] + w) {
					d[v] = d[u] + w;
					p[v] = u;
				}
			}
		}


		for (i = 0; i < tE; i++) {
			u = g.edge[i].u;
			v = g.edge[i].v;
			w = g.edge[i].w;
			if (d[u] != INF && d[v] > d[u] + w) {
				System.out.printf("Negative weight cycle detected!\n");
				return;
			}
		}

		System.out.printf("\nDistance Table of %d node :\n", k);

		System.out.printf("Node \t\t Distance \t\t penultimate node\n");
		for (i = 0; i < tV; i++) {
			if(d[i]==INF)
				System.out.printf("%d\t\t\t%s\t\t\t\t%d\n",i, "INF", p[i]);
				else
					System.out.printf("%d\t\t\t%d\t\t\t\t%d\n",i, d[i], p[i]);
		}
		System.out.printf("\n");
	  }
	}
	
	void createWRP2(Graph g,int source){
		int i, j, u, v, w;

		int tV = g.V;
		
		int tE = g.E;

		//distance array
		int d[]=new int[tV];

		//predecessor array
		int p[]=new int[tV];

		
		for (i = 0; i < tV; i++) {
			d[i] = INF;
			p[i] = 0;
		}

		
		d[source] = 0;

		
		for (i = 1; i < tV; i++) {
			for (j = 0; j < tE; j++) {
				
				u = g.edge[j].u;
				v = g.edge[j].v;
				w = g.edge[j].w;

				if (d[u] != INF && d[v] > d[u] + w) {
					d[v] = d[u] + w;
					p[v] = u;
				}
			}
		}

		
		for (i = 0; i < tE; i++) {
			u = g.edge[i].u;
			v = g.edge[i].v;
			w = g.edge[i].w;
			if (d[u] != INF && d[v] > d[u] + w) {
				System.out.printf("Negative weight cycle detected!\n");
				return;
			}
		}

		
		System.out.printf("Node \t\t Distance \t\t penultimate node\n");
		for (i = 0; i < tV; i++) {
			if(d[i]==INF)
			System.out.printf("%d\t\t\t%s\t\t\t\t%d\n",i, "INF", p[i]);
			else
				System.out.printf("%d\t\t\t%d\t\t\t\t%d\n",i, d[i], p[i]);
		}
		
	}

}
