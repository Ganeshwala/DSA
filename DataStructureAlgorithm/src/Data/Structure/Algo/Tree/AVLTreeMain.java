package Data.Structure.Algo.Tree;

public class AVLTreeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVLTree avl = new AVLTree();
		avl.insert(5);
		avl.insert(10);
		avl.insert(15);
		avl.insert(20);
		//avl.insert(2);
		//avl.insert(4);
		avl.levelOrder();
		System.out.println("===========");
		  BinaryNode delet = avl.delet(5);
		avl.levelOrder();
		System.out.println(avl.getHeight(delet));
	}

}
