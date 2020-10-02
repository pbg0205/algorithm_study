package two_pointer;
/*
 * @problem     합이 0인  네 정수(7453) : https://www.acmicpc.net/problem/7453
 * @author      pbg0205
 * @created by  10.02.20
 */


import java.io.*;
import java.util.*;

public class baekjoon7453 {
    static int arr[][];

    static long AB[], CD[];

    static int N;

    static long count=0;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][4];
        AB = new long[N*N];
        CD = new long[N*N];
        StringTokenizer st;

        int index=0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                AB[index] = arr[i][0] + arr[j][1];
                CD[index] = arr[i][2] + arr[j][3];
                index++;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        int leftIndex = 0;
        int rightIndex = N*N-1;

        while(leftIndex< N*N && rightIndex>=0){
            long left_val = AB[leftIndex];
            long right_val = CD[rightIndex];

            if(left_val + right_val == 0){
                long left_count = 0;

                while(leftIndex<AB.length && AB[leftIndex]==left_val){
                    left_count++;
                    leftIndex++;
                }

                long right_count = 0;

                while(rightIndex >= 0 && CD[rightIndex] == right_val){
                    right_count++;
                    rightIndex--;
                }

                count += right_count * left_count;

            }
            if(left_val + right_val < 0){
                leftIndex++;
            }

            if(left_val + right_val > 0){
                rightIndex--;
            }
        }
        System.out.println(count);
    }

}
