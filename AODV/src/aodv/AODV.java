package aodv;

import java.util.List;



public class AODV {
	List<Node> findPath(int src,int dest,int[][] matrix,Node[] nodes,List<Node> pathList){
//		List<Node> pathList=new ArrayList<Node>();
		for(int i=0;i<matrix.length;i++) {
			if(matrix[src][i]==1&&!pathList.contains(nodes[i])) {
				pathList.add(nodes[i]);
				src=i;
				findPath(src,dest, matrix, nodes,pathList);
				pathList.remove(nodes[src]);
			}
			else {
				pathList.add(nodes[i]);
				return pathList;
			}
		}
		return pathList;
	}

}
