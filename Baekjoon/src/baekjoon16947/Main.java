package baekjoon16947;
/*
 * @problem		지하철 2호선(16947) : https://www.acmicpc.net/problem/16947
 * @author		pbg0205
 * @created by	09.23.20
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    //0: not visited
    //1: visited
    //2: cycle
    static int[] check = new int[3000];
    static int[] dist = new int[3000];
    static List<Integer>[] twoLine = new ArrayList[3000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            twoLine[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            from -= 1;
            to -= 1;

            twoLine[from].add(to);
            twoLine[to].add(from);
        }

        go(0, -1);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (check[i] == 2) {
                dist[i] = 0;
                queue.offer(i);
            } else {
                dist[i] = -1;
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int stationNum : twoLine[x]) {
                if (dist[stationNum] == -1) {
                    queue.offer(stationNum);
                    dist[stationNum] = dist[x] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(dist[i] + " ");
        }

        br.close();
    }

    private static int go(int stationNum, int status) {
        // -2: found cycle and not included
        // -1: not found cycle
        // 0~n-1: found cycle and start index
        if (check[stationNum] == 1) {//만약 역을 방문했다면,
            return stationNum;//역 위치를 반환한다.
        }

        check[stationNum] = 1;//방문하지 않았을 경우, 방문 체크를 한다.
        for (int node : twoLine[stationNum]) {//지하철역과 연결된 역(node)를 탐색한다.
            if (node == status) continue;//node가 만약 상태(status)와 같다면 건너뛴다.(이미 탐색 완료)
            int res = go(node, stationNum);//연결된 다음역을 탐색한다.
            if (res == -2) {//싸이클이 존재하지만 역이 싸이클이 아닐 경우,
                return -2;//-2를 반환한다.
            }
            if (res >= 0) {//만약 cycle인 경우
                check[stationNum] = 2;//check배열에 cycle(2)임을 표시한다.
                if (stationNum == res) {//역위치와 결과값이 같다면
                    return -2;//not cycle이다.
                } else {
                    return res;//아니면 res를 반환한다.
                }
            }
        }

        return -1;//아니라면 cycle을 발견하지 못했다고 표히한다.
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
