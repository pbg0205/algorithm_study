package baekjoon1068;
/*
 * @problem     트리(1068) : https://www.acmicpc.net/problem/1068
 * @author      pbg0205
 * @created by  10.08.20
 */

import java.io.*;
import java.util.*;

class Main {

    static List<Integer>[] childNodes;
    static int[] status;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfNode = Integer.parseInt(br.readLine());

        int[] parent = new int[numberOfNode];
        childNodes = new ArrayList[numberOfNode];
        status = new int[numberOfNode];
        int leafNodeCount = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int index = 0; index < numberOfNode; index++) {
            parent[index] = Integer.parseInt(st.nextToken());
            childNodes[index] = new ArrayList<>();
        }

        for (int index = 0; index < numberOfNode; index++) {
            int parentNode = parent[index];
            if (parentNode == -1) {
                continue;
            }

            childNodes[parentNode].add(index);
        }

        for (int index = 0; index < numberOfNode; index++) {
            if (childNodes[index].size() == 0) {
                status[index] = -1;
            }
        }

        int removeNode = Integer.parseInt(br.readLine());

        //하위노드 leafNode 상태 해제
        BFS(removeNode);

        //부모노드 leaf노드 여부 변경 여부 확인
        if(parent[removeNode] != -1 && childNodes[parent[removeNode]].size() == 1){
            status[parent[removeNode]] = -1;
        }

        for (Integer Node: status) {
            if(Node == -1){
                leafNodeCount++;
            }
        }

        System.out.println(leafNodeCount);

        br.close();
    }

    private static void BFS(int removeNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(removeNode);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            status[now] = 0;

            for (Integer child : childNodes[now]) {
                status[child] = 0;
                queue.offer(child);
            }
        }
    }
}
