package Data.Structure.Algo.Graph;

import java.awt.GradientPaint;
import java.util.ArrayList;

public class GraphMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<GraphNode> nodeList = new ArrayList<>();
		nodeList.add(new GraphNode("A", 0));
		nodeList.add(new GraphNode("B", 1));
		nodeList.add(new GraphNode("C", 2));
		nodeList.add(new GraphNode("D", 3));
		nodeList.add(new GraphNode("E", 4));
		
		Graph graph = new Graph(nodeList);
		graph.addUndirectEdges(0, 1);
		graph.addUndirectEdges(0, 2);
		graph.addUndirectEdges(0, 3);
		graph.addUndirectEdges(1, 4);
		graph.addUndirectEdges(2, 3);
		graph.addUndirectEdges(3, 4);
		
		System.out.println(graph.toString());
	}

}
