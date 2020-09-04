package sorting;

import java.io.*;
import java.util.*;
/*
 * @Problem     카드(11652)
 * @Author      pbg0205
 * @Created by  09.04.20
 *
 */

public class baekjoon11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();
        int max_cnt = 1;
        long max_value = 0;

        for (int i = 0; i < n; i++) {

            long key = Long.parseLong(br.readLine());

            if(map.containsKey(key)){

                int val = map.get(key) + 1;

                map.put(key, val);

                if(max_cnt == map.get(key)){
                    max_value = Math.min(max_value, key);
                } else if (max_cnt < map.get(key)) {
                    max_cnt = map.get(key);
                    max_value = key;
                }

            }else{
                map.put(key, 1);

                if(map.size() == 1){
                    max_value = key;
                }

               if(max_cnt == 1){
                   max_value = Math.min(max_value, key);
               }
            }
        }

        System.out.println(max_value);

        br.close();
    }
}
