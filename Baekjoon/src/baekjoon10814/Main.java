package baekjoon10814;

import java.io.*;
import java.util.*;

/*
 * @Problem     나이순 정렬(10814)
 * @url         https://www.acmicpc.net/problem/10814
 * @Author      pbg0205
 * @Created by  09.02.20
 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Info> pq = new PriorityQueue<>();

        int priority = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            pq.offer(new Info(age, name, ++priority));
        }

        while(!pq.isEmpty()){
            Info info = pq.poll();
            System.out.println(info.age + " " + info.name);
        }
    }
}

class Info implements Comparable<Info>{
    int age;
    String name;
    int priority;

    Info(int age, String name, int priority){
        this.age = age;
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Info o) {
        if(this.age < o.age){
            return -1;
        }else if(this.age == o.age){
            if(this.priority < o.priority){
                return -1;
            }else{
                return 1;
            }
        }else{
            return 1;
        }
    }
}
