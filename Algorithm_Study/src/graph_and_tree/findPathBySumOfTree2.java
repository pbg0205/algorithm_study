package graph_and_tree;

import java.util.ArrayList;
//stackoverflow error 나옴
//<<문제>>
//주어진 이진트리가 있다. 이 트리의 노드에는 정수 값이 저장되어 있다.(음의 정수 포함)
//연결된 노드의 합산이 특정 숫자가 되는 경로의 개수를 찾으시오.
//root node -> leaf node : 배열을 생성하여 처음 root 값을 더하고(u), 마지막에 root값을 추가한다.(a) -> 추가 완료된 값에서 찾고자하는 합을 탐색한다.(s)
//leaf node -> root node : leaf node에서 root로 올라가면서, 마지막 node의 값을 지우고(r) ->  찾고자하는 합을 탐색한다.(u) -> 값 하나를 제거한다
 
class Tree7{
	class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	Node root;
	Tree7(int size){
		this.root = makeBST(0, size-1);
	}
	
	Node makeBST(int start, int end) {
		if(start > end) return null;
		int mid = (start + end) /2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid - 1);
		node.right = makeBST(mid + 1, end);
		return node;
	}
	
	int countPathsWithSum(int targetSum) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		return countPathsWithSum(root, targetSum, array);
	}
	
	int countPathsWithSum(Node root, int targetSum, ArrayList<Integer> array) {
		if(root == null) return 0;
		int totalPaths = 0;
		addValue(array, root.data);
		totalPaths = countPaths(array, targetSum);
		totalPaths += countPathsWithSum(root.left, targetSum, array);
		totalPaths += countPathsWithSum(root.right, targetSum, array);
		removeLast(array);
		return totalPaths;
	}
	
	void addValue(ArrayList<Integer> array, int value) {
		for (int i = 0; i < array.size(); i++) {
			array.set(i, array.get(i));
		}
		array.add(value);
	}
	
	void removeLast(ArrayList<Integer> array) {
		int value = array.remove(array.size() -1 );
		for (int i = 0; i < array.size(); i++) {
			array.set(i,  array.get(i) - value);
		}
	}
	
	int countPaths(ArrayList<Integer> array, int targetSum) {
		int totalPaths = 0;
		for (int i = 0; i < array.size(); i++) {
			if(array.get(i) == targetSum)	totalPaths++; 
		}
		return totalPaths;
	}
}
/*Tree 형태
				(4)
			   /   \
			  (1)  (7)
			  / \  / \
			(0)(2)(5)(8)
				 \  \  \
				 (3)(6)(9)
*/
public class findPathBySumOfTree2 {
	public static void main(String[] args) {
		Tree7 tree = new Tree7(10);
		System.out.println(tree.countPathsWithSum(5));
	}
}
