package applicationofheap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * 
 * = 253. Meeting Rooms 2 =
 * 
 * Approach 1: Priority Queues
 * 
 * - We can't really process the given meetings in any random order.
 * - The most basic way of processing the meetings is in increasing order of their start times and this is the order we will follow.
 * - After all, it makes sense to allocate a room to the meeting that is scheduled for 9 a.m. in the morning 
 *   before you worry about the 5 p.m. meeting, right?
 *   
 * - Let's do a dry run of an example problem with sample meeting times 
 *   and see what our algorithm should be able to do efficiently.
 *   
 * - We will consider the following meeting times for our example
 *   (1, 10), (2, 7), (3, 19), (8, 12), (10, 20), (11, 30).
 *   
 *   - The first part of the tuple is the start time for the meeting and the second value represents the ending time.
 *   - We are considering the meetings in a sorted order of their start times.
 *   - The first diagram depicts the first three meetings where each of then requires a new room because of collisions.
 *   - The next three meetings start to occupy some of the existing rooms.
 *   - However, the last one requires a new room altogether and overall
 *     we have to use 4 different rooms to accommodate all the meetings.
 *     
 *   
 * - Sorting part is easy, but for every meeting how do we find out efficiently if a room is available or not?
 * - At any point in time we have multiple rooms that can be occupied 
 *   and we don't really care which room is free as long as we find one when required for a new meeting.
 *   
 * - A naive way to check if a room is available or not is to iterate on all the rooms and
 *   seen if one is available when we have a new meeting at hand.
 * 
 * - However, we can do better than this by making use of Priority Queues or the Min-Heap data structure.
 * 
 * - Instead of manually iterating on every room that's been allocated and
 *   checking if the room is available or not,
 *   
 * - So, every time we want to check if any room is free or not, simply check the topmost element of the min heap as that 
 *   would be the room that would get free the earliest out of all the other rooms currently occupied.
 *   
 * - If the room we extracted from the top of the min heap isn't free,
 *   then no other room is.
 * - So, we can save time here and simply allocate a new room.
 * 
 * - Let us lookk at the algorithm before moving onto the implementation.
 * 
 * Algorithm:
 * 
 *  - 1.
 *    - Sort the given meetings by their start time.
 *  - 2.
 *    - Initialize a new min-heap and add the first meeting's ending time to the heap.
 *  - 3.
 *    - For every meeting room check if the minimum element of the heap
 *      i.e. the room at the top of the heap is free or not.
 *  - 4.
 *    - If the room is free, then we extract the topmost element and
 *      add it back with the ending time of the current meeting we are processing.
 *  - 5. 
 *    - If not, then we allocate a new room and add it to the heap.
 *  - 6. 
 *    - After processing all the meetings, 
 *      the size of the heap will tell us the number of rooms allocated.
 *    - This will be the minimum number of rooms needed to accommofate all the meetings.
 *        
 *     
 *   
 *  
 *    
 *   
 *   - 
 *
 */



public class MeetingRooms253 {
	
	
	public int minMeetingRooms(int[][] intervals) {
		
		// Check for the base case. If there are no intervals, return 0.
		if(intervals.length == 0) {
			return 0;
		}
		
		// Min Heap
		// Initial the priority queue capacity with interval length
		// and a comparator instance with the parameter a, b
		PriorityQueue<Integer> allocator = 
				new PriorityQueue<Integer>(
						intervals.length, new Comparator<Integer>() {
					public int compare(Integer a, Integer b) {return a-b;}
				} );
		
		
		// Sort the intervals by start time
		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(final int[] a, final int[] b) {
				return a[0] - b[0];
			}
		});
		
		// Add the first meeting
		allocator.add(intervals[0][1]);
		
		// Iterate over remaining intervals
		for(int i = 1; i< intervals.length; i++) {
			
			// If the room due to free up the earliest is free, assign the room to this meeting.
			if(intervals[i][0] >= allocator.peek()) {
				allocator.poll();
			}
			
			// If a new room is to be assigned, then also we add to the heap,
			// If an old room is allocated, then also we have to add to the heap with updated end time.
			allocator.add(intervals[i][1]);
			
		}
		
		// The size of the heap tells us the minimum rooms required for all the meetings.
		return allocator.size();
		
	}
	
	
	

}

/**
 * Complexity analysis:
 * 
 * - Time complexity: O(N log N)
 * 
 *   - There are two major portions that take up time here.
 *   - One is sorting of the array that takes O(N log N)
 *     considering that the array consists of N elements.
 *   
 *   - Then we have the min-heap.
 *   - In the worst case, all N meetings will collide with each other.
 *   - In any case we have N add operations on the heap.
 *   
 *   - In the worst case we will have N extract-min operations as well.
 *   - Overall complexity being (N log N) since extract-min operation on a heap takes O(log N).
 *   
 * - Space complexity:
 *   
 *   - O(N) because we construct the min-heap and that can contain N elements in the worst case as described above in the time complexity section.
 *   - Hence, the space complexity is O(N).
 *   
 *   
 */



