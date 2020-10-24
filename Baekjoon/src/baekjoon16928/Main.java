package baekjoon16928;
/*
 * @Problem     뱀과 사다리 게임(16928) : https://www.acmicpc.net/problem/16928
 * @Author      pbg0205
 * @Created by  09.22.20
 */

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ladderNum = Integer.parseInt(st.nextToken());
        int snakeNum = Integer.parseInt(st.nextToken());
        int totalNum = ladderNum + snakeNum;

        Map<Integer,Integer> ladderMap = new HashMap<>();
        Map<Integer,Integer> snakeMap = new HashMap<>();

        while(totalNum-- > 0){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if(from > to){
                snakeMap.put(from, to);
            }
            if(from < to){
                ladderMap.put(from, to);
            }
        }

        bfs(snakeMap, ladderMap);
    }

    private static void bfs(Map<Integer, Integer> snakeMap, Map<Integer, Integer> ladderMap) {
        final int MAX = 100;
        final int DICE = 6;
        boolean[][] visited = new boolean[MAX + 1][MAX + 1];

        Queue<MoveInfo> queue = new LinkedList<>();
        queue.offer(new MoveInfo(1, 0));

        while(!queue.isEmpty()){
            MoveInfo nowInfo = queue.poll();
            int now = nowInfo.idx;
            int cnt = nowInfo.cnt;

            if(now == MAX) {
                System.out.println(cnt);
                return;
            }
            cnt++;

            for (int i = 1; i <= DICE; i++) {
                int next = now + i;
                if(next > MAX){
                    continue;
                }
                if(!visited[next][cnt]){
                    visited[next][cnt] = true;
                    if(ladderMap.containsKey(next)){
                        next = ladderMap.get(next);
                        visited[next][cnt] = true;
                    }
                    if(snakeMap.containsKey(next)){
                        next = snakeMap.get(next);
                        visited[next][cnt] = true;
                    }
                    queue.offer(new MoveInfo(next, cnt));
                }
            }
        }
    }
}
class MoveInfo {
    int idx;
    int cnt;

    MoveInfo(int idx, int cnt){
        this.idx = idx;
        this.cnt = cnt;
    }
}