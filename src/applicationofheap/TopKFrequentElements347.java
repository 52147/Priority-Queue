package applicationofheap;
/**
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
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * 
 *  = 347. Top K frequent elements =
 *  
 *  Approach 1: Heap
 *  
 *  - Let's start from the simple heap approach with O(N log k) time complexity.
 *  - To ensure that O(N log k) is always less than O(N log N),
 *    the particular case k = N could be considered separately and solved in O(N) time.
 *    
 *  Algorithm:
 *  
 *  1.
 *  - The first step is to build a hash map element -> its frequency.
 *  - In Java, we use the data structure HashMap.
 *  
 *  - Python provides dictionary subclass Counter to initialize the hash map we need directly from the input array.
 *  - This step takes O(N) time where N is a number of elements in the list.
 *  
 *  2. 
 *  - The second step is to build a heap of size k using N elements.
 *  - To add the first k elements takes a linear time O(k) in the average case,
 *    and O(log1 + log2 +...+ logk) = O(logk!) = O(k log k) in the worst case.
 *  - It's equivalent to heapify implementation in Python.
 *  
 *  - After the first k elements we start to push and pop at each step,
 *    N - k steps in total.
 *  - The time complexity of heap push/pop is O(log k) and we do it N - k times
 *    that means O((N - k) log k) time complexity.
 *  - Adding both parts up, we get O(N log k) time complexity for the second step.
 *  
 *  3. 
 *  - The third and the last step is to convert the heap into an output array.
 *  - That could be done in O(k log k) time.  
 *  
 *  
 *  In Python, library heapq provides a method nlargest, 
 *  which combined the last two steps under the hood and has the same O(N log k) time complexity.
 * 
 * 
 *  1. build hashmap "element --> its frequency"
 *  2. build heap of k most frequent elements
 *  3. build an output array
 *
 */
public class TopKFrequentElements347 {
	
	public int[] topKFrequent(int[] nums, int k) {
		
		// O(1) time
		if(k == nums.length) {
			return nums;
		}
		
		// 1. build hash map: character and how often it appears
		// O(N) time
		Map<Integer, Integer> count = new HashMap();
		for(int n: nums) {
			count.put(n, count.getOrDefault(n, 0) + 1);
			
		}
		
		// init heap 'the less frequent element first'
		Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));
		
		
		// 2. keep k top frequent elements in the heap
		// O(N log k) < O(N log N) time
		for(int n: count.keySet()) {
			heap.add(n);
			if(heap.size() > k) {
				heap.poll();
			}
		}
		
		// 3. build an output array
		// O(k log k) time
		int[] top = new int [k];
		
		
		// the frequencies is large to small order in the array
		for(int i = k - 1; i >= 0; --i) {
			top[i] = heap.poll();
			
		}
		
		return top;
		
		
		
		
	}

}
/**
 * Complexity analysis:
 * 
 *  - Time complexity: O(N log k)
 *    - if k < N and O(N) in the particular case of N = k.
 *    - That ensures time complexity to be better than O(N log N).
 *    
 *  - Space complexity: O(N + k)
 *    - to store the hash map with not more N elements and a heap with k elements.
 * 
 * 
 * 
 */






