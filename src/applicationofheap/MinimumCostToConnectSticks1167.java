package applicationofheap;

import java.util.PriorityQueue;

/**
 * 
 * = 1167. Minimum cost to connect sticks =
 * 
 * 
 * Approach 1: Greedy
 * 
 * - Always pick two of the smallest sticks to connect 
 *   and continue doing this until you get only one stick.
 *   
 *   Let's see why this work.
 *   
 * - Consider 4 sticks of the following lengths:
 * 
 *   sticks = [a1, a2, a3, a4]
 * 
 * - Let's try to connect them left to right.
 * 
 * - After first merge, we will have:
 * 
 *   sticks = [(a1 + a2), a3, a4]
 *   cost = (a1 + a2)
 *   
 * - After second merge, we will have:
 * 
 *   sticks = [(a1 + a2 + a3), a4]
 *   cost = (a1 + a2) + (a1 + a2 + a3)
 *   
 * - And finally, last stick will look like:
 * 
 *   sticks = [(a1 + a2 + a3 +a4)]
 *   cost = (a1 + a2) + (a1 + a2 + a3) + (a1 + a2 + a3 + a4)
 *   
 * - The final cost can be re-written as:
 *   
 *   cost = (3a1 + 3a2 + 2a3 + a4)
 *   
 * - As we can see, the stick which are connected first are included in the final cost more than the ones that are picked later.
 * - Hence, it is optimal to perform following tasks:
 * 
 *    
 * - Let's try to figure out which data structure will be optimal to perform following tasks:
 *  
 *   - Get two of the smallest sticks (stick1 and stick2) from the array.
 *   - Add one stick (stick1 + stick2) back to array.
 *     
 * - We can use a min heap data structure
 *   (which is, generally, implemented as a PriorityQueue in most language)
 *   which gives us O(log N) complexity for both the operations.
 *   
 * 
 *   
 * 
 * 
 *
 */
public class MinimumCostToConnectSticks1167 {
	
	
	public int connectSticks(int[] sticks) {
		int minTotalCost = 0;
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		// add all sticks to the min heap
		for(int stick: sticks) {
			pq.add(stick);
		}
		
		
		// combine two of the smallest stick until we are left with just one.
		while(pq.size() > 1) {
			int stick1 = pq.poll();
			int stick2 = pq.poll();
			
			int cost = stick1 + stick2;
			
			minTotalCost += cost;
			
			pq.add(cost);
		}
		
		
		return minTotalCost;
	}

}

/**
 * Complexity analysis:
 * 
 * - Time complexity: O(N log N), where N is the length of the input array.
 *   Let's break it down:
 *   
 *   - step 1:
 *     - Adding N elements to the priority queue will be O(N log N)
 *     
 *   - step 2:
 *     - We remove two of the smallest elements and then add one element to the priority queue
 *       until we are left with one element.
 *     - Since each such operation will reduce one element from the priority queue,
 *       we will perform N - 1 such operation.
 *     - Now, we know that both add and remove operations take O(log N) in priority queue, therefore,
 *       complexity of this step will be O(N log N)
 *       
 * - Space complexity: O(N) since we will store N elements in our priority queue. 
 * 
 * 
 */





