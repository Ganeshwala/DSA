package Data.Structure.Algo.LinkedList.SingleLinkedList;

public class TestRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 9999999+9999;
		System.out.println(sum);
		while(sum >= 10) {
			int ans = sum % 10;
			sum = sum / 10;
			System.out.println(ans+"------"+sum);
		}
		System.out.println("------"+sum);
		
	}

}
