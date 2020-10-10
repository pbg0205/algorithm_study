package baekjoon13325;
/*
 * @problem     이진트리(13325) : https://www.acmicpc.net/problem/13325
 * @author      pbg0205
 * @created by  10.10.20
 */

import java.io.*;
import java.util.*;

class Main {

    static int level;
    static int nodeSize;

    static int[] node;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        level = Integer.parseInt(br.readLine());
        nodeSize = (int) Math.pow(2, level+1);
        node = new int[nodeSize];
        sum = new int[nodeSize];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i < nodeSize; i++) {
            node[i] = Integer.parseInt(st.nextToken());
        }

        findMaxDistance(1);

        int result = 0;
        for (int i = 0; i < nodeSize; i++) {
            result += node[i];
        }

        System.out.println(result);

        br.close();
    }

    private static int findMaxDistance(int now) {
        int left = now * 2;
        int right = now * 2 + 1;

        if (now >= nodeSize) {
            return 0;
        }

        if (left > nodeSize || right > nodeSize) {
            return 0;
        }

        int leftSum = findMaxDistance(left) + node[left];
        int rightSum = findMaxDistance(right) + node[right];

        int difference;
        if(leftSum > rightSum){
            difference = leftSum - rightSum;
            node[right] += difference;
        }else{
            difference = rightSum - leftSum;
            node[left] += difference;
        }

        return Math.max(leftSum, rightSum);
    }
}
