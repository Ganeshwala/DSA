package Data.Structure.Algo.Graph;

import java.util.ArrayList;

public class Graph {

	ArrayList<GraphNode> nodeList = new ArrayList<>();
	int[][] adjecencyMatrix;
	
	public Graph(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
		adjecencyMatrix = new int[nodeList.size()][nodeList.size()];
	}
	
	public void addUndirectEdges(int i,int j) {
		adjecencyMatrix[i][j] = 1;
		adjecencyMatrix[j][i] = 1;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		
		for(int i=0;i<nodeList.size();i++) {
			sb.append(nodeList.get(i).name+" ");
		}
		sb.append("\n");
		
		for(int i=0;i<nodeList.size();i++) {
			sb.append(nodeList.get(i).name+":");
			for(int j : adjecencyMatrix[i]) {
				sb.append((j)+" ");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
