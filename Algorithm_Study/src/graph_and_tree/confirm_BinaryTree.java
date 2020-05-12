package graph_and_tree;

//주어진 함수가 이진검색 트리인지를 확인하는 함수구현
//이진트리는 항상 leftNode는 root보다 작은값을 가지고, rightNode는 root보다 큰값을 가진다.
//-> 해당 값이 순회가 inOrder(중위순회)와 일치한다.
//solution1:
//solution2:
//solution3:

/*
			(4)
			/ \
			(1)  (7)
			/ \  / \
			(0)(2)(5)(8)
				 \  \  \
				 (3)(6)(9)
*/

public class confirm_BinaryTree {
	public static void main(String[] args) {
		Tree3 t = new Tree3(10);
		System.out.println("Solutioni 1 - using inorder: " + t.isValidateBST1());
		System.out.println("Solution 2 - wwithout array: " + t.isValidateBST2());
		System.out.println("Solution 3 - min/max: " + t.isValidateBST3());
	}
}

class Tree3{
	class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	Node root;
	int size;
	Tree3(int size){
		this.size = size;
		root = makeBST(0, size - 1);
		//이진검색트리를 false인 상태일 때를 출력하는 경우
		//root.right.right.right.left = new Node(10);
		//this.size++;
	}
	Node makeBST(int start, int end) {
		if(start > end) return null;
		int mid = (start  + end) / 2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid - 1);
		node.right = makeBST(mid+1, end);
		return node;
	}
	
	boolean isValidateBST1() {
		int[] array = new int[size];
		inorder(root, array);
		for (int i = 1; i < array.length; i++) {
			if(array[i] < array[i - 1]) {
				return false;
			}
		}
		return true;
	}
	
	int index = 0;
	void inorder(Node root, int[] array) {
		if(root !=  null) {
			inorder(root.left, array);
			array[index] = root.data;
			index++;
			inorder(root.right, array);
		}
	}
	Integer last_printed = null;
	boolean isValidateBST2() {
		return isValidateBST2(root);
	}
	
	//solution2 : last_printed 변수를 생성해서 하는 방법(배열 메모리는 save가능)
	boolean isValidateBST2(Node n) {
		if(n == null)	return true;
		if(!isValidateBST2(n.left))	return false;
		if(last_printed != null && n.data < last_printed) {
			return false;
		}
		last_printed = n.data;
		if(!isValidateBST2(n.right))	return false;
		return true;
	}
	
	//solution : 값을 지정해서 해당 값이 가질 수 있는 node의 범위를 지정하는 역할
	//(left node이동 시, 값이 작아지고, right node이동 시, 값이 커지는 역할)
	boolean isValidateBST3() {
		return isValidateBST3(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	boolean isValidateBST3(Node n, int min, int max) {
		if(n == null) {
			return true;
		}
		if(n.data < min || n.data > max) {
			return false;
		}
		if(!isValidateBST3(n.left, min, n.data) || !isValidateBST3(n.right, n.data, max)) {
			return false;
		}
		return true;
	}
}