package baekjoon12015;
/*
 * @problem		가장 긴 증가하는 부분 수열 2(12015)
 * @url			https://www.acmicpc.net/problem/12015
 * @author		pbg0205
 */


import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
    	int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new ArrayList<>();
        list.add(0);

        //이진 탐색을 이용한 풀이
        for(int idx = 0 ; idx < n; idx++) {
            int value = arr[idx] = Integer.parseInt(st.nextToken());
            if(value > list.get(list.size() - 1)) list.add(value);
            else{
                int left = 0;
                int right = list.size() - 1;

                while(left < right){
                    int mid = (left + right) >> 1;
                    if(list.get(mid) >= value){
                        right = mid;
                    }else{
                        left = mid + 1;
                    }
                }
                list.set(right, value);
            }
        }
        System.out.println(list.size() - 1);
    }

}