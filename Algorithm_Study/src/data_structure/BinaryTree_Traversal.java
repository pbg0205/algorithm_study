package data_structure;

public class BinaryTree_Traversal {
// #BinaryTree : 자식 노드를 최대 2개까지만 가질 수 있는 트리구조.
// 트리의 데이터를 가지고 오는 방법
// 1. inOrder : left -> root -> right
//			1
//		   / \
//		  2   3
//		 / \
//      4	5
//--------------------------> 1 2 4 5 3
	
// 2. preOrder : root -> left -> right
//--------------------------> 1 2 4 5 3

// 3. postOrder : left -> right -> root
//--------------------------> 4 5 2 3 1

	public static void main(String[] args) {
		Tree t = new Tree();
		Node n4 = t.makeNode(null,  4,  null);
		Node n5 = t.makeNode(null,  5,  null);
		Node n2 = t.makeNode(n4,  2,  n5);
		Node n3 = t.makeNode(null, 3, null);
		Node n1 = t.makeNode(n2,  1,  n3);
		t.setRoot(n1);
		//t.inOrder(t.getRoot());
		//t.preOrder(t.getRoot());
		t.postOrder(t.getRoot());
	}
}

class Node{
	int data;
	Node left;
	Node right;
}

class Tree{
	public Node root;
	
	public void setRoot(Node node) {
		this.root = node;
	}
	
	public Node getRoot() {
		return root;
	}
	public Node makeNode(Node left, int data, Node right) {
		Node node = new Node();
		node.data = data;
		node.left = left;
		node.right = right;
		
		return node;
	}
	
	public void inOrder(Node node) {
		if(node != null) {
			inOrder(node.left);
			System.out.println(node.data);
			inOrder(node.right);
		}
	}
	
	public void preOrder(Node node) {
		if(node != null) {
			System.out.println(node.data);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public void postOrder(Node node) {
		if(node != null) {
			preOrder(node.left);
			preOrder(node.right);
			System.out.println(node.data);
		}
	}
}
