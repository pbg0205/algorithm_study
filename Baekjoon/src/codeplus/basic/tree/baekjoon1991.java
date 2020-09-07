package codeplus.basic.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * @Problem     트리순회(1991)
 * @Author      pbg0205
 * @Created by  09.07.20
 *
 */

public class baekjoon1991{

    static Map<Character, char[]> tree = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <n ; i++) {
            st = new StringTokenizer(br.readLine());
            char[] node = new char[3];

            node[0] = st.nextToken().charAt(0);//node
            node[1] = st.nextToken().charAt(0);//left node
            node[2] = st.nextToken().charAt(0);//right node

            tree.put(node[0], node);
        }

        preOrder('A');
        sb.append("\n");

        inOrder('A');
        sb.append("\n");

        postOrder('A');

        System.out.println(sb.toString());
    }

    public static void preOrder(char node){
        if(node == '.'){
            return;
        }

        sb.append(node);
        preOrder(tree.get(node)[1]);
        preOrder(tree.get(node)[2]);
    }

    public static void inOrder(char node){
        if(node == '.'){
            return;
        }
        inOrder(tree.get(node)[1]);
        sb.append(node);
        inOrder(tree.get(node)[2]);
    }

    public static void postOrder(char node){
        if(node == '.'){
            return;
        }
        postOrder(tree.get(node)[1]);
        postOrder(tree.get(node)[2]);
        sb.append(node);
    }
}
