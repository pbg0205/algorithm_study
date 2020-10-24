package baekjoon9663;

import java.io.*;

/*
 * @Problem     N-Queen(9663) :https://www.acmicpc.net/problem/9663
 * @Author      pbg0205
 * @Created by   09.18.20
 *
 */
class Main_bitmask {

    static int N, line, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        line = (1<<N) -1;
        solve(0, 0, 0, 0);

        System.out.println(res);

        System.out.println(Integer.toBinaryString(-3)); //3 : 011
    }

    private static void solve(int cnt, int horizon, int ld, int rd) {
        if(cnt == N){
            res++;
            return ;
        }

        int ok = (~(horizon| ld | rd)) & line;
        while(ok > 0){
            int i = ok & -ok;

            solve(cnt+1, horizon | i, (ld|i)>>1, (rd|i)<<1);

            ok ^= i;
        }
    }
}
