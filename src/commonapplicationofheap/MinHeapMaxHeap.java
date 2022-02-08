package commonapplicationofheap;

// In Java, a Heap is represented by a Priority Queue
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Arrays;

/**
 * = Construct a Heap =
 * 
 * - Constructing a heap means initializing an instance of a heap.
 * - All methods of Heap need to be performed on an instance.
 * - Therefore, we need to initialize an instance before applying the methods.
 * 
 * - When creating a Heap, we can simultaneously perform the heapify operation.
 * - Heapify means converting a group of data into a Heap.
 * 
 * Time complexity: O(N)
 * Space complexity: O(N)
 * 
 * 
 * = Inserting an Element =
 * 
 * - Insertion means inserting a new element into the Heap.
 * - Note that, after the new element is inserted, properties of the Heap are still maintained.
 * 
 * - Time complexity: O(log N)
 * - Space complexity: O(1)
 * 
 * 
 * = Getting the top element of the heap =
 * 
 * - The top element of a Max heap is the maximum value in the heap,
 *   while the top element of a Min Heap is the smallest value in the Heap.
 * 
 * - The top element of the Heap is the most important element in the Heap.
 * 
 * - Time complexity: O(1)
 * - Space complexity: O(1)
 * 
 * 
 * = Deleting the top element = 
 * 
 * - Note that, after deleting the top element, the properties of the Heap will still hold.
 * - Therefore, the new top element in the Heap will be the maximum(for Max Heap)
 *   or minimum(for Min Heap) of the current Heap.
 *   
 * - Time complexity: O(log N)
 * - Space complexity: O(1)
 * 
 * 
 * = Getting the length of a Heap = 
 * 
 * - The length of the Heap can be used determine the size of the current heap,
 *   and it can also be used to determine if the current Heap is empty.
 *   
 * - If there are no elements in the current Heap, the length of the Heap is zero.
 * 
 * - Time complexity: O(1)
 * - Space complexity: O(1)
 * 
 * = Space and Time complexity =
 * 
 * Heap method                Time complexity            Space complexity
 * 
 * Construct a Heap           O(N)                       O(N)
 * Insert an element          O(log N)                   O(1)
 * Get the top element        O(1)                       O(1)
 * Delete the top element     O(log N)                   O(1)
 * Get the size of a Heap     O(1)                       O(1)
 * 
 * N is the number of elements in the heap.
 * 
 * 
 * 
 * 
 * 
 *
 */



public class MinHeapMaxHeap {

	public static void main(String[] args) {
		
		// Construct an empty Min Heap
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		// Construct an empty Max Heap
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		// Construct a Heap with initial elements.
		// This process is named "Heapify"
		// The Heap is a Min Heap
		PriorityQueue<Integer> heapWithValues = new PriorityQueue<>(Arrays.asList(3, 1, 2));
		
		
		// Insert an element to the Min Heap
		minHeap.add(5);
		
		// Insert an element to the Max Heap
		maxHeap.add(5);
		
		// Get top element from the Min Heap
		// i.e. the smallest element
		minHeap.peek();
		
		// Get top element from the Max Heap
		// i.e. the largest element
		maxHeap.peek();
		
		// Delete top element from the Min Heap
		minHeap.poll();
		
		// Delete top element form the Max Heap
		maxHeap.poll();
		
		
		// Length of the Min Heap
		minHeap.size();
		
		// Length of the Max Heap
		maxHeap.size();
		
		// Note, in Java, apart from checking if the length of the Heap is 0, we can also use isEmpty()
		// If there are no elements in the Heap, isEmpty() will return true;
		// If there are still elements in the Heap, isEmpty() will return false;
		

	}

}
