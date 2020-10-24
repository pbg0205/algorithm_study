package baekjoon7568;
/*
 * @Problem     덩치(7568) : https://www.acmicpc.net/problem/7568
 * @Author      pbg0205
 * @Created by  09.16.20
 *
 */

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        /* 1. 입력받기 위한 처리 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        personInfo[] arr = new personInfo[N];
        /* 2. personInfo 객체에 데이터 입력 */
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            arr[i] = new personInfo(weight, height);
        }

        /* 3. 브루트포스를 이용한 모든 몸무게, 신장 비교*/
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i == j){
                    continue;
                }

                if(arr[i].weight > arr[j].weight){
                    if(arr[i].height > arr[j].height){
                        arr[j].addCount();
                    }
                }
            }
        }

        for (personInfo person : arr) {
            System.out.print(person.count + " ");
        }

        br.close();
    }
}

class personInfo{
    int weight;
    int height;
    int count;

    personInfo(int weight, int height){
        this.weight = weight;
        this.height = height;
        count++;
    }

    public void addCount(){
        this.count += 1;
    }
}