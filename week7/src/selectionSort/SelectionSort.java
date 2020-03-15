package selectionSort;

import java.util.Random;

public class SelectionSort {
	static private Random rnd = new Random();
	static <E extends Comparable<? super E>> void swap(E[] A, int p1, int p2) {
		E temp = A[p1];
		A[p1] = A[p2];
		A[p2] = temp;
	}

	static <E extends Comparable<? super E>> void Sort(E[] A) {
		for (int i=0; i<A.length-1; i++) {
			int lowindex = i;
			for (int j=A.length-1; j>i; j--)
				if (A[j].compareTo(A[lowindex]) < 0)
					lowindex = j;
			swap(A, i, lowindex);
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
