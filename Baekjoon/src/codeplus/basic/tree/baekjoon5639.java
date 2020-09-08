package codeplus.basic.tree;

import java.util.Scanner;

/*
 * @Problem     이진 검색 트리(5639)
 * @Author      pbg0205
 * @Created by  09.09.20
 *
 */

public class baekjoon5639 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = new Node(n);
        while(sc.hasNext()){
            n = sc.nextInt();
            root = root.insertNode(root , n);
        }

        postOrder(root);
    }

    public static void postOrder(Node node){
        if(node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }
}

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
    }

    public Node insertNode(Node node, int n){
        Node current = null;
        if(node == null){
            return new Node(n);
        }

        if(node.data > n){
            current = insertNode(node.left, n);
            node.left = current;
        }else{
            current = insertNode(node.right, n);
            node.right = current;
        }

        return node;
    }
}



