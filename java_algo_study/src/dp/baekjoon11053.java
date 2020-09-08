package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * @Problem     가장 긴 증가하는 부분 수열(11053)
 * @Author      pbg0205
 * @Created by  09.09.20
 */

public class baekjoon11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = Integer.MIN_VALUE;

        int data[] = new int[n];
        int dp[] = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 1);

        for (int now = 1; now < n; now++) {
            for (int prev = 0; prev < now; prev++) {
                if( dp[prev] >= dp[now] && data[prev] < data[now]){
                    dp[now] = dp[prev] + 1;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            max = Math.max(max, dp[j]);
        }




        System.out.println(max);
    }
}
