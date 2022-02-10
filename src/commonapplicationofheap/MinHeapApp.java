package commonapplicationofheap;

import java.util.PriorityQueue;

public class MinHeapApp {
	public static void main(String[] args) {
		
		// Construct an instance of Min Heap
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		// Add 3, 1, 2 respectively to the Min Heap
		minHeap.add(3);
		minHeap.add(1);
		minHeap.add(2);
		
		// Check all elements in the Min Heap, the result is [1, 3, 2]
		System.out.println("minHeap: " + minHeap.toString());
		
		// Get the top element of the Min Heap
		int peekNum = minHeap.peek();
		
		// The result is 1
		System.out.println("peek number: " + peekNum);
		
		// Delete the top element in the Min Heap
		int pollNum = minHeap.poll();
		
		// Check the top element after deleting 1, the result is 2
		System.out.println("peek number: " + minHeap.peek());
		
		// Check all elements in the Min Heap, the result is [2,3]
		System.out.println("minHeap: " + minHeap.toString());
		
		// Check the number of elements in the Min Heap
		// which is also the length of the Min Heap
		int heapSize = minHeap.size();
		
		// The result is 2
		System.out.println("minHeap size: " + heapSize);
		
		// Check if the Min Heap is empty
		boolean isEmpty = minHeap.isEmpty(); // return size() == 0;
		
		// The result is false
		System.out.println("isEmpty: " + isEmpty);
	}

}
