package Baekjoon.src.baekjoon11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cityCount;
    static int[][] distance;
    static final int INF = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        cityCount = Integer.parseInt(br.readLine());
        int butCount = Integer.parseInt(br.readLine());
        distance = new int[cityCount + 1][cityCount + 1];

        initDistance();

        while(butCount-- > 0) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            distance[start][end] = Math.min(distance[start][end], time);
        }

        floydWashall();
        
        print();
    }

    private static void floydWashall() {
        for (int k = 1; k <= cityCount; k++) {
            for (int i = 1; i <= cityCount; i++) {
                for (int j = 1; j <= cityCount; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
    }

    private static void initDistance() {
        for (int from = 1; from <= cityCount; from++) {
            for (int to = 1; to <= cityCount; to++) {
                if(from != to) {
                    distance[from][to] = INF;
                }
            }
        }
    }

    private static void print() {
        int length = distance.length;

        for (int i = 1; i < length; i++) {
            for (int j = 1; j < length; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }
}
