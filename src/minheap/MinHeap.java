package minheap;

/**
 * = Definition and Classification of Heap =
 * 
 * Priority Queues:
 * 
 * - Before introducing a Heap, let's first talk about a Priority Queue.
 * 
 * - a priority queue is an abstract data type(ADT) similar to a regular queue or stack data structure
 *   in which each element additionally has a "priority" associated with it.
 * 
 * - In a priority queue, an element with high priority is served before an element with low priority.
 * 
 * - In daily life, we would assign different priorities to tasks, start working on the task with the highest priority and then proceed to the task with the second highest priority.
 * - This is an example of a Priority Queue.
 *  
 * - A common misconception is that a Heap is the same as a Priority Queue, which is not true.
 * - A priority queue is an abstract data type, while a Heap is a data structure. 
 * - Therefore, a Heap is not a Priority Queue, but a way to implement a Priority Queue.
 * 
 * - There are multiple ways to implement a Priority Queue, such as array and linked list.
 * - However, these implementations only guarantee O(1) time complexity for either insertion or deletion,
 *   while the other operation will have a time complexity of O(N).
 *   
 * - On the other hand, implementing the priority queue with heap will allow both insertion and deletion to have a time complexity of O(log N).
 * 
 * - In this chapter, we will learn to:
 * 
 *   1. Understand the Heap data structure.
 *   2. Understand Max Heap and Min Heap.
 *   3. Understand the insertion and deletion of a Heap.
 *   4. Implement a Heap.
 *   
 *   
 * = Definition of Heap = 
 * 
 * - A heap is a special type of binary tree.
 * - A heap is a binary tree that meets the following criteria:
 * 
 *   - Is a complete binary tree.
 *   - The value of each node must be no greater than(or no less than) the value of its child nodes.
 *   
 * - A heap has the following properties:
 *   - 1. Insertion of an element into the Heap has a time complexity of O(log N)
 *   - 2. Deletion of an element from the Heap has a time complexity of O(log N)
 *   - 3. The maximum/minimum value in the Heap can be obtained with O(1) time complexity.
 *   
 * Classification of Heap:
 * - There are two kinds of heaps: Max Heap and Min Heap.  
 * 
 *    1. Max Heap:
 *       - Each node in the Heap has a value no less than its child nodes.
 *       - Therefore, the top element(root node) has the largest value in the Heap.
 *   
 *    2. Min Heap:
 *       - Each node in the Heap has a value no larger than its child nodes.
 *       - Therefore, the top element(root node) has the smallest value in the Heap.
 *       
 *         
 *         Min Heap:
 *         
 *                 
 *                      1    <-(top of the heap)
 *                      /\
 *                     2  3
 *                    /\  /\
 *                   4 5  6 7
 *                   
 *         Max Heap:
 *         
 *                 
 *                      9    <-(top of the heap)
 *                      /\
 *                     8  7
 *                    /\  /\
 *                   6 5  4 3
 *                   
 *                   
 */

/**
 *  = Implementation of a Heap =
 *  
 *  - We often perform insertion, deletion, and getting the top element with a Heap data structure.
 *  - We can implement a Heap using an array.
 *  - Elements in the Heap can be stored in the array in the form of a binary tree.
 *  
 *  - The code below with implement "Max Heap" and "Min Heap" for integer.  
 *
 */

// Implementing "Min Heap"
public class MinHeap {
	
	// create a complete binary tree using an array
	// Then use the binary tree to construct a Heap
	int[] minHeap;
	
	// the number of elements is need when instantiating an array
	// heapSize records the size of the array
	int heapSize;
	
	// realSize records the number of elements in the Heap
	int realSize = 0;
	
	public MinHeap(int heapSize) {
		this.heapSize = heapSize;
		minHeap = new int[heapSize + 1];
		
		// To better track the indices of the binary tree, 
		// we will not use the 0-th element in the array
		// You can fill it will any value
		minHeap[0] = 0;
	}
	
	// Function to add an element
	public void add(int element) {
		realSize++;
		
		// if the number of elements in the heap exceeds the preset heapSize
		// print "Added too many elements" and return
		if(realSize > heapSize) {
			System.out.println("Added too many elements!");
			realSize--;
			return;
		}
		
		// Add the element into the array;
		minHeap[realSize] = element;
		
		// index of the newly added element
		int index = realSize;
		
		/**
		 * Index of the newly added element:
		 * - Note if we use an array to represent the complete binary tree and store the root at index 1.
		 * 
		 * - index of the parent node of any node is[index of the node/2]
		 * - index of the left child node is [index of the node * 2]
		 * - index of the right child node is [index of the node * 2 +1]
		 */
		int parent = index/2;
		
		// if the newly added element is smaller than its parent node,
		// its value will be exchanged with that of the parent node
		while(minHeap[index] < minHeap[parent] && index > 1) {
			int temp = minHeap[index];
			minHeap[index] = minHeap[parent];
			minHeap[parent] = temp;
			index = parent;
			parent = index / 2;
		}
				
	}
	
	// Get the top element of the heap
	public int peek() {
		return minHeap[1];
	}
	
	
	// Delete the top element of the Heap
	public int pop() {
		// If the number of elements in the current Heap is 0,
		// print "Don't have any elements" and return a default value
		if(realSize<1) {
			System.out.println("Don't have any element!");
			return Integer.MAX_VALUE;
		}else {
			// When there are still elements in the Heap
			// realSize >= 1
			int removeElement = minHeap[1];
			
			// Put the last element in the Heap to the top of the Heap
			minHeap[1] = minHeap[realSize];
			
			realSize--;
			int index = 1;
			
			// when the delete element is not a leaf node
			while(index <= realSize/2) {
				// the left child of the deleted element
				int left = index * 2;
				
				// the right child of the deleted element
				int right = (index * 2) + 1;
				
				// If the deleted element is larger than the left or right child
				// its value needs to be changed with the smaller value of the left or right child
				if(minHeap[index] > minHeap[left] || minHeap[index] > minHeap[right]) {
					if(minHeap[left] < minHeap[right]) {
						int temp = minHeap[left];
						minHeap[left] = minHeap[index];
						minHeap[index] = temp;
						index = left;
					}else {
						// maxHeap[left] >= maxHeap[right]
						int tmp = minHeap[right];
						minHeap[right] = minHeap[index];
						minHeap[index] = tmp;
						index = right;
					}
				}else {
					break;
				}
			}
			return removeElement;
		}
	}
	
	// return the number of elements in the Heap
	public int size() {
		return realSize;
	}
	
	public String toString() {
		if(realSize == 0) {
			return "No element!";
		}else {
			StringBuilder sb = new StringBuilder();
			
			sb.append('[');
			
			for(int i = 1; i <= realSize; i++) {
				sb.append(minHeap[i]);
				sb.append(',');
			}
			
			sb.deleteCharAt(sb.length()-1);
			sb.append(']');
			
			return sb.toString();
		}
	}
	
	

}
