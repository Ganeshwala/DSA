package Data.Structure.Algo.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	TreeNode root;
	TreeNode n1 ;
	TreeNode n2 ;
	TreeNode n3 ;
	TreeNode n4 ;
	TreeNode n5 ;
	TreeNode n6 ;
	TreeNode n7 ;
	TreeNode n8 ;
	
	public BinaryTree() {
		this.root = null;
	}
	
	public TreeNode createBinaryTree() {
		n1 = new TreeNode();
		 n2 = new TreeNode();
		 n3 = new TreeNode();
		 n4 = new TreeNode();
		 n5 = new TreeNode();
		 n6 = new TreeNode();
		 n7 = new TreeNode();
		 n8 = new TreeNode();
		
		n1.value="N1";
		n2.value="N2";
		n3.value="N3";
		n4.value="N4";
		n5.value="N5";
		n6.value="N6";
		n7.value="N7";
		n8.value="N8";
		
		n1.left = n2;
		n1.right = n3;
		n2.left=n4;
		n2.right = n5;
		n3.right = n6;
		n4.left = n7;
		n4.right = n8;
		
		root = n1;
		return root;
	}
	
	public void PreOrderTravel(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.value+" - ");
		PreOrderTravel(root.left);
		PreOrderTravel(root.right);
	}
	
	public void InOrderTravel(TreeNode root) {
		if(root == null) {
			return;
		}
		InOrderTravel(root.left);
		System.out.print(root.value+" - ");
		InOrderTravel(root.right);
	}
	
	public void PostOrderTravel(TreeNode root) {
		if(root == null)
			return;
		PostOrderTravel(root.left);
		PostOrderTravel(root.right);
		System.out.print(root.value+" - ");
	}
	
	public void LevelOrderTravel(TreeNode root) {
		if(root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode presentNode = queue.remove();
			System.out.print(presentNode.value+" - ");
			if(presentNode.left != null)
				queue.add(presentNode.left);
			if(presentNode.right != null)
				queue.add(presentNode.right);
		}
	}
	
	public void searchNode(String nodeValue) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode currentNode = queue.remove();
			if(currentNode.value.equals(nodeValue)) {
				System.out.println("Found value");
				return;
			}
			if(currentNode.left!=null)
				queue.add(currentNode.left);
			if(currentNode.right!=null)
				queue.add(currentNode.right);
		}
		System.out.println("Value Not found");
	}
	
	public void insertNode(String value) {
		TreeNode newNode = new TreeNode();
		newNode.value = value;
		if(root == null) {
			root = newNode;
			System.out.println("Value inserted at root");
			return;
		}else {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			while(!queue.isEmpty()) {
				TreeNode currentNode = queue.remove();
				if(currentNode.left == null) {
					currentNode.left = newNode;
					System.out.println("New Node is added as child of "+currentNode.value);
					return;
				}
				if(currentNode.right == null) {
					currentNode.right = newNode;
					System.out.println("New Node is added as child of "+currentNode.value);
					return;
				}
				queue.add(currentNode.left);
				queue.add(currentNode.right);
			}
		}
	}
	
	
	public TreeNode getDeepestNode() {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode deepestNode = null;
		while(!queue.isEmpty()) {
			deepestNode = queue.remove();
			if(deepestNode.left!=null)
				queue.add(deepestNode.left);
			if(deepestNode.right!=null)
				queue.add(deepestNode.right);
		}
		return deepestNode;
	}
	
	public void deleteDeepestNode() {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode parentNode=null,currentNode = null;
		while(!queue.isEmpty()) {
			currentNode = queue.poll();
			if(currentNode.left!=null) {
				parentNode = currentNode;
				queue.add(currentNode.left);
			}
			if(currentNode.right!=null) {
				parentNode = currentNode;
				queue.add(currentNode.right);
			}
		}
		if(parentNode.right != null)
			parentNode.right = null;
		if(parentNode.left != null)
			parentNode.right = null;
	}
	
	public void deleteNode(String nodeValue) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode lastNode = getDeepestNode();
		while(!queue.isEmpty()) {
			TreeNode currentNode = queue.poll(); 
			if(currentNode.value.equals(nodeValue)) {
				currentNode.value = lastNode.value;
				deleteDeepestNode();
				System.out.println("Node is Delete");
				return;
			}else {
				if(currentNode.left!=null) {
					queue.add(currentNode.left);
				}
				if(currentNode.right!=null) {
					queue.add(currentNode.right);
				}
			}
		}
	}
	
}
