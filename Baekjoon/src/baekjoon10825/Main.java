package baekjoon10825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * @Problem     국영수(10825)
 * @url         https://www.acmicpc.net/problem/10825
 * @Author      pbg0205
 * @Created by  09.02.20
 * @Explain
 *  - 객체에 Comparable의 method를 overriding하여 구현
 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Person[] arr = new Person[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int mat = Integer.parseInt(st.nextToken());

            arr[i] = new Person(name, kor, mat, eng);
        }

        Arrays.sort(arr);

        for (Person p : arr) {
            sb.append(p.name + "\n");
        }

        System.out.println(sb.toString());
    }
}

class Person implements Comparable<Person>{
    String name;
    int kor;
    int mat;
    int eng;

    Person(String name, int kor, int mat, int eng){
        this.name = name;
        this.kor = kor;
        this.mat = mat;
        this.eng = eng;
    }

    @Override
    public int compareTo(Person o) {
        if(this.kor > o.kor){
            return -1;
        }else if(this.kor == o.kor){
            if(this.eng < o.eng){
                return -1;
            }else if(this.eng == o.eng){
                if(this.mat > o.mat){
                    return -1;
                }else if(this.mat == o.mat){
                    return this.name.compareTo(o.name);
                }
            }
        }

        return 1;
    }
}
