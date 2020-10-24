package Baekjoon13505;
/*
 * @Problem     두 수 OXR(13505)
 * @Author      pbg0205(참고)
 * @Created by  09.03.20
 */

import java.io.*;
import java.util.*;

class Main {
    private static class Node {
        Node[] child;

        Node() {
            child = new Node[2];
        }

        Node setChild(boolean flag) {
            int idx = flag ? 1 : 0;
            return child[idx] != null ? child[idx] : (child[idx] = new Node());
        }
    }

    private static class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        void add(boolean[] input) {
            Node now = root;
            for (int i = 0; i < size; i++) {
                now = now.setChild(input[i]);
            }
        }

        void query(boolean[] input) {
            Node now = root;
            for (int i = 0; i < size; i++) {
                int idx = input[i] ? 0 : 1;
                if (now.child[idx] != null) {
                    now = now.child[idx];
                    result[i] = true;
                } else {
                    now = now.child[idx ^ 1];
                    result[i] = false;
                }
            }
        }
    }

    static int N, max = -1, size = 30;
    static boolean[][] input;
    static boolean[] result = new boolean[size];
    static Trie trie = new Trie();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        input = new boolean[N][size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            changeBinary(i, stoi(st.nextToken()));
            trie.add(input[i]);
        }

        for (int i = 0; i < N; i++) {
            trie.query(input[i]);
            max = Math.max(max, binaryToInt());
        }
        System.out.println(max);
    }

    private static void changeBinary(int row, int num) {
        int idx = size - 1;
        while (num > 0) {
            if (num % 2 == 1) {
                input[row][idx] = true;
            }
            idx--;
            num /= 2;
        }
    }

    private static int binaryToInt() {
        int allSum = 0;
        for (int pow = 0, i = size - 1; i >= 0; pow++, i--) {
            if (result[i]) {
                allSum += 1 << pow;
            }
        }
        return allSum;
    }

    private static int stoi(String input) {
        return Integer.parseInt(input);
    }
}