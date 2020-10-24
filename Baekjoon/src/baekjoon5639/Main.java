package baekjoon5639;
/*
 * @problem     이진 검색 트리(5639)
 * @url         https://www.acmicpc.net/problem/5639
 * @author      pbg0205
 * @created by  10.21.20
 */

import java.util.*;

class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        binarySearchTree bst = new binarySearchTree();

        int rootData = sc.nextInt();
        bst.insert(rootData);


        while (sc.hasNext()) {
            int nodeData = sc.nextInt();
            bst.insert(nodeData);
        }

        bst.postOrder();
    }
}

class binarySearchTree {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        }

        if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node root) {
        if (root.left != null) {
            postOrder(root.left);
        }

        if (root.right != null) {
            postOrder(root.right);
        }

        System.out.println(root.data);
    }
}

