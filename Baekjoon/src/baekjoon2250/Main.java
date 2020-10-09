package baekjoon2250;
/*
 * @problem     트리의 높이와 너비 : https://www.acmicpc.net/problem/2250
 * @author      pbg0205
 * @created by  10.09.20
 */

import java.io.*;
import java.util.*;

class Main {

    static Node[] binaryTree;
    static int[][] nodeMap;

    static int col = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfNode = Integer.parseInt(br.readLine());
        binaryTree = new Node[numberOfNode + 1];
        int maxLevel = Integer.MIN_VALUE;
        int rootIndex = 0;

        StringTokenizer st;

        for (int i = 0; i <= numberOfNode; i++) {
            binaryTree[i] = new Node(i, -1, -1);
        }

        for (int i = 1; i <= numberOfNode; i++) {
            st = new StringTokenizer(br.readLine());

            int data = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            binaryTree[data].data = data;
            binaryTree[data].left = left;
            binaryTree[data].right = right;

            //left 부모 인덱스 설정
            if(left != -1){
                binaryTree[left].parent = data;
            }
            //right 부모 인덱스 설정
            if(right != -1){
                binaryTree[right].parent = data;
            }
        }

        //rootIndex 검색
        for (int i = 1; i <= numberOfNode; i++) {
            if(binaryTree[i].parent == -1){
                rootIndex = i;
                break;
            }
        }

        setLevelBypreOrder(rootIndex, 1);
        maxLevel = getMaxLevel(maxLevel);
        nodeMap = new int[maxLevel + 1][numberOfNode + 1];
        inOrder(rootIndex);
        
        //level별로 넓이 탐색하기
        int maxArea = Integer.MIN_VALUE;
        int maxAreaLevel = maxLevel;
        for (int row = 1; row <= maxLevel; row++) {
            int minCol = numberOfNode;
            int maxCol = 0;
            for (int col = 1; col <= numberOfNode; col++) {
                if(nodeMap[row][col] != 0){
                    minCol = minCol > col ? col : minCol;
                    maxCol = maxCol < col ? col : maxCol;
                }
            }
            int levelArea = maxCol - minCol + 1;
            if(maxArea < levelArea){
                maxArea = levelArea;
                maxAreaLevel = row;
            }
        }

        System.out.println(maxAreaLevel + " " + maxArea);

        br.close();
    }

    private static int getMaxLevel(int maxLevel) {
        for (Node node : binaryTree) {
            maxLevel = node.level > maxLevel ? node.level : maxLevel;
        }

        return maxLevel;
    }

    private static void setLevelBypreOrder(int now, int level) {
        binaryTree[now].setLevel(level);

        if (binaryTree[now].left != -1) {
            int left = binaryTree[now].left;
            setLevelBypreOrder(left, level + 1);
        }

        if (binaryTree[now].right != -1) {
            int right = binaryTree[now].right;
            setLevelBypreOrder(right, level + 1);
        }
    }

    private static void inOrder(int now) {
        if (now == -1){
            return ;
        }

        if (binaryTree[now].data == -1) {
            return ;
        }

        int left = binaryTree[now].left;
        inOrder(left);

        int row = binaryTree[now].level;
        nodeMap[row][col++] = binaryTree[now].data;

        int right = binaryTree[now].right;
        inOrder(right);
    }
}

class Node {
    int data;
    int left;
    int right;
    int level;
    int parent;

    Node(int data, int left, int right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = -1;
    }

    int setLevel(int level) {
        return this.level = level;
    }
}