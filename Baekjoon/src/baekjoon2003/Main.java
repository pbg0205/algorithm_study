package baekjoon2003;

import java.io.*;
import java.util.*;

/*
 * @problem    수들의 함2(2003)
 * @url			https://www.acmicpc.net/problem/2003
 * @author      pbg0205
 * @created by  09.28.20
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int L = 0, R = 0;
        int sum = 0;
        int result = 0;

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(true){
            if(sum >= M){
               sum -= arr[L++];
            }else if(R == N){
                break;
            }else{
                sum += arr[R++];
            }

            if(sum == M){
                result++;
            }
        }

        System.out.println(result);

        br.close();
    }
}
