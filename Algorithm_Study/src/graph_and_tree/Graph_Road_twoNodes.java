package graph_and_tree;

import java.util.LinkedList;
// #두 노드이 연결되어 있는지 여부(다른 node를 통해서 건너가는 과정 포함)
/*
0
/
1 -- 3	 7
|  / |\ /
| /  | 5
2 -- 4  \
		6 - 8
*/

public class Graph_Road_twoNodes {
	public static void main(String[] args) {
		Graph1 g = new Graph1(9);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		
		System.out.println(g.search(1, 3));
	}
}


class Graph1{
	class Node{
		int data;
		boolean marked;
		LinkedList<Node> adjacent;
		Node(int data){
			this.data = data;
			this.marked = false;
			this.adjacent = new LinkedList<Node>();
		}
	}
	
	Node[] nodes;
	
	Graph1(int size){
		nodes = new Node[size];
		for (int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}
	}
	
	//node간의 상태를 추가해주는 함수
	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		if(!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if (!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);			
		}
	}
	
	//marked flag를 모두 false로 해주기 위해서 사용하는 함수
	void initMarks() {
		for(Node n : nodes) {
			n.marked = false;
		} 
	}
	
	boolean search(int i1, int i2) {
		return search(nodes[i1], nodes[i2]);
	}
	//BFS를 통해 해당 결로가 존재하는지를 확인하기 위한 함수
	boolean search(Node start, Node end) {
		initMarks();
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(start);
		while(!q.isEmpty()) {
			Node root = q.removeFirst();
			
			//만약 root가 end node라면 true를 리턴해서 함수 탈출
			if(root == end) {
				return true;
			}
			
			//자식노드들을 돌면서 queue에 안 들어온 애들만 queue에 첨가하는 과정
			for(Node n : root.adjacent){
				if(n.marked == false) {
					n.marked = true;
					q.add(n);
				}
			}
		}
		
		return false;
	}
}
