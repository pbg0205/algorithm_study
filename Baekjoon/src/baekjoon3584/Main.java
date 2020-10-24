package baekjoon3584;
/*
 * @problem     가장 가까운 공통 조상(3584)
 * @url         https://www.acmicpc.net/problem/3584
 * @author      pbg0205
 * @created by  10.24.20
 */

import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    static ArrayList<Integer>[] tree;

    static int rootNode;
    static int testNum;

    static int firstNode = 0;
    static int lastNode = 0;
    static int nearestNode;

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            testNum = Integer.parseInt(br.readLine());
            tree = new ArrayList[testNum + 1];

            makeNodeInTree(tree);
            setParentNode();

            rootNode = getRootNode();
            nearestNode = solve(firstNode, lastNode);

            System.out.println(nearestNode);
        }
    }

    private static void setParentNode() throws IOException {
        for (int i = 1; i <= testNum; i++) {
            st = new StringTokenizer(br.readLine());

            if (i == testNum) {
                firstNode = Integer.parseInt(st.nextToken());
                lastNode = Integer.parseInt(st.nextToken());
                break;
            }

            int parentNode = Integer.parseInt(st.nextToken());
            int childNode = Integer.parseInt(st.nextToken());

            tree[childNode].add(parentNode);
        }
    }

    private static void makeNodeInTree(ArrayList<Integer>[] tree) {
        for (int i = 0; i <= testNum; i++) {
            tree[i] = new ArrayList<>();
        }
    }

    private static int solve(int firstNode, int lastNode) {
        int LenFromFirst = LenfromRoot(firstNode);
        int LenFromLast = LenfromRoot(lastNode);

        if(LenFromFirst > LenFromLast){
            firstNode = sameWithLast(firstNode, lastNode);
        }

        if(LenFromFirst < LenFromLast){
            lastNode = sameWithFirst(firstNode, lastNode);
        }

        return nearestCommonNode(firstNode, lastNode);
    }

    private static int nearestCommonNode(int firstNode, int lastNode) {
        if(firstNode == lastNode){
            return firstNode;
        }

        int parentOfFirst = tree[firstNode].get(0);
        int parentOfLast = tree[lastNode].get(0);

        while(parentOfFirst != parentOfLast){
            parentOfFirst = tree[parentOfFirst].get(0);
            parentOfLast = tree[parentOfLast].get(0);
        }

        return parentOfFirst;
    }

    private static int sameWithLast(int firstNode, int lastNode) {
        int LenFromFirst = LenfromRoot(firstNode);
        int LenFromLast = LenfromRoot(lastNode);

        while(LenFromFirst != LenFromLast){
            firstNode = tree[firstNode].get(0);
            LenFromFirst--;
        }

        return firstNode;
    }

    private static int sameWithFirst(int firstNode, int lastNode) {
        int LenFromFirst = LenfromRoot(firstNode);
        int LenFromLast = LenfromRoot(lastNode);

        while(LenFromFirst != LenFromLast){
            lastNode = tree[lastNode].get(0);
            LenFromLast--;
        }

        return lastNode;
    }

    private static int getRootNode() {
        for (int node = 1; node <= testNum; node++) {
            if (tree[node].size() == 0) {
                return node;
            }
        }

        return -1;
    }

    private static int LenfromRoot(int child) {
        if (child == rootNode) {
            return 0;
        }

        int parent = tree[child].get(0);
        int depth = 1;

        while(parent != rootNode){
            depth++;
            child = parent;
            parent = tree[child].get(0);
        }

        return depth;
    }
}
