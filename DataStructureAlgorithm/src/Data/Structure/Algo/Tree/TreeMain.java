package Data.Structure.Algo.Tree;

public class TreeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		TreeNode rootNode = bt.createBinaryTree();
		System.out.println("=======PreOrder Travel========");
		bt.PreOrderTravel(rootNode);
		System.out.println();
		System.out.println();
		System.out.println("=======InOrder Travel========");
		bt.InOrderTravel(rootNode);
		System.out.println();
		System.out.println();
		System.out.println("=======PostOrder Travel========");
		bt.PostOrderTravel(rootNode);
		System.out.println();
		System.out.println();
		System.out.println("=======Level Order Travel========");
		bt.LevelOrderTravel(rootNode);
		
		System.out.println();
		System.out.println("=======Search Binary Tree Level Order Travel========");
		bt.searchNode("N11");
		
		System.out.println();
		System.out.println("=======Insert Node in Binary Tree Level Order Travel========");
		bt.insertNode("N11");
		
		System.out.println();
		System.out.println("=======InOrder Travel========");
		bt.InOrderTravel(rootNode);
		
		System.out.println();
		System.out.println("=======Deepest Node in Binary Tree Level Order Travel========");
		System.out.println(bt.getDeepestNode().value);
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.insertValueBST(70);
		bst.insertValueBST(50);
		bst.insertValueBST(60);
		bst.insertValueBST(30);
		bst.insertValueBST(90);
		bst.insertValueBST(80);
		bst.insertValueBST(100);
		System.out.println();
		System.out.println("=======InOrder Travel from BST========");
		bst.InOrderTravel(bst.root);
		bst.serachBST(60);
		
		BinarySearchTree bstRe = new BinarySearchTree();
		bstRe.insertBSTNode(70);
		bstRe.insertBSTNode(50);
		bstRe.insertBSTNode(60);
		bstRe.insertBSTNode(30);
		bstRe.insertBSTNode(90);
		bstRe.insertBSTNode(80);
		bstRe.insertBSTNode(100);
		System.out.println();
		System.out.println("=======InOrder Travel from BST========");
		bstRe.InOrderTravel(bstRe.root);
		bstRe.serachBST(bstRe.root, 90);
		bstRe.deleteNode(bstRe.root, 70);
		System.out.println("=======InOrder Travel from BST========");
		bstRe.InOrderTravel(bstRe.root);
		
	}

}
