package baekjoon1484;
/*
 * @problem     다이어트(1484) : https://www.acmicpc.net/problem/1484
 * @author      pbg0205
 * @created by  10.04.20
 */

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int G = Integer.parseInt(br.readLine());
        int leftIndex = 1;//기억하고 있던 몸무게
        int rightIndex = 2;//현재 몸무게
        boolean hasWeight = false;

        //G = 현재 몸무게^2 - 기억하고 있던 몸무게^2
        while(rightIndex <= 100000){
            long previousWeightSquare = (long) Math.pow(leftIndex, 2);
            long nowWeightSquare = (long) Math.pow(rightIndex, 2);

            if(nowWeightSquare - previousWeightSquare > G){
                leftIndex++;
            }else if(nowWeightSquare - previousWeightSquare < G){
                rightIndex++;
            }

            if(nowWeightSquare - previousWeightSquare == G){
                sb.append(rightIndex + "\n");
                rightIndex++;
                hasWeight = true;
            }
        }

        if(hasWeight){
            System.out.println(sb.toString());
            return ;
        }

        System.out.println(-1);

        br.close();
    }
}
