package graph_and_tree;

public class Stack {
	private int max;
	private int ptr;
	private int[] stk;
	
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException() {}
	}
	
	public class OverflowInStackException extends RuntimeException{
		public OverflowInStackException() {}
	}
	
	public Stack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max];
		}catch(OutOfMemoryError e){
			max = 0;
		}
	}
}
