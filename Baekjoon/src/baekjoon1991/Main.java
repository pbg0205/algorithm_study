package baekjoon1991;

import java.io.*;
import java.util.*;

/*
 * @problem     트리 순회(1991) : https://www.acmicpc.net/problem/1991
 * @author      pbg0205
 * @created by  10.05.20
 */
public class Main {
    static Map<Character, char[]> tree = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            char[] node = new char[3];

            node[0] = st.nextToken().charAt(0);
            node[1] = st.nextToken().charAt(0);
            node[2] = st.nextToken().charAt(0);

            tree.put(node[0], node);
        }

        preOrder('A');
        sb.append("\n");

        inOrder('A');
        sb.append("\n");

        postOrder('A');
        sb.append("\n");

        System.out.println(sb.toString());

        br.close();
    }

    private static void postOrder(char node) {
        if(node == '.'){
            return ;
        }

        postOrder(tree.get(node)[1]);
        postOrder(tree.get(node)[2]);
        sb.append(node);
    }

    private static void inOrder(char node) {
        if(node == '.'){
            return ;
        }

        inOrder(tree.get(node)[1]);
        sb.append(node);
        inOrder(tree.get(node)[2]);
    }

    private static void preOrder(char node) {
        if(node == '.'){
            return ;
        }

        sb.append(node);
        preOrder(tree.get(node)[1]);
        preOrder(tree.get(node)[2]);
    }


}
