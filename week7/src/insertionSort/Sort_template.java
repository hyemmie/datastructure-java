package insertionSort;

import java.util.Random;
import java.io.*;

public class Sort_template {
	static private Random rnd = new Random();
	static <E extends Comparable<? super E>> void swap(E[] A, int i, int j) {
		E temp = A[i];
		A[i] = A[j];
		A[j] = temp;

	}

	static <E extends Comparable<? super E>> void Sort(E[] A) {
		for (int i=1; i < A.length; i++) {
			for (int j=i-1; j>=0; j--) {
				if(A[j].compareTo (A[j+1]) > 0 ) {
					// 앞에 있는 요소가 더 크면 (1이 나오면) 수 
					swap (A, j, j+1);
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
				
//		BufferedWriter out = new BufferedWriter(new FileWriter(“out.csv”));
//		out.write(“a[]”); 
//		out.newLine();
//		out.close();
		
			}
		}
	}
}

