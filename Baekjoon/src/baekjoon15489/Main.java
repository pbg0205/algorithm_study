package baekjoon15489;
/*
 * @Problem     파스칼 삼각형(15489)
 * @Author      pbg0205
 * @Created by  09.07.20
 *
 */

import java.io.*;
import java.util.*;

class baekjoon15489 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] arr = new int[30][30];
        int answer = 0;

        arr[0][0] = 1;
        for(int i = 1; i < 30; i++){
            arr[i][0] = 1;//nC0 = 1
            for(int j = 1; j < i; j++){
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];//파스칼 삼각형(n-1Cr-1 + n-1Cr = nCr)
            }
            arr[i][i] = 1;//nCn = 1
        }

        //삼각형 별찍기 식으로 반복문 처리
        for(int i = 0; i < W; i++){
            for (int j = 0; j <= i; j++) {
                answer += arr[R-1+i][C-1+j];
            }
        }

        System.out.println(answer);

        br.close();
    }

}
