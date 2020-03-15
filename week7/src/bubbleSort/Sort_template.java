package bubbleSort;

import java.util.Random;

public class Sort_template {
	static private Random rnd = new Random();
	static <E extends Comparable<? super E>> void swap(E[] A, int i, int j) {
		E temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	static <E extends Comparable<? super E>> void Sort(E[] A) {
		for (int i= 0 ; i < A.length-1; i++) {
			for (int j= A.length-1; j>i; j--) {
			// 페이지마다 변하는 것은 A.length에서 하나씩 줄어든다는 것
				if (A[j-1].compareTo (A[j]) > 0) {
					swap (A, j-1, j);
				}
			}
		}
	}

	public static void main(String[] args) {
		// set parameter
		int size = 20;

		// Generate Random Data
		Integer[] A = new Integer[size];
		for (int i=0; i<size; i++)
			A[i] = rnd.nextInt(100);

		// print before
		for (int j=0; j<size; j++) {
			System.out.print(A[j] + " ");			
		}
		System.out.println("");

		// Sort
		Sort(A);

		// print after
		for (int j=0; j<size; j++) {
			System.out.print(A[j] + " ");			
		}
		System.out.println("");

		// validate
		for (int i=1; i<size; i++) {
			if (A[i-1].compareTo(A[i]) > 0) {
				System.out.println("ERROR!");
				break;
			}
		}
	}
}

