package Data.Structure.Algo.Tree;

public class BinarySearchTree {
	public TreeNode root;
	
	//create BST
	public BinarySearchTree() {
		root = null;
	}
	//This is linkedList Approach
	public void insertValueBST(int nodeValue) {
		TreeNode newNode = new TreeNode(nodeValue);
		if(root == null) {
			root = newNode;
			return;
		}
		TreeNode currentNode = root;
		while(currentNode!=null) {
			if(currentNode.nodeValue > nodeValue) {
				if(currentNode.left == null) {
					currentNode.left = newNode;
					return;
				}
				currentNode = currentNode.left;
			}
			else if(currentNode.nodeValue < nodeValue) {
				if(currentNode.right == null) {
					currentNode.right = newNode;
					return;
				}
				currentNode = currentNode.right;
			}
		}
	}
	
	public void serachBST(int value) {
		if(root == null) {
			System.out.println("Not found");
			return;
		}
		TreeNode currentNode = root;
		while(currentNode != null) {
			if(currentNode.nodeValue < value ) {
				currentNode = currentNode.right;
			}
			else if(currentNode.nodeValue > value) {
				currentNode = currentNode.left;
			}else if(currentNode.nodeValue == value) {
				System.out.println("Value founded!!!!!");
				return;
			}
		}
		System.out.println("Value not found");
	}
	
	//This is recursion Approach
	
	private TreeNode insertNode(TreeNode currentNode,int nodeValue) {
		if(currentNode == null) {
			TreeNode newNode = new TreeNode(nodeValue);
			System.out.println("Node is inserted");
			return newNode;
		}
		else if(currentNode.nodeValue < nodeValue) {
			currentNode.right = insertNode(currentNode.right, nodeValue);
			return currentNode;
		}
		else if(currentNode.nodeValue > nodeValue) {
			currentNode.left = insertNode(currentNode.left, nodeValue);
			return currentNode;
		}
		return null;
	}
	
	public void insertBSTNode(int value) {
		root = insertNode(root, value);
	}
	
	public TreeNode serachBST(TreeNode currentNode,int value) {
		if(currentNode == null) {
			System.out.println("value not found");
			return null;
		}
		else if(currentNode.nodeValue == value) {
			System.out.println("Found Value");
			return currentNode;
		}else if(currentNode.nodeValue > value) {
			return serachBST(currentNode.left, value);
		}else if(currentNode.nodeValue < value){
			return serachBST(currentNode.right, value);
		}
		return null;
	}
	
	public TreeNode getMinimumNode(TreeNode currentNode) {
		if(currentNode.left == null) {
			return currentNode;
		}
		return getMinimumNode(currentNode.left);
	}
	
	public TreeNode deleteNode(TreeNode root,int value) {
		if(root == null) {
			System.out.println("value is not found in BST");
			return root;
		}if(root.nodeValue > value) {
			root.left = deleteNode(root.left,value);
		}
		else if(root.nodeValue < value) {
			root.right = deleteNode(root.right,value);
		}
		else {
			if(root.left!=null && root.right!=null) {
				TreeNode temp = root;
				TreeNode minNode = getMinimumNode(temp.right);
				root.nodeValue = minNode.nodeValue;
				System.out.println("========>"+root.right.nodeValue+"====="+minNode.nodeValue);
				root.right = deleteNode(temp.right, minNode.nodeValue);
				
			}else if(root.left != null) {
				root = root.left;
			}else if(root.right != null) {
				root = root.right;
			}else {
				return null;
			}
		}
		return root;
	}
	
	public void InOrderTravel(TreeNode root) {
		if(root == null)
			return;
		InOrderTravel(root.left);
		System.out.print(root.nodeValue+" - ");
		InOrderTravel(root.right);
	}
}
