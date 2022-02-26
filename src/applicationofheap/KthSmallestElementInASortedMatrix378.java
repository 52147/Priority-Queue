package applicationofheap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 378. Kth smallest element in a sorted matrix
 * 
 * Solution
 * Approach 1: Min-Heap approach
 * 
 * Intuition
 * 
 * - The intuition for this approach is really simple.
 * - If you think about it, we can reframe the problem as finding the Kth smallest elements from among N Sorted lists right?
 * - We know that the rows are sorted and so are the columns.
 * - So, we can treat each row (or column) as a sorted list in itself.
 * 
 * - Then the problem just boils down to finding the Kth smallest element from amongst these N sorted list in itself.
 * - However, before we get to this problem, let's first talk about a simpler version of the problem which is to find the Kth smallest element form amongst 2 sorted lists.
 * - This is easy enough to solve since all we need are a pair of pointers which act as indices in the two lists.
 * 
 * 
 * - At each step we check which element is smaller amongst the two being pointed at by the indices and progress the corresponding index accordingly.
 * - If you think about it, we just need to run the algorithm for merging two sorted lists without actually merging them.
 * - We need to keep on running this algorithm until we find our Kth element.
 * 
 * - Let's quickly look at how this would look like diagrammatically.
 * 
 * - We can use this two-pointer approach for finding the Kth element.
 * - As explained above, at each step we check the two values and move the pointer corresponding to the smaller value forward.
 * 
 * 
 * - Now that was simple enough to do.
 * - In this particular problem, we have N sorted lists instead of just 2.
 * - That's what adds to the complexity.
 * - We can't really keep N different pointers now, can we?
 * 
 * - The heap data structure is perfect for this problem since at all times,
 *   we want to maintain N different variables with each of them pointing to an element in their corresponding lists.
 * - We want to be able to find the minimum amongst these N pointers quickly 
 *   and then replace that element with the next one in its corresponding list.
 *   
 * - The heap data structure gives us O(1) access to the minimum element and log(N) removal of the minimum element and addition of a new one.
 * - We just need to perform this operation K times to get our Kth smallest number.
 * 
 * - It's is possible that our matrix has say 100 rows whereas we just need to find out the 5th smallest element.
 * - In this case, we can safely discard the rows in the lower part of the matrix 
 *   i.e. in this case starting from the 6th row to the end of the matrix because the columns are sorted as well.
 *   
 * - So, we need the min(N, K) rows essentially to find out the answer.
 * 
 * 
 * Algorithm:
 * 
 * 1. Initialize a min-heap called H.
 * 
 * 2. 
 * - For our implementation, we will be considering each row an individual list.
 * - Since the columns are sorted as well, we can easily treat each column as an individual list as well.
 * 
 * 3.
 * - As mentioned before, we will take the first element of min(N, K) rows where N represents the number of rows,
 *   and add each of thest element to the heap.
 * - It's important to know what row and column an element belongs to.
 * 
 * - Without knowing that, we won't be able to move forward in the particular list.
 * - So, apart from adding an element to the heap, we also need to add its row and column number.
 * - Hence, our min-heap will contain a triplet of information (value, row, column).
 * - The heap will be arranged on the basis of the values and
 *   we will use the row and column number to add a replacement for the next element in case it gets popped off the heap.
 *   
 * 4.
 * - At this point, our heap contains min(N, K) elements.
 * - Now we start a loop that goes until we iterate over K elements.
 * 
 *   
 * 5. 
 * - At each step, we remove the minimum element from the heap.
 * - The element will tell us which row should be further consumed.
 * - Using the row and column information we will add the next element to the heap.
 * - Specifically, if the current minimum element was from row r and had a column position c,
 *   then the next element to be added to the heap will be (r, c+1)
 * 
 * 6.
 * - Keep on iterating till we exhaust K elements.
 * - The last elemenmt to be popped at the end of the loop will be the Kth smallest element.
 * 
 *
 */

class MyHeapNode{
	
	int row;
	int column;
	int value;
	
	public MyHeapNode(int v, int r, int c) {
		this.value = v;
		this.row = r;
		this.column = c;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getColumn() {
		return this.column;
	}
}


class MyHeapComparator implements Comparator<MyHeapNode>{
	public int compare(MyHeapNode x, MyHeapNode y) {
		return x.value - y.value;
	}
}

public class KthSmallestElementInASortedMatrix378 {
	
	
	public int kthSmallest(int[][] matrix, int k) {
		
		int N = matrix.length;
		
		PriorityQueue<MyHeapNode> minHeap = new PriorityQueue<MyHeapNode>(Math.min(N, k), new MyHeapComparator());
		
		// preparing our min-heap
		for(int r = 0; r < Math.min(N, k); r++) {
			
			// We add triplets of information for each cell
			minHeap.offer(new MyHeapNode(matrix[r][0], r, 0));
		}
		
		MyHeapNode element = minHeap.peek();
		
		while(k-- > 0) {
			
			// Extract-Min
			element = minHeap.poll();
			
			int r = element.getRow(), c = element.getColumn();
			
			// If we have ant new elements in the current row, add them
			if(c < N -1) {
				minHeap.offer(new MyHeapNode(matrix[r][c + 1], r, c+1));
			}
			
		}
		
		return element.getValue();
		
		
	}
	
	

}
