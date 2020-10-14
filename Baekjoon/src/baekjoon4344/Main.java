package baekjoon4344;
/*
 * @problem     평균은 넘겠지(4344)
 * @url         https://www.acmicpc.net/problem/4344
 * @author      pbg0205
 * @created by  10.14.20
 */

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] scores;
        int totalStudent;
        int totalScore = 0;
        double studentOverAverage = 0;

        double average;
        double percentOverAverage;

        int testCase = Integer.parseInt(br.readLine());

        while(testCase-- > 0){
            st = new StringTokenizer(br.readLine());

            totalStudent = Integer.parseInt(st.nextToken());
            scores = new int[totalStudent];
            studentOverAverage = 0;
            totalScore = 0;

            for (int i = 0; i < totalStudent; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
                totalScore += scores[i];
            }

            average = totalScore / totalStudent;

            for (int score : scores){
                if (score > average) {
                    studentOverAverage++;
                }
            }

            percentOverAverage = (studentOverAverage / totalStudent) * 100;

            System.out.printf("%.3f%%\n", percentOverAverage);
        }


        br.close();
    }
}
