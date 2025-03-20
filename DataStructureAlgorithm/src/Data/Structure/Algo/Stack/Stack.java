package Data.Structure.Algo.Stack;

public class Stack {
	int[] arr;
	int toOfSatck;
	
	public Stack(int size) {
		this.arr = new int[size];
		this.toOfSatck = -1;
		System.out.println("Stack is create "+size);
	}
	
	public boolean isEmpty() {
		return (toOfSatck == -1)? true : false;
	}
	
	public boolean isFull() {
		return toOfSatck == arr.length-1 ? true : false;
	}
	
	public void push(int value) {
		if(toOfSatck == arr.length-1) {
			System.out.println("cannot add element");
		}else {
			this.arr[toOfSatck+1] = value;
			toOfSatck++;
			System.out.println("element is add to stack;");
		}
	}
	
	public int peek() {
		if(toOfSatck == -1) {
			System.out.println("canot peek element as stack is empty");
			return toOfSatck;
		}else {
			return arr[toOfSatck];
		}
	}
	
	public int pop() {
		if(toOfSatck == -1) {
			System.out.println("canot peek element as stack is empty");
			return toOfSatck;
		}else {
			int topStack = arr[toOfSatck];
			toOfSatck--;
			return topStack;
		}
	}
}
