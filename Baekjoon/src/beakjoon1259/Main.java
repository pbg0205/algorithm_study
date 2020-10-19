package beakjoon1259;
/*
 * @problem     팰린드롬수(1259)
 * @url         https://www.acmicpc.net/problem/1259
 * @author      pbg0205
 * @created by  10.19.20
 */

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String value = br.readLine();
        boolean isPalindrome;

        while(!value.equals("0")){
            int valueLen = value.length();
            isPalindrome = true;

            for (int i = 0; i < valueLen / 2; i++) {
                int left_number = value.charAt(i) - '0';
                int right_number = value.charAt(valueLen - (i+1)) - '0';

                if(left_number != right_number){
                    isPalindrome = false;
                }
            }

            if(isPalindrome){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }

            value = br.readLine();
        }

        br.close();
    }
}
