package dsdv;

public class RoutingTable {
	int src;
	int dest[];
	int cost[];
	int nextHop[];
	String seqNo[];
		
	public RoutingTable() {
		super();
	}
	
	


	public RoutingTable(int[] cost, int[] nextHop) {
		super();
		dest=new int[cost.length];
		for (int i = 0; i < nextHop.length; i++) {
			dest[i]=i;
		}
		this.cost = cost;
		this.nextHop = nextHop;
		
		
	}





	public int getSrc() {
		return src;
	}
	public void setSrc(int src) {
		this.src = src;
	}
	public int[] getDest() {
		return dest;
	}
	public void setDest(int[] dest) {
		this.dest = dest;
	}
	public int[] getCost() {
		return cost;
	}
	public void setCost(int[] cost) {
		this.cost = cost;
	}
	public int[] getNextHop() {
		return nextHop;
	}
	public void setNextHop(int[] nextHop) {
		this.nextHop = nextHop;
	}




}
