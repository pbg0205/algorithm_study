package baekjoon5052;
/*
 * @problem     전화번호 목록(5052)
 * @url         https://www.acmicpc.net/problem/5052
 * @author      pbg0205
 * @created by  10.13.20
 */

import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while(testCase-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] phoneNumber = new String[size];
            String result = "YES";

            for (int index = 0; index < size; index++) {
                phoneNumber[index] = br.readLine();
            }

            Arrays.sort(phoneNumber);

            for (int index = 0; index < size - 1; index++) {
                if(phoneNumber[index+1].startsWith(phoneNumber[index])){
                    result = "NO";
                    break;
                }
            }

            System.out.println(result);
        }

        br.close();
    }
}
