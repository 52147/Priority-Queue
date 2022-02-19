package applicationofheap;

import java.util.PriorityQueue;

/**
 * = Application of Heap =
 * 
 * - Heap is a commonly used data structure in computer science.
 * - In this chapter, we will cover several applications of Heap.
 * 
 *   - 1. Heap Sort
 *   - 2. The Top-K problem
 *   - 3. The K-th element
 * 
 * = 1. Heap Sort = 
 * 
 * MinHeap:
 * 
 * - Heap Sort sorts a group of unordered elements using the Heap data structure.
 * 
 * - The sorting algorithm using a Min Heap is as follow:
 * 
 *   - 1. Heapify all elements into a Min Heap.
 *   - 2. Record and delete the top elements.
 *   - 3. Put the top element into an array T that stores all sorted elements.
 *        Now, the Heap will remain a Min Heap.
 *   - 4. Repeat step 2 and 3 until the Heap is empty.
 *        The array T will contain all elements sorted in ascending order.
 * 
 * Max Heap:
 * 
 * - The sorting algorithm using a Max Heap is as follow:
 * 
 *   - 1. Heapify all elements into a Max Heap.
 *   - 2. Record and delete the top element.
 *   - 3. Put the top element into an array T that stores all sorted elements.
 *        Now, the Heap will remain a Max Heap.
 *   - 4. Repeat steps 2 and 3 until the Heap is empty.
 *        The array T will contain all elements sorted in descending order.
 *      
 * Complexity Analysis:
 * 
 * - Let N be the total number of elements.
 * - Time complexity: O(N log N)
 * - Space complexity: O(N)
 * 
 * Heap sort
 * - Using a heap to obtain a sorted array involves converting the unsorted array into a heap,
 *   then popping the elements from the heap one at a time and adding them to the new sorted array.
 * - Min Heap: obtain an array sorted in ascending order.
 * - Max Heap: obtain an array sorted in descending order.
 * 
 *   
 * = 2. The top K problem =
 * 
 * - Use the Heap data structure to obtain top K's largest or smallest elements.
 * 
 * - Solution of the Top K largest elements:
 *   - 1. Construct a Max Heap.
 *   - 2. Add all elements into the Max Heap.
 *   - 3. Traversing and deleting the top element(using pop() or poll() for instance)
 *        , and store the value into the result array T.
 *   - 4. Repeat step 3 until we have remove the K largest elements.
 *   
 * - Solution of the Top K smallest elements: 
 *   - 1. Construct a Min Heap.
 *   - 2. Add all elements into the Min Heap
 *   - 3. Traversing and deleting the top element(using pop() or poll for instance),
 *        and store the value into the result array T.
 *   - 4. Repeat step 3 until we have removed the K smallest elements.
 * 
 * Complexity analysis:
 * 
 * - Time complexity: O(K log N + N)
 *   - Steps one and two require us to construct a Max Heap which requires O(N) time using the previously discussed heapify method.
 *   - Each element removed from the heap requires O(log N) time;
 *     the process is repeated K times.
 *   - Thus the total time complexity is O(K log N + N)
 * 
 * - Space complexity: O(N)
 *   - After step 2, the heap will store all N elements.
 *   
 * = The Top K problem - Approach 2 =
 * 
 * - Use the Heap data structure to obtain Top K's largest or smallest elements.
 * 
 * - 1. Solution of the Top K largest elements:
 * 
 *   - 1. Construct a Min Heap with size K.
 *   - 2. Add elements to the Min Heap one by one.
 *   - 3. When there are K elements in the "Min Heap",
 *        compare the current element with the top element of the Heap.
 *   - 4. If the current element is larger than the Heap's top element,
 *        drop it and - proceed to the next element.
 *   - 5. If the current element is larger than the Heap's top element,
 *        delete the Heap's top element, 
 *        and add the current element to the Min Heap.
 *   - 6. Repeat Step 2 and 3 until all elements have been iterated.
 *   
 * - Now the K elements in the Min Heap are the K largest elements.
 *             
 * - 2. Solution of the top K smallest elements:
 * 
 *   - 1. Construct a Max Heap with size K.
 *   - 2. Add elements to the Max Heap one by one.
 *   - 3. When there are K elements in the "Max Heap",
 *        compare the current element with the top element of the Heap
 *   - 4. If the current element is no smaller than the top element of the Heap,
 *        drop it and proceed to the next element.
 *   - 5. If the current element is smaller than the top element of the Heap,
 *        delete the top element of the Heap, 
 *        and add the current element to the Max Heap.
 *   - 6. Repeat Steps 2 and 3 until all elements have been iterated.
 *   
 * - Now the K elements in the Max Heap are the K smallest elements.
 * 
 * Complexity Analysis:
 * 
 * - Time complexity: O(N log K)
 *   - Steps one and two will require O(K log K) time if the elements are added one by one to the heap,
 *     however using the heapify method, these two steps could be accomplished in O(K) time.
 *     
 *   - Step 3 and 4 will require O(log K) time each time an element must be replaced in the heap.
 *   - In the worst-case scenario, this will be done N-K times.
 *   - Thus the total time complexity is O((N-K)log K + K log K) which simplifies to O(N log K).
 *   
 * - Space complexity: O(K)
 * 
 *   - The heap will contain at most K elements at any given time.
 *   
 *   
 *   
 * = 3. The K-th element =
 * 
 * 1. The K-th element - Approach 1
 * 
 * - Use the Heap data structure to obtain the Kth largest or smallest element.
 * 
 * - Solution of the K-th largest element:
 *   - 1. Construct a Max Heap.
 *   - 2. Add all elements into the Max Heap.
 *   - 3. Traversing and deleting the top element (using pop() or poll() for instance)
 *   - 4. Repeat Step 3 K times until we find the K-th largest element.
 *   
 * Solution of the K-th smallest element:
 *   - 1. Construct a Min Heap.
 *   - 2. Add all elements into the Min Heap.
 *   - 3. Traversing and deleting the top element (using pop() or poll() for instance)
 *   - 4. Repeat Step 3 K times until we find the K-th smallest element.
 *    
 * Complexity analysis:
 * 
 * - Let N be the total number of elements.
 * 
 * - Time complexity: O(K log N + N)
 * 
 *   - Steps one and two requires us to construct a Max Heap which requires O(N) time using the previously discussed heapify method.
 *   - Each element removed from the heap requires O(log N) time;
 *     this process is repeated K times.
 *   - Thus the total time complexity is O(K log N + N)
 * 
 * - Space complexity: O(N)
 *   - After step 2, the heap will store all N elements.
 *   
 * 2. The K-th element - Approach 2
 * 
 * - Use the Heap data structure to obtain the K-th largest or smallest element.
 * 
 * - Solution of the K-th largest element:
 * 
 *   - 1. Construct a Min Heap with size K.
 *   - 2. Add elements to the Min Heap one by one.
 *   - 3. When there are K elements in the "Min Heap",
 *        compare the current element with the top element of the Heap:
 *        
 *        - If the current element is not larger than the top element of the Heap,
 *          drop it and proceed to the next element.
 *        - If the current element is larger than the Heap's top element,
 *          delete the Heap's top element, and add the current element to the "Min Heap".
 *   
 *   - 4. Repeat Step 2 and 3 until all elements have been iterated.       
 *   
 *   - Now the top element in the Min Heap is the K-th largest element.
 *   
 *   
 * - Solution of the K-th smallest element:
 * 
 *   - 1. Construct a Max Heap with size K
 *   - 2. Add elements to the Max Heap one by one.
 *   - 3. When there are K elements in the Max Heap, compare the current element with the top element of the Heap:
 *       
 *       - If the current element is not smaller than the top element of the Heap,
 *         drop it and proceed to the next element.
 *       - If the current element is smaller than the top element of the Heap,
 *         delete the top element of the Heap, and add the current element to the Max Heap.
 *         
 *    - 4. Repeat Step 2 and 3 until all elements have been iterated.
 *       
 * - Now the top element in the Max Heap is the K smallest element.
 * 
 * 
 * Complexity analysis:
 * 
 * - Time complexity: O(N log K)
 *   - Steps one and two will require O(K log K) time if the elements are added one by one to the heap,
 *     however using the heapify method,
 *     these two steps could be accomplished in O(K) time.
 *   
 *   - Step 3 and 4 will require O(log K) time each time an element must be replaced in the heap.
 *   - In the worst scenario, this will be done N-K times.
 *   - Thus the total time complexity is O((N-K) log K + K log K) which simplifies to O(N log K).
 *   
 * - Space complexity: O(K)
 *   - The heap will contain at most K elements at any given time.   
 * 
 */


/**
 * 215. Kth largest element in an array 
 * 
 * The top K problem approach 2
 * 
 * Approach 1: Heap
 * 
 * - This idea is to init a heap "the smallest element first",
 *   and add all elements from teh array into this heap one by one keeping the size of the heap always less or equal to k.
 * - That would results in a heap containing k largest elements of the array.
 * 
 * - The head of this heap is the answer, i.e. the k-th largest element of the array.
 * 
 * - The time complexity of adding an element in a heap of size k is O(log k),
 *   and we do it N times that means O(N log k) time complexity for the algorithm.
 *   
 * - This algorithm improves time complexity, but one pays with O(k) complexity.
 * 
 *
 */

public class KthLargestElementInAnArray215 {
	
	public int findKthLargest(int[] nums, int k) {
		
		
		// use K-the element problem approach 2
		
		// init heap "the smallest element first"
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2); // ascending order // The constructor accepts a Comparator<? super E> comparator
		// n1.compareTo(n2)
		// n1 - n2
		// result is negative -> n1 is smaller
		// result is 0        -> n1 and n2 are the same
		// result is positive -> n1 is greater
		
		// descending order: (a, b) -> b - a
		
		// keep k largest elements in the heap
		for(int n: nums) {
			heap.add(n);
			
			if(heap.size() > k) { // if the element in the minHeap is larger than k, we poll the first element
				heap.poll(); // keep the min heap size as k elements
			}
			
			
		}
		
		// when this for loop is done(the all element is add in the heap), now the heap has the top k largest elements
		
		
		// output
		return heap.poll();  // we need to poll again to get the k-th largest element
		
	}

}

/**
 * Complexity analysis:
 * 
 * - Time complexity: O(N log k)
 * - Space complexity: O(k) to store the heap elements.
 */



