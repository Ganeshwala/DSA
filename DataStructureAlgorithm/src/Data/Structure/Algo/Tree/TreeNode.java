package Data.Structure.Algo.Tree;

public class TreeNode {
	public String value;
	public TreeNode left;
	public TreeNode right;
	public int heigth;
	public int nodeValue;
	
	public TreeNode() {
		
	}
	
	public TreeNode(int nodeValue) {
		this.nodeValue = nodeValue;
		this.left = null;
		this.right = null;
		
	}
}
