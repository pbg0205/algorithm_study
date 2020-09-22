package dfs_bfs;
/*
 * @Problem     데스 나이트(16948) : https://www.acmicpc.net/problem/16948
 * @Author      pbg0205
 * @Created by  09.22.20
 */

import java.io.*;
import java.util.*;

public class baekjoon16948 {

    static int r1, c1;
    static int r2, c2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());

        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        int r_distance = Math.abs(r2 - r1);
        int c_distance = Math.abs(c2 - c1);

        // 가로 이동 가능 여부 예외 처리
        if (r_distance % 2 == 1) {
            System.out.println(-1);
            return;
        }

        int divided_num = r_distance / 2;
        for (int i = 0; i < divided_num; i++) {
            c_distance = Math.abs(c_distance - 1);
        }

        cnt += divided_num;

        //세로 이동 가능 여부 예외 처리
        if (c_distance % 2 == 1) {
            System.out.println(-1);
            return;
        }

        divided_num = c_distance / 2;
        cnt += divided_num;

        System.out.println(cnt);
    }
}