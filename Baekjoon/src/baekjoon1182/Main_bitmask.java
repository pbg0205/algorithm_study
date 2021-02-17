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
class Main_bitmask {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int subSet_cnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int subSet = 1; subSet < (1 << N); subSet++) {//전체 집합에서 부분집합 탐색
            int sum_tmp = 0;
            for (int idx = 0; idx < N; idx++) {
                if (((1 << idx) & subSet) > 0) {
                    sum_tmp += arr[idx];
                }
            }

            if (sum_tmp == S) {
                subSet_cnt++;
            }
        }

        System.out.println(subSet_cnt);
    }
}
