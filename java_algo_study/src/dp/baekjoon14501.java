package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @Problem     퇴사(14501)
 * @Author      pbg0205
 * @Create by   09.09.20
 *
 */

public class baekjoon14501 {

    static int[] days, cost;
    static int N, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        days = new int[N];
        cost = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st.nextToken());
        }

        schedule(0,0);

        System.out.println(max);

        br.close();
    }
    public static void schedule(int day, int money){
        if(day >= N){
            max = Math.max(max, money);
            return ;
        }

        if(day + days[day] <= N){
            schedule(day + days[day], money + cost[day]);
        }

        schedule(day+1, money);
    }
}
