package baekjoon11725;
/*
 * @Problem     트리의 부모 찾기(11725)
 * @Author      pbg0205
 * @Created by  09.07.20
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> list = new ArrayList<>();
        int[] parents = new int[n+1];

        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        parents[1] = 1;
        //bfs(1, list, parents);
        dfs(list, parents, 1, 0);
        printAnswer(parents);
    }

    public static void bfs(int start, List<List<Integer>> list, int[] parents){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int parent = queue.poll();

            for (Integer item: list.get(parent)) {
                if(parents[item] == 0){
                    parents[item] = parent;
                    queue.offer(item);
                }
            }
        }
    }

    public static void dfs(List<List<Integer>> list,int[] parents ,int start, int parent){
        parents[start] = parent;
        for (int item : list.get(start)) {
            if(item != parent){
                dfs(list, parents, item, start);
            }
        }
    }

    public static void printAnswer(int[] parents){
        for (int i = 2; i < parents.length; i++) {
            System.out.println(parents[i]);
        }
    }
}
