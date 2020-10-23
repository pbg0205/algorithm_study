package baekjoon16437;
/*
 * @problem     양 구출 작전(16437)
 * @url         https://www.acmicpc.net/problem/16437
 * @author      pbg0205
 * @created by  10.22.20
 * @explain     배열 인덱스를 이용한 후위 순회 방법
 */

import java.io.*;
import java.util.*;

class Main_array {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    static ArrayList<Integer>[] nodes;
    static int[] score;
    static char[] animal;

    public static void main(String[] args) throws IOException {
        int numberOfNodes = Integer.parseInt(br.readLine());

        nodes = new ArrayList[numberOfNodes + 1];
        animal = new char[numberOfNodes + 1];
        score = new int[numberOfNodes + 1];

        for (int i = 0; i < numberOfNodes + 1; i++) {
            nodes[i] = new ArrayList<Integer>();
        }

        for (int Index = 2; Index < numberOfNodes + 1; Index++) {
            st = new StringTokenizer(br.readLine());

            char NodeAnimal = st.nextToken().charAt(0);
            int amount = Integer.parseInt(st.nextToken());
            int nextNode = Integer.parseInt(st.nextToken());

            animal[Index] = NodeAnimal;
            score[Index] = amount;
            nodes[nextNode].add(Index);
        }


        System.out.println(postOrder(1));
    }

    private static long postOrder(int node) {
        long sum = 0;

        //Left -> Right -> Root
        for (int next : nodes[node]) {
            sum += postOrder(next);
        }

        if (animal[node] == 'S') {
            return sum + score[node];
        } else {
            return (sum - score[node] >= 0) ? sum - score[node] : 0;
        }
    }
}