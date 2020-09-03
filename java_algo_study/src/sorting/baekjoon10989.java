package sorting;

import java.io.*;

/*
 * @Problem     수 정렬하기3(10989)
 * @Author      pbg0205
 * @Created by  09.03.20
 * @Explain
 *  - 계수 정렬(counting Sort)로 구현
 */
public class baekjoon10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10000001];

        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(br.readLine());
            arr[idx]++;
        }

        for(int i = 1; i <= 1000000; i++){
            for (int j = 0; j < arr[i]; j++) {
                bw.write(String.valueOf(i) + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}



