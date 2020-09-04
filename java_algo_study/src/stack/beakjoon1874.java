package stack;


import com.sun.org.apache.xpath.internal.operations.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * @Problem      {스택수열(1874)}
 * @Author       {pbg0205}
 * @Created by   {08.30.20}
 */
public class beakjoon1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 1;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Character> results = new ArrayList<>();

        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        /*
         * 1. cnt <= data(입력 값): 입력 값까지 채워나간다.
         * 2. cnt > data(입력 값)
         *      - if(stack.peek() == data(입력 값)){stack.pop();}
         *      - else(stack.peek() != data(입력 값)){ NO !}
         */
        for (int i = 0; i < tc; i++) {
            int data = Integer.parseInt(st.nextToken());

            while(cnt <= data){
                stack.push(cnt);
                cnt += 1;
                results.add('+');
            }

            if(stack.peek() == data){
                stack.pop();
                results.add('-');
            }else{
                System.out.println("NO");
                return ;
            }
        }

        /*성공 시, 결과 출력*/
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }
}
