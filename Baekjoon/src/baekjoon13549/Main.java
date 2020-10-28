package baekjoon13549;
/*
 * @problem		숨바꼭질 3(13549) : https://www.acmicpc.net/problem/13549
 * @author		pbg0205
 */

import java.io.*;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    static int n, k;

    public static void main(String[] args) throws IOException {
    	st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int minvalue = solve();
        System.out.println(minvalue);

        br.close();
    }

    private static int solve() {
        return iterateByQueue();
    }

    private static int iterateByQueue() {
        Queue<location_info> queue = initQueue();
        boolean[] visited = new boolean[100002];

        return bfsByQueue(queue, visited);
    }

    private static Queue<location_info> initQueue() {
        Queue<location_info> queue = new LinkedList<>();
        queue.add(new location_info(n, 0));

        return queue;
    }

    private static int bfsByQueue(Queue<location_info> queue, boolean[] visited) {
        int minValue = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            location_info li = queue.poll();

            if (li.location == k) {
                return  Math.min(minValue, li.time);
            }

            if (visited[li.location]) continue;
            visited[li.location] = true;

            //x - 1
            queue = check(queue, visited, li);
        }

        return -1;
    }

    private static Queue<location_info> check(Queue<location_info> queue,
                                              boolean[] visited,
                                              location_info li) {
        int forWard = li.location - 1;
        int mutiply = li.location * 2;
        int backward = li.location + 1;

        if (isBoundary(forWard) && !visited[forWard]){
            queue.add(new location_info(forWard, li.time + 1));
        }
        //x * 2
        if (isBoundary(mutiply) && !visited[mutiply]){
            queue.add(new location_info(mutiply, li.time));
        }
        //x + 1
        if (isBoundary(backward) && !visited[backward]){
            queue.add(new location_info(backward, li.time + 1));
        }

        return queue;
    }

    private static boolean isBoundary(int location) {
        return (0 <= location && location <= 100000);
    }

}

class location_info {
    int location;
    int time;

    public location_info(int location, int time) {
        this.location = location;
        this.time = time;
    }
}