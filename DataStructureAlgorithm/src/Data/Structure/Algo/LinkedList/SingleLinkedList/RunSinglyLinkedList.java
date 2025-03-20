package Data.Structure.Algo.LinkedList.SingleLinkedList;

public class RunSinglyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList sList = new SinglyLinkedList();
		sList.createSinglyLinkedList(1);
		
		sList.insertNode(2, 2);
		sList.insertNode(4, 4);
		sList.insertNode(3, 2);
		sList.printList();
		System.out.println();
		System.out.println("===========");
		sList.deletingNode(4);
		System.out.println();
		System.out.println("===========");
		sList.printList();
		sList.deletingNode(3);
		System.out.println();
		System.out.println("===========");
		sList.printList();
		sList.deletingNode(2);
		System.out.println();
		System.out.println("===========");
		sList.printList();
		sList.deletingNode(1);
		System.out.println();
		System.out.println("===========");
		sList.printList();
		
	}

}
