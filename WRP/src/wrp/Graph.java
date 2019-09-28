package wrp;

public class Graph {
	int V;
	int E;
	
	Edge edge[];
	
	
	Graph(int v,int e){
		this.V=v;
		this.E=e;
		edge=new Edge[E];
		for(int i=0;i<E;i++) {
			edge[i]=new Edge();
		}
	}

}
