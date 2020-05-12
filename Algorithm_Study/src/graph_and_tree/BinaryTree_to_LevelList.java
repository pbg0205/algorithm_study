package graph_and_tree;

import java.util.ArrayList;
import java.util.LinkedList;


/*Tree 형태
				(4)
				/ \
			  (1)  (7)
			  / \  / \
		    (0)(2)(5)(8)
		   		 \  \  \
		   		 (3)(6)(9)
*/

public class BinaryTree_to_LevelList {
	public static void main(String[] args) {
		Tree2 t = new Tree2(10);
		t.printList(t.BSTtoList2());
	}
}

class Tree2{
	class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	Node root;
	Tree2(int size){
		root = makeBST(0, size - 1); //이진트리 만들기
	}
	Node makeBST(int start, int end) {
		if(start > end) return null;
		int mid = (start + end) /2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid - 1);
		node.right = makeBST(mid + 1, end);
		
		return node;
	}
	//solution1. 재귀호출로 함수의 인자로 받는 방법
	ArrayList<LinkedList<Node>>BSTtoList(){
		ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
		BSTtoList(root, lists, 0);
		
		return lists;
	}
	void BSTtoList(Node root, ArrayList<LinkedList<Node>> lists, int level) {
		 if(root == null)	return;
		 LinkedList<Node> list =  null;
		 if(lists.size() == level) {
			 list = new LinkedList<Node>();
			 lists.add(list);
		 }else {
			 list = lists.get(level);
		 }
		 list.add(root);
		 BSTtoList(root.left, lists, level + 1);
		 BSTtoList(root.right, lists, level + 1);
	}
	
	//solution2. BSF 변형하느 방법
	ArrayList<LinkedList<Node>> BSTtoList2(){
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		LinkedList<Node> current = new LinkedList<Node>();
		if(root != null) {
			current.add(root);
		}
		while(current.size() > 0) {
			result.add(current);
			LinkedList<Node> parents = current;
			current = new LinkedList<Node>();
			for(Node parent : parents) {
				if(parent.left != null)	current.add(parent.left);
				if(parent.right != null) current.add(parent.right);
			}
		}
		return result;
	}
	//결과 출력 함수
	void printList(ArrayList<LinkedList<Node>> arr) {
		for(LinkedList<Node> list : arr) {
			for(Node node : list) {
				System.out.print(node.data + " ");
			}
			System.out.println();
		}
	}
}
