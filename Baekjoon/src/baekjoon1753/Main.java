package baekjoon1753;
/*
 * @problem     최단경로(1753)
 * @url         https://www.acmicpc.net/problem/1753
 * @author      pbg0205
 * @created by  10.27.20
 */

import java.io.*;
import java.util.*;

//TODO : int[][] map을 이용한 문제 풀이 -> 메모리 초과
class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int nodeSize = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        Graph graph = new Graph(nodeSize);

        while(nodeSize-- > 0){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.input(from, to, weight);
        }

        graph.dijkstra(start);
    }
}

class Graph{
    private int size;
    private int[][] map;

    public Graph(int size){
        this.size = size;
        map = new int[size + 1][size + 1];
    }

    public void input(int from, int to, int weight){
        map[from][to] = weight;
    }

    public void dijkstra(int start){
        final int INF = Integer.MAX_VALUE;
        int[] distance = initDistance(size);
        boolean[] visited = new boolean[size + 1];

        distance[start] = 0;
        visited[start] = true;

        for (int adjacent = 1; adjacent < size + 1; adjacent++) {
            if(!visited[adjacent] && map[start][adjacent] != 0){
                distance[adjacent] = map[start][adjacent];
            }
        }

        for (int trial = 1; trial < size - 1; trial++) {
            int minValue = INF;
            int minIndex = -1;

            for (int node = 1; node < size + 1; node++) {
                if(!visited[node] && distance[node] != INF){
                    if(distance[node] < minValue){
                        minValue = distance[node];
                        minIndex = node;
                    }
                }
            }

            visited[minIndex] = true;

            for (int node = 1; node < size + 1; node++) {
                if(!visited[node] && map[minIndex][node] != 0){
                    if(distance[node] > distance[minIndex] + map[minIndex][node]){
                        distance[node] = distance[minIndex] + map[minIndex][node];
                    }
                }
            }
        }

        print(distance);
    }

    private void print(int[] distance) {
        final int INF = Integer.MAX_VALUE;

        for (int node = 1; node < size + 1; node++) {
            if (distance[node] == INF){
                System.out.println("INF");
            }else{
                System.out.println(distance[node]);
            }
        }
    }

    private int[] initDistance(int size) {
        final int INF = Integer.MAX_VALUE;
        int distance[] = new int[size + 1];

        for (int node = 1; node < size + 1; node++) {
            distance[node] = INF;
        }

        return distance;
    }
}