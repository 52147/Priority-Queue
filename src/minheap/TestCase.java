package minheap;

public class TestCase {
	
	public static void main(String[] args) {
		
		MinHeap minHeap = new MinHeap(3);
		
		minHeap.add(3);
		minHeap.add(1);
		minHeap.add(2);
		
		System.out.println(minHeap.toString()); // [1,3,2]
		
		System.out.println(minHeap.peek()); // 1
		
		System.out.println(minHeap.pop()); // 1
		
		System.out.println(minHeap.toString()); // [2,3]
		
		minHeap.add(4);
		
		minHeap.add(5); // Add to many elements
		
		System.out.println(minHeap.toString()); // [2,3,4] 
		
	}

}
