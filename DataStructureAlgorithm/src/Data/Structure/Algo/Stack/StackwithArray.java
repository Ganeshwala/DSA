package Data.Structure.Algo.Stack;

public class StackwithArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new Stack(4);
		stack.push(1);
		stack.push(4);
		stack.push(8);
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		stack.push(3);
		System.out.println(stack.isEmpty());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.isEmpty());
		System.out.println(stack.isFull());
	}

}
