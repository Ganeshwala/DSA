package Data.Structure.Algo.LinkedList.SingleLinkedList;

import Data.Structure.Algo.LinkedList.Node;

public class SinglyLinkedList {

	Node head;
	Node tail;
	public int size;
	
	
	public Node createSinglyLinkedList(int nodeValue) {
		head = new Node();
		head.value = nodeValue;
		head.next = null;
		tail = head;
		size++;
		return head;
	}
	
	public void insertNode(int nodeValue,int position) {
		Node newNode = new Node();
		newNode.value = nodeValue;
		if(head == null) {
			createSinglyLinkedList(nodeValue);
			return;
		}
		else if(position == 0) {
			newNode.next = head;
			head = newNode;
		}else if(size < position){
			Node temp = head;
			while(temp.next != null) {
				temp = head.next;
			}
			temp.next = newNode;
			newNode.next = null;
			tail = newNode;
		}else {
			Node temp = head;
			int location = 0;
			while(location < position-1) {
				temp = temp.next;
				location++;
			}
			newNode.next = temp.next;
			temp.next = newNode;
		}
		size++;
	}
	
	public void deletingNode(int position) {
		if(head == null) {
			return;
		}else if(position == 1 && head.next == null){
			size--;
			head = null;
			return ;
		}else if(position == 1 && head.next !=null) {
			head = head.next;
			size--;
			return;
		}
		else {
			if(position == size) {
				
			}
			int location = 1;
			Node temp = head;
			while(location < position-1 ) {
				temp = temp.next;
				location++;
			}
			temp.next = temp.next.next !=null ? temp.next.next : null;
		}
		size--;
	}
	
	public void printList() {
		Node tempHead = head;
		while(tempHead != null) {
			System.out.print(tempHead.value+"->");
			tempHead = tempHead.next;
		}
		
		
	}
	
}
