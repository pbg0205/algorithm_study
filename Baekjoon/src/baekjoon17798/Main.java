package baekjoon17798;

import java.io.*;
import java.util.*;

/*
 * @Problem		{오큰수 (17798)}
 * @url			https://www.acmicpc.net/problem/17798
 * @author		{pbg0205}
 * @Create by	{08.30.20}
 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long startTime = System.currentTimeMillis();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] data = new int[n];
        int[] ans = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        /*데이터 입력*/
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        /*
         * 1. 인덱스를 추가하기 위한 stack
         * 2. stack.push() :현재 인덱스 기준, 왼쪽에 있는 인덱스들
         */

        stack.push(0);

        for (int i = 1; i < n; i++) {
            /*stack이 비어있는 경우 추가*/
            if(stack.isEmpty()){
                stack.push(i);
            }
            //  9   5   4   8
            /*stack이 비어있는 경우 추가*/
            while(!stack.isEmpty() && data[stack.peek()] < data[i]){//왼쪽에 있는 인덱스들과 비교
                ans[stack.pop()] = data[i];
            }

            stack.push(i);
        }

        /*스택 남아있는 값들 처리*/
        while(!stack.isEmpty()){
            ans[stack.pop()] = -1;
        }

        for (Integer i : ans) {
            bw.write(String.valueOf(i) + " ");
        }

        long endTime = System.currentTimeMillis();
        long elaspedTime = endTime - startTime;
        System.out.println(elaspedTime);
        br.close();
        bw.flush();
        bw.close();

    }
}
