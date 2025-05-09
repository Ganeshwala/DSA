package Data.Structure.Algo.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
	
	public BinaryNode root;
	
	public AVLTree() {
		root = null;
	}
	
	
	//getHeight
	public int getHeight(BinaryNode node) {
		if(node == null) {
			return 0;
		}
		return node.height;
	}
	
	//rotate Righe for LL rotaion
	private BinaryNode rotateRight(BinaryNode disBalancedNode) {
		BinaryNode newRoot = disBalancedNode.left;
		disBalancedNode.left = disBalancedNode.left.right;
		newRoot.right = disBalancedNode;
		disBalancedNode.height = 1 + Math.max(getHeight(disBalancedNode.left),getHeight(disBalancedNode.right));
		newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
		return newRoot;
	}
	
	//rotate Left for RR rotation
	private BinaryNode rotateLeft(BinaryNode disBalancedNode) {
		BinaryNode newRoot = disBalancedNode.right;
		disBalancedNode.right = disBalancedNode.right.left;
		newRoot.left = disBalancedNode;
		disBalancedNode.height = 1 + Math.max(getHeight(disBalancedNode.left),getHeight(disBalancedNode.right));
		newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
		return newRoot;
	}
	
	//getBalance
	public int getBalance(BinaryNode node) {
		if(node == null) {
			return 0;
		}
		return getHeight(node.left) - getHeight(node.right);
	}
	
	private BinaryNode insertNode(BinaryNode node,int nodeVal) {
		if(node == null) {
			BinaryNode newNode = new BinaryNode();
			newNode.val = nodeVal;
			newNode.height = 1;
			return newNode;
		}
		else if(nodeVal < node.val) {
			node.left = insertNode(node.left, nodeVal);
		}else if(nodeVal > node.val) {
			node.right = insertNode(node.right, nodeVal);
		}
		
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		// checking balance of tree
		int balance = getBalance(node);
		
		//LL Rotation   
		if(balance > 1 && nodeVal < node.left.val) {
			return rotateRight(node);
		}
		
		//LR Rotation
		if(balance > 1 && nodeVal > node.left.val) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}
		
		//RR Rotation
		if(balance < -1 && nodeVal > node.right.val) {
			return rotateLeft(node);
		}
		
		//RL Ratation
		if(balance < -1 && nodeVal < node.right.val) {
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}
		return node;
	}
	
	public void insert(int value) {
		root = insertNode(root, value);
	}
		
	public void inOrder(BinaryNode root) {
		if(root == null)
			return;
		inOrder(root.left);
		System.out.println(root.val);
		inOrder(root.right);
	}
	
	public void levelOrder() {
		Queue< BinaryNode> nodeQ = new LinkedList<BinaryNode>();
		nodeQ.add(root);
		while(!nodeQ.isEmpty()) {
			BinaryNode temp = nodeQ.poll();
			System.out.print(temp.val+" ");
			if(temp.left!=null) {
				nodeQ.add(temp.left);
			}
			if(temp.right!=null) {
				nodeQ.add(temp.right);
			}
		}
	}
	
	
	//Healper method to find Minimum node from tree
	public static BinaryNode getMinNode(BinaryNode root) {
		if(root.left == null)
			return root;
		return getMinNode(root.left);
	}
	
	//Delete Node
	public BinaryNode deleteNode(BinaryNode root , int value) {
		if(root == null) {
			System.out.println("Value not found in AVL");
		return root;
		}
		if(root.val > value) {
			root.left = deleteNode(root.left,value);
		}
		else if(root.val < value) {
			root.right = deleteNode(root.right,value);
		}else {
			// node has two children
			if(root.left!=null && root.right!=null) {
				BinaryNode temp = root;
				BinaryNode minNodeFromRight = getMinNode(temp.right);
				root.val = minNodeFromRight.val;
				root.right = deleteNode(root.right, minNodeFromRight.val);
			}
			// only has left child
			else if(root.left != null)
			{
				root = root.left;
			}
			// if only has right child
			else if(root.right != null) {
				root = root.right;
			}
			// leaf node
			else {
				root = null;
			}
		}
		
		int balanaced = getBalance(root);
		if(balanaced > 1 && getBalance(root.left)>=0) {
			return rotateRight(root);
		}
		if(balanaced > 1 && getBalance(root.left)<0) {
			root.left =rotateLeft(root.left);
			return rotateRight(root);
		}
		if(balanaced < -1 && getBalance(root.right) <= 0) {
			return rotateLeft(root);
		}
		if(balanaced < -1 && getBalance(root.right) >0) {
			root.right = rotateRight(root.right);
			return rotateLeft(root);
		}
		if(root !=null) {
			root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
		}
		return root;
		
	}
	
	public BinaryNode delet(int value) {
		root = deleteNode(root,value);
		return root;
	}
}
