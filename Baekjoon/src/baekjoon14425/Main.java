package baekjoon14425;
/*
 * @Problem     문자열 집합(14425)
 * @Author      pbg0205
 * @Created by  09.02.20
 */

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), 1);
        }

        for(int i = 0;  i < m; i++){
            String pattern = br.readLine();
            if(map.get(pattern) != null){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
