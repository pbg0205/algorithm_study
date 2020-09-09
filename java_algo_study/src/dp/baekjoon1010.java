package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * @Problem     다리놓기(1010)
 * @Author      pbg0205
 * @Created by  09.09.20
 * 
 */
public class baekjoon1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n >= m){
                combination(n, m);
            }

            if(n < m){
                combination(m, n);
            }
        }
    }

    public static void combination(int n, int r){
        if(n == r){
            System.out.println(1);
            return ;
        }

        if(r > (n-r)){
            combination(n, n-r);
            return ;
        }

        long result = 1;

        for (int i = n; i > n-r ; i--) {
            result *= i;
        }

        for(int i = r; i >= 1; i--){
            result /= i;
        }

        System.out.println(result);
    }
}
