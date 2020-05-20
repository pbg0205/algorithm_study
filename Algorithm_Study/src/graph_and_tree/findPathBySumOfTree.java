package graph_and_tree;
//<<문제>>
//주어진 이진트리가 있다. 이 트리의 노드에는 정수 값이 저장되어 있다.(음의 정수 포함)
//연결된 노드의 합산이 특정 숫자가 되는 경로의 개수를 찾으시오.
//(조건) 경로의 시작과 끝점은 어디든 될 수 있지만 언제나 위에서 아래로만 합산이 되어야 한다.
 
class Tree6{
	class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	Node root;
	Tree6(int size){
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
		return countPathsWithSum(root, targetSum);
	}
	
	int countPathsWithSum(Node root, int targetSum) {
		if(root == null) return 0;
		int pathsFromRoot = countPathsWithSum(root,  targetSum, 0);
		int pathsOnLeft = countPathsWithSum(root.left, targetSum);
		int pathsOnRight = countPathsWithSum(root.right, targetSum);
		return pathsFromRoot + pathsOnLeft + pathsOnRight;
	}
	int countPathsWithSum(Node node, int targetSum, int currSum) {
		 if(node == null) return 0;
		 currSum += node.data;
		 int totalPaths = 0;
		 if(currSum == targetSum) {
			 totalPaths++;
		 }
		 totalPaths += countPathsWithSum(node.left, targetSum, currSum);
		 totalPaths += countPathsWithSum(node.right, targetSum, currSum);
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
public class findPathBySumOfTree {
	public static void main(String[] args) {
		Tree6 tree = new Tree6(10);
		System.out.println(tree.countPathsWithSum(5));
	}
}