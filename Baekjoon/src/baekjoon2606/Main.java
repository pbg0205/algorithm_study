package Baekjoon.src.baekjoon2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static boolean[] getInfected;
    private static Map<Integer, List<Integer>> virusMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int nodeSize = Integer.parseInt(br.readLine());
        int linkCount = Integer.parseInt(br.readLine());

        getInfected = new boolean[nodeSize + 1];

        for (int i = 1; i <= nodeSize; i++) {
            virusMap.put(i, new ArrayList<>());
        }

        for (int i = 1; i <= linkCount; i++) {
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            virusMap.get(first).add(second);
            virusMap.get(second).add(first);
        }

        System.out.println(bfs(1));

        br.close();
    }

    private static int bfs(int start) {
        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        getInfected[start] = true;

        while(!queue.isEmpty()) {
            int nextNode = queue.poll();
            List<Integer> nodeList = virusMap.get(nextNode);

            for (Integer node : nodeList) {
                if(!getInfected[node]) {
                    queue.add(node);
                    getInfected[node] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
