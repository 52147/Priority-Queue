package commonapplicationofheap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeapApp {

	public static void main(String[] args) {
		
		// Construct an instance of Max Heap
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> maxHeap2 = new PriorityQueue<>((a, b) -> b - a); // descending order
		PriorityQueue<Integer> maxHeap3 = new PriorityQueue<>((a, b) -> b.compareTo(a));
		
		// Add 1, 3, 2 respectively to the Max Heap
		maxHeap.add(1);
		maxHeap.add(3);
		maxHeap.add(2);
		
		
		// Check all elements in the Max Heap, the result is [3, 1, 2]
		System.out.println("maxHeap: " + maxHeap.toString());
		
		// Get the top element of the Max Heap
		int peekNum = maxHeap.peek();
		
		// The result is 3
		System.out.println("peek number: " + peekNum);
		
		// Delete the top element in the Max Heap
		int pollNum = maxHeap.poll();
		
		// The result is 3
		System.out.println("poll number: " + pollNum);
		
		// Check the top element after deleting 3, the result is 2
		System.out.println("peek number: " + maxHeap.peek());
		
		// Check all elements in the Max Heap, the result is [2,1]
		System.out.println("maxHeap: " + maxHeap.toString());
		
		// Check the number of elements in the Max Heap
		// which is also the length of the Max Heap
		int heapSize = maxHeap.size();
		
		// The result is 2
		System.out.println("maxHeap: " + heapSize);
		
		// Check if the Max Heap is empty
		boolean isEmpty = maxHeap.isEmpty();
		
		// The result is false
		System.out.println("isEmpty: " + isEmpty);

	}

}
