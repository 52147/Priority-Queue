package applicationofheap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * = 1046. Last Stone Weight =
 * 
 * Approach 3: Heap-Based Simulation
 * 
 * Intuition:
 * 
 * Algorithm:
 * 
 * - While most programming languages have a Heap/ Priority Queue data structure,
 *   some, such ad Python and Java, only have min-heap.
 * - Just as the name suggests, this is a heap that instead of always returning the maximum item,
 *   it returns the minimums.
 * - There are 2 solutions to this problem:
 * 
 *   - 1. Multiple all numbers going into the heap by -1,
 *        and then multiply them by -1 to restore them when they come out.
 *   - 2. Pass a comparator in (language-dependent).
 *   
 *   - In Python, we'll use the first solution, and in Java we'll use the second.
 *   
 *   
 *   
 * 
 * 
 * 
 *
 */

public class LastStoneWeight1046 {
	
	public int lastStoneWeight(int[] stones) {
	// Insert all the stones into a Max-Heap.
	PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
	
	for(int stone: stones) {
		heap.add(stone);
	}
	
	// While there is more than one stone left, we need to remove the 2 largest and smash them together.
	// If there is a resulting stone, we need to put into the heap.
	while(heap.size() > 1) {
		
		int stone1 = heap.poll();
		int stone2 = heap.poll();
		
		if(stone1 != stone2) {
			heap.add(stone1 - stone2);
		}
	}
	
	// Check whether or not there is a stone left to return.
	return heap.isEmpty() ? 0 : heap.remove();
	}

}


/**
 * Complexity analysis:
 * 
 * - Let N be the length of stones.
 * 
 *  - Time complexity: O(N log N)
 *  
 *    - Converting an array into a Heap takes O(N) time
 *      (it isn't actually sorting; it's putting them into an order that allows us to get the maximums,
 *       each in O(log N) time).
 *       
 *    - Like before, the main loop iterates up to N-1 times.
 *    - This time however, it's doing up to three O(log N) operation each time;
 *      two removes, and an optional add.
 *    - Like always, the three is an ignored constant.
 *    - This means that we're doing N*O(log N) = O(N log N) operations.
 *    
 *    
 *  - Space complexity: O(N) or O(log N)
 *  
 *     - In Python, converting a list to a heap is done in-place, requiring O(1) auxillary space,
 *       giving a total space complexity of O(1).
 *     - Modifying the input has its pros and cons it saves space,
 *       but it means that other functions can't use the same array.
 *       
 *     - In Java though, it's O(N) to create the PriorityQueue.
 *     
 *     - We could reduce the space complexity to O(1) by implementing our own iterative heapify, if needed.
 *       
 * 
 */
