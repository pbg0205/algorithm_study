package Baekjoon1094;
/*
 * @problem     막대기(1094)
 * @url         https://www.acmicpc.net/problem/1094
 * @author      pbg0205
 * @created by  10.15.20
 */

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stickLen = Integer.parseInt(br.readLine());
        int index = 6;
        int count = 0;

        while(index >= 0){
            if(stickLen - (1 << index) >= 0){
                stickLen -= (1 << index);
                count++;
            }

            index--;
        }

        System.out.println(count);

        br.close();
    }
}
