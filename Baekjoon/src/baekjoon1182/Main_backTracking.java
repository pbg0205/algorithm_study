package baekjoon1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @Problem     부분 수열의 합(1182) : https://www.acmicpc.net/problem/1182
 * @Author      pbg0205
 * @Created by  09.19.20
 */
class Main_backTracking {

    static int[] arr;
    static int N, S;
    static int subSet_cnt = 0;

    public static void main(String[] args) throws IOException {
        /*  1. 데이터 입력   */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /*
         *  2. backtracking
         *  - 비선형으로 DFS(깊이우선탐색)을 진행했을 때, 조건이 만족하는 경우에만 탐색을 진행하는 방법
         */
        backTracking(0, 0);
        // -3 -2 5 -> 1
        if(S == 0){
            subSet_cnt--;
        }
        System.out.println(subSet_cnt);
    }

    private static void backTracking(int sum, int index) {
        if (index >= N) {
            if (sum == S) {
                subSet_cnt++;
            }
            return;
        }

        backTracking(sum+arr[index], index+1);/*배열의 index 값을 더하는 경우*/
        backTracking(sum, index+1); /*배열의 index 값을 건너띄는 경우*/
    }
}
