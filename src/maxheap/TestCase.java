package maxheap;

public class TestCase {

	public static void main(String[] args) {
		
		MaxHeap maxheap = new MaxHeap(5);
		
		maxheap.add(1);
		maxheap.add(2);
		maxheap.add(3);
		
		System.out.println(maxheap.toString()); // [3,1,2]
		
		System.out.println(maxheap.peek()); // 3
		
		System.out.println(maxheap.pop());
		System.out.println(maxheap.pop());
		System.out.println(maxheap.pop());
		
		// No element
		System.out.println(maxheap.toString());
		
		maxheap.add(4);
		maxheap.add(5);
		
		System.out.println(maxheap.toString()); // [4,1,2]


		

	}

}
