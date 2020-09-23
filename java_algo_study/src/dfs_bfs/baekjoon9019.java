package dfs_bfs;
/*
 * @Problem     DSLR(9019) : https://www.acmicpc.net/problem/9019
 * @Author      pbg0205
 * @Created by  09.22.20
 */

import java.io.*;
import java.util.*;

public class baekjoon9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            int result = Integer.parseInt(st.nextToken());

            bfs(input, result);
        }
    }

    private static void bfs(int input, int result) {
        Queue<process> queue = new LinkedList<>();
        boolean[] visited = new boolean[10001];

        visited[input] = true;
        queue.offer(new process(input, ""));

        while(!queue.isEmpty()){
            process p = queue.poll();

            if(p.input == result){
                System.out.println(p.command);
                return ;
            }

            int D = (p.input * 2) % 10000;
            int S = p.input == 0 ? 9999 : p.input - 1;
            int L;
            if(p.input <= 0){
                L = 0;
            }else{
                //왼쪽으로 1234 -> 2341
                L = (p.input % 1000) * 10 + p.input/1000;
            }

            int R;
            if (p.input <= 0) {
                R = 0;
            } else {
                //오른쪽으로 1234 4123
                R = (p.input % 10) * 1000 + p.input / 10;
            }

            if(!visited[D]){
                visited[D] = true;
                queue.offer(new process(D, p.command + "D"));
            }

            if(!visited[S]){
                visited[S] = true;
                queue.offer(new process(S, p.command + "S"));
            }

            if(!visited[L]){
                visited[L] = true;
                queue.offer(new process(L, p.command + "L"));
            }

            if(!visited[R]){
                visited[R] = true;
                queue.offer(new process(R, p.command + "R"));
            }
        }
    }
}

class process{
    int input;
    String command;

    process(int input, String command){
        this.input = input;
        this.command = command;
    }
}