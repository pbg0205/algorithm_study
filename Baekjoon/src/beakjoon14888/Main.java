package beakjoon14888;
/*
 * @Problem     연산자 끼워넣기(14888)
 * @Url         https://www.acmicpc.net/problem/14888
 * @Author      pbg0205
 * @Created by  2021.01.13
 */

import java.io.*;
import java.util.*;

class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    private static int n;
    private static int[] number;
    private static int[] operator;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        number = initArr(n);
        operator = initArr(4);

        dfs(number[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int sum, int count) {
        if(count == n) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return ;
        }

        for (int index = 0; index < 4; index++) {
            if(operator[index] <= 0){
                continue;
            }

            operator[index]--;

            switch (index){
                case 0 : dfs(sum + number[count], count + 1);
                    break;
                case 1 : dfs(sum - number[count], count + 1);
                    break;
                case 2 : dfs(sum * number[count], count + 1);
                    break;
                case 3 : dfs(sum / number[count], count + 1);
                    break;
            }

            operator[index]++;
        }
    }

    private static int[] initArr(int size) throws IOException {
        int[] arr = new int[size];

        st = new StringTokenizer(br.readLine());
        int index = 0;

        while (st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }

        return arr;
    }
}
