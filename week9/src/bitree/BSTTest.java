package bitree;

public class BSTTest {
	public static void main(String[] args) {
		BST<Integer> T1 = new BST<Integer>();
		
		T1.insert(10);
		T1.insert(30);
		T1.insert(50);
		T1.insert(0);
		T1.insert(90);
		T1.insert(20);
		
		T1.remove(30);
		
		System.out.print(T1.toString());
	}
}

