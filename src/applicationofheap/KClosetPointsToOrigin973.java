package applicationofheap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * = Approach 2: Max Heap or Max priority Queue =
 * 
 * Intuition:
 * 
 * - While we must iterate over all elements in the points array,
 *   we only need to keep track of the k closet points encountered so far.
 * - We could therefore choose to store them in a separate data structure.
 * - In order to keep this data structure capped at k elements,
 *   we will need to keep track of the point that is farthest away from the origin
 *   and thus the next point to be removed when a closer point is found.
 *   
 * - The idea data structure for this purpose is a max heap or max priority queue.
 * - These data structure data structures allow access to the max value in constant time
 *   and time perform replacements in logarithmic time.
 *   
 * - Note: We can simulate max heap functionality in a min heap data structure by inserting
 *         -- dist instead of dist, if necessary.
 *         
 * - At the start of our iteration through points, 
 *   we will insert the first k elements into our heap.
 * - Once the heap is "full", we can then compare each new point to the farthest point stored in the heap.
 * - If the new pointer is closer, then we should remove the farthest point from the heap and insert the new point.
 * 
 * - After the entire points array has been processed,
 *   we can create an array from the points stored in the heap and then return the answer.
 *   
 *    
 * Algorithm:
 * 
 *  1. Use a max heap (or max priority queue) to store points by distance.
 *     - Store the first k elements in the heap.
 *     - Then only add new elements that are closer than the top point in the heap
 *       while removing the top point the top point to keep the heap at k elements.
 *       
 *  2. Return an array of the k points stored in the heap.
 *   
 *   
 *
 */

public class KClosetPointsToOrigin973 {
	
	public int[][] kClosest(int[][] points, int k){
		
		// Use a lambda comparator to sort the PQ by farthest distance
		Queue<int[]> maxPQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		
		for(int i = 0; i < points.length; i++) {
			int[] entry = {squaredDistance(points[i]), i};
			
			if(maxPQ.size() < k) {
				// Fill the max PQ up to k points
				maxPQ.add(entry);
			}else if(entry[0] < maxPQ.peek()[0]){
				// If the max PQ is full and a closer point is found, 
				// discard the farthest point and add this one
				maxPQ.poll();
				maxPQ.add(entry);
				
				
			}
			
		}
		
		// Return all points stored in the max PQ
		int[][] answer = new int[k][2];
		for(int i = 0; i < k; i++) {
			int entryIndex = maxPQ.poll()[1];
			answer[i] = points[entryIndex];
		}
		
		return answer;
	}
	
	
	private int squaredDistance(int[] point) {
		// Calculate and return the squared Eulidean distance
		return point[0] * point[0] + point[1] * point[1];
	}
	
	

}

/**
 * Complexity Analysis:
 * 
 * Here N refers to the length of the given array points.
 * 
 * - Time complexity: O(N * log k)
 *   - Adding to/removing from the heap(or priority queue) only takes O(log k) time
 *     when the size of the heap is capped at k elements.
 *     
 * - Space complexity: O(k)
 *   - The heap (or priority queue) will contain at most k elements.
 *   
 * 
 *     
 *     
 */




