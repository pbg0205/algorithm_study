package graph_and_tree;
//정렬이 되어있고, 고유한 정수로만 이루어진 배열이 있다.
//이 배열로 이진검색트리를 구현하시오.
	
//정렬된 배열에서 pivot을 node로 해서 구현한다.
//배열 : 0	1	2	3	4	5	6	7	8	9
//시간복잡도 : O(log(n))

/*
				(4)
				/ \
			  (1)  (7)
			  / \  / \
		    (0)(2)(5)(8)
		   		 \  \  \
		   		 (3)(6)(9)
*/

public class binaryTree_by_array {
	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		
		Tree1 t = new Tree1();
		t.makeTree(a);
		t.searchBTree(t.root, 2);
	}
}

class Tree1{
	class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	Node root;
	public void makeTree(int[] a) {
		root = makeTreeR(a, 0, a.length - 1);
	}
	
	public Node makeTreeR(int[] a, int start, int end) {
		if(start > end) return null;
		int mid = (start + end) / 2;//중간 pivot 구하기
		Node node = new Node(a[mid]);
		node.left = makeTreeR(a, start, mid - 1);
		node.right = makeTreeR(a, mid + 1, end);
		
		return node;
	}
	
	public void searchBTree(Node n, int find) {
		if(find < n.data) {
			System.out.println("Data is smaller than " + n.data);
			searchBTree(n.left, find);
		}else if (find > n.data) {
			System.out.println("Data is bigger than " + n.data);
			searchBTree(n.right, find);
		}else {
			System.out.println("Data found");
		}
	}
}