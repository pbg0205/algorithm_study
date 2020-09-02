package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * @Problem      좌표 정렬하기2(11651)
 * @Author       pbg0205
 * @Created by   09.02.20
 *
 */

public class baekjoon11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<location> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pq.offer(new location(x, y));
        }

        while(!pq.isEmpty()){
            location l = pq.poll();
            System.out.println(l.x + " " + l.y);
        }
    }
}

class location implements Comparable<location>{
    int x;
    int y;

    location(int x, int y){
        this.x = x;
        this.y = y;
    }


    @Override
    public int compareTo(location o) {
        if(this.y > o.y){
            return 1;
        }else if(this.y == o.y){
            if(this.x < o.x){
                return -1;
            }else{
                return 1;
            }
        }else{
            return -1;
        }
    }
}
