package baekjoon2470;

import java.io.*;
import java.util.*;
/*
 * @problem     두 용액(2470)
 * @url         https://www.acmicpc.net/problem/2470
 * @author      pbg0205
 * @created by  10.03.20
 */
class baekjoon2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int minValue = Integer.MAX_VALUE;

        int leftAnswerIndex = 0;
        int rightAnswerIndex = n-1;

        int leftIndex = 0;
        int rightIndex = n - 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int index = 0; index < n; index++) {
            arr[index] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        while(leftIndex < rightIndex){
            int min_temp = Math.abs(arr[leftIndex] + arr[rightIndex]);

            if (minValue > min_temp){
                minValue = min_temp;
                leftAnswerIndex = leftIndex;
                rightAnswerIndex = rightIndex;
            }

            if(arr[leftIndex] + arr[rightIndex] < 0){
                leftIndex++;
            }else if(arr[leftIndex] + arr[rightIndex] > 0){
                rightIndex--;
            }else{
                leftAnswerIndex = leftIndex;
                rightAnswerIndex = rightIndex;
                break;
            }
        }

        System.out.println(arr[leftAnswerIndex] + " " + arr[rightAnswerIndex]);

        br.close();
    }
}
