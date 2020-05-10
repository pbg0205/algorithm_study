package data_structure;

import java.util.NoSuchElementException;

//Queue를 코드로 구현하시오.

/*
 * 1.FIFO 구조
 * 2. method
 * -add()
 * -remove()
 * -peek()
 * -isEmpty
*/


	class Queue<T> {
		class Node<T>{
			private T data;
			private Node<T> next;
			
			public Node(T data) {
				this.data = data;
			}//해당 데이터타입을 받아서 내부에 저장한다.
		}	
			private Node<T> first;
			private Node<T> last;
			
			public void add(T item) {
				Node<T> t = new Node<T>(item);
				
				if(last != null) {
					last.next = t;
				}
				last = t;
				if(first == null) {
					first = last;
				}
			}
			
			public T remove() {
				if(first == null) {
					throw new NoSuchElementException();
				}
				
				T data = first.data;
				first = first.next;
				
				if(first == null) {
					last = null;
				}
				return data;
			}
			
			public T peek() {
				if(first == null) {
					throw new NoSuchElementException();
				}
				return first.data;
			}
		
			public boolean isEmpty() {
				return first == null;
			}
		
	}	
	public class Test_Queue{
		public static void main(String[] args) {
			Queue<Integer> q = new Queue<Integer>();		
			
			q.add(1);
			q.add(2);
			q.add(3);
			q.add(4);
			
			System.out.println(q.remove());
			System.out.println(q.remove());
			System.out.println(q.peek());
			System.out.println(q.remove());
			System.out.println(q.isEmpty());
			System.out.println(q.remove());
		}

	}

