package graph_and_tree;

import java.util.Random;

//문제
//이진검색 트리에서 임의의 노드를 가져오는 알고리즘을 구현하시오.
//단, 모든 노드에 동일한 확률로 임의의 노드를 가져와야 하며, 노드에 추가 정보를 저장해도 됨.

//방법1. 모든 노드를 거쳐 배열 방에 값을 담아서 랜덤으로 return 하는 구조 -> 배열을 생성해야 하고, 모든 node를 순회해야 하므로 비효율적
//방법2. level을 random으로 선정하여 갈림길이 생길때 마다 random하게 값을 return하는 구조 -> balance가 안맞는 경우, tree가 긴 구조의 값이 많이 return하는 구조이므로 비효율적
//방법3. random한 숫자를 이용하여 tree에 집어넣고 순회하여 BST 안에 값이 존재하면 return하는 구조 + 시간 복잡도 O(n)

class Tree5{
	class Node {
		int data;
		Node left;
		Node right;
		int size = 0;

		Node(int data) {
			this.data = data;
			this.size = 1;
		}

		void insert(int data) {
			if (data <= this.data) {
				if (left == null) {
					left = new Node(data);
				} else {
					left.insert(data);
				}
			} else {
				if (right == null) {
					right = new Node(data);
				}else {
					right.insert(data);
				}
			}
		size++;
		}
		int size() {
			return size;
			}
		Node find(int data) {
			if(data == this.data) {
				return this;
			}else if(data < this.data) {
				return left != null ? left.find(data) : null;
			}else if(data > this.data) {
				return right != null? right.find(data) : null;
			}else {
				return null;
			}
		}
		Node getIthNode(int i) {
			int leftSize = left == null? 0 : left.size();
			if(i < leftSize) {
				return left.getIthNode(i);
			}else if (i == leftSize) {
				return this;
			}else {
				return right.getIthNode(i - (leftSize + 1));
			}
		}
	}
	Node root;
	int size() {
		return root == null? 0 : root.size();
	}
	
	void insert(int data) {
		if (root == null) root = new Node(data);
		else root.insert(data);
	}
	Node getRandomNode() {
		if(root == null) return null;
		Random random = new Random();
		int i = random.nextInt(size());
		return root.getIthNode(i);
	}
}

public class RandomNodeFromBST {
	public static void main(String[] args) {
		Tree5 t = new Tree5();
		t.insert(4);
		t.insert(0);
		t.insert(1);
		t.insert(2);
		t.insert(5);
		t.insert(7);
		t.insert(8);
		t.insert(3);
		t.insert(6);
		t.insert(9);
		System.out.println(t.getRandomNode().data);
	}
}
