package Data.Structure.Algo.Tree;

public class BinaryHeap {
	int arr[];
	int sizeOfTree;
	
	public BinaryHeap(int size) {
		arr = new int[size+1];
		this.sizeOfTree = 0;
	}
	
	public boolean isEmpty() {
		if(sizeOfTree==0) {
			return true;
		}
		return false;
	}
	
	public Integer peek() {
		if(isEmpty()) {
			System.out.println("Binary Heap Tree is empty");
			return null;
		}
		return arr[1];
	}
	
	//Heapify for Insert
	public void heapifyBottomToTop(int index,String heapType) {
		if(index <= 1) {
			return;
		}
		int parent = index/2;
		if(heapType == "Min") {
			if(arr[index] < arr[parent]) {
				int temp = arr[index];
				arr[index] = arr[parent];
				arr[parent] = temp;
			}
		}
		else if(heapType == "Max") {
			if(arr[index] > arr[parent]) {
				int temp = arr[parent];
				arr[index] = arr[parent];
				arr[parent] = temp;
			}
		}
		heapifyBottomToTop(parent, heapType);
	}
	
	public void insert(int value,String typeHeap) {
		arr[sizeOfTree+1] = value;
		sizeOfTree++;
		heapifyBottomToTop(sizeOfTree, typeHeap);
		System.out.println("insert " +value+" successfully in heap");
	}
	
	public void heapifyTopToBottom(int index,String heapType) {
		int left = 2*index;
		int right = index*2+1;
		int swapChild = 0;
		if(sizeOfTree <left) {
			return;
		}
		if(heapType == "Max") {
			if(sizeOfTree == left) {
				if(arr[index] < arr[left]) {
					int temp = arr[index];
					arr[index] = arr[left];
					arr[left] = temp;
				}
				return;
			}else{
				if(arr[left]>arr[right]) {
					swapChild = left;
				}else {
					swapChild = right;
				}
				if(arr[index] < arr[swapChild]) {
					int temp = arr[index];
					arr[index] = arr[swapChild];
					arr[swapChild] = temp;
				}
				
			}
		}
		heapifyTopToBottom(swapChild,heapType);
	}
	
	public int extractHeapOfHeap(String heapType) {
		if(isEmpty()) {
			return -1;
		}else {
			int extractedValued = arr[1];
			arr[1] = arr[sizeOfTree];
			sizeOfTree-- ;
			heapifyTopToBottom(1,heapType);
			return extractedValued;
		}
	}
	
}
