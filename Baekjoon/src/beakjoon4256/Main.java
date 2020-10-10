package beakjoon4256;
/*
 * @problem     트리(4256) : https://www.acmicpc.net/problem/4256
 * @author      pbg0205
 * @created by  10.10.20
 */

import java.io.*;
import java.util.*;

class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int nodeSize = Integer.parseInt(br.readLine());
            int[] preOrder = new int[nodeSize];
            int[] inOrder = new int[nodeSize];

            preOrder = insertData(preOrder);
            inOrder = insertData(inOrder);

            postOrder(preOrder, inOrder);
            System.out.println();
        }

        br.close();
    }

    //postOrder : Left -> right -> root
    private static void postOrder(int[] preOrder, int[] inOrder) {
        int nodeSize = preOrder.length;
        if(nodeSize == 0){
            return ;
        }

        int rootNode = preOrder[0]; //트리의 rootNode

        //inOrder rootIndex 탐색
        int rootIndex = 0;
        while(rootIndex < nodeSize){
            if(inOrder[rootIndex] == rootNode){
                break;
            }
            rootIndex++;
        }

        /*왼쪽 node들 slice*/
        int left = rootIndex;
        if(left != 0){
            postOrder(slice(preOrder, 1, left), slice(inOrder, 0, left - 1));
        }

        /*오른쪽 node들 slice*/
        int right = nodeSize - (rootIndex + 1);
        if(right != 0){
            postOrder(slice(preOrder, left+1, nodeSize-1), slice(inOrder, left + 1, nodeSize-1));
        }

        System.out.print(rootNode + " ");
    }

    private static int[] slice(int[] nodes, int start, int end) {
        int nodeSize = end - start + 1;
        int[] tempArr = new int[nodeSize];

        int index = 0;
        for (int i = start; i <= end; i++) {
            tempArr[index] = nodes[i];
            index++;
        }

        return tempArr;
    }

    static int[] insertData(int[] arr) throws IOException {
        st = new StringTokenizer(br.readLine());
        int arrSize = arr.length;

        for (int i = 0; i < arrSize; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        return arr;
    }
}
