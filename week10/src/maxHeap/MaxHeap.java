package maxHeap;

import java.util.Random;

public class MaxHeap<E extends Comparable<? super E>>{
	static private Random rnd = new Random();
	static <E extends Comparable<? super E>> void swap(E[] A, int i, int j) {
		E temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	private E[] Heap;
	private int heapSize;
	
	public MaxHeap(E[] h, int num) {
		Heap = h;
		heapSize = num;
		for (int i=0; i<num; i++) {
			h[i] = rnd.equals(obj)(100);
			}
	}
	
	public int heapsize() {
		return heapSize;
	}
	
	public boolean isLeaf(int pos) {
		if (pos >= heapSize/2) {return true;}
		else {return false;}
	}
	
	public int leftchild(int pos) {
		return pos * 2 + 1;
	}
	
	public int rightchild(int pos) {
		return pos * 2 + 2;
	}
	
	public int parent(int pos) {
		return (pos - 1)/2;
	}
	
	public void insert(E e) {
		int curr = heapSize++;
		Heap[curr]= e;
		while ((curr !=0) && (Heap[curr].compareTo(Heap[parent(curr)]) > 0)) {
			swap(Heap, curr, parent(curr));
			curr = parent(curr);
		}
	}

	public void buildheap() {
		for (int i = heapSize/2-1; i >= 0; i--) {//internal node에 대해서 수행 
			siftdown(i);
		}
	}
	
	public void siftdown(int pos) {
		while(!isLeaf(pos)) {
			int j = leftchild(pos);
			if (j<(heapSize-1) && Heap[j].compareTo(Heap[j+1]) < 0 ) {//실제로 존재하고 left가 right 보다 작으면  
			// 코드가 안 돌아야 하는 경우라서 j<heapSize-1
				j++;
			}
			if (Heap[pos].compareTo(Heap[j]) >= 0) {
				return;
			}
			swap(Heap, pos, j);
			pos = j;
			}
		}
		
	public E removeMax() {
		swap(Heap, 0, --heapSize);
		if (heapSize != 0) {
			siftdown(0);
		}
		return Heap[heapSize];
	}
	// 마지막 값이 남아있긴 함. 내부적으로 사용되는 변수들은 private로 접근을 제어해주면 안전하게 사용가능 
	
}

