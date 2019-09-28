package aodv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class aodvMain {
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int matrix[][]= {{0,1,1,0,1},
				{1,0,0,1,0},{1,0,0,0,1},
				{0,1,1,0,0},{1,0,1,0,0}};
		Node[] nodes=new Node[matrix.length];
		for(int i=0;i<matrix.length;i++) {
			nodes[i]=new Node(i);
		}
		System.out.println("Enter source address");
		int src=scan.nextInt();
		System.out.println("Enter destination address");
		int dest=scan.nextInt();
		List<Node> pathList=new ArrayList<>();
		pathList.add(nodes[src]);
		AODV aodv=new AODV();
		aodv.findPath(src, dest, matrix, nodes, pathList);
		
		
		
	}

}
