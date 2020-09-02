package codeplus.middle2.stringAlgorithm1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * @Problem         찾기(1786)
 * @Author          pbg0205
 * @Created by      08.31.20
 * @Explain
 *  - KMP알고리즘을 이용한 탐색 문제.
 */
public class beakjoon1786 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String parent = br.readLine();
        String pattern =br.readLine();

        KMP(parent, pattern);


        br.close();
    }

    public static void KMP(String parent, String pattern){
        int[] table = makeTable(pattern);

        int parentSize = parent.length();
        int patternSize = pattern.length();

        int j = 0;
        int cnt = 0;                           /*일치하는 pattern 갯수*/
        StringBuilder sb = new StringBuilder();/*일치하는 인덱스 위치*/

        for (int i = 0; i < parentSize; i++) {
            while( j > 0 && parent.charAt(i) != pattern.charAt(j)){
                j = table[j - 1];
            }

            if(parent.charAt(i) == pattern.charAt(j)){
                if(j == patternSize - 1){
                    cnt++;
                    sb.append((i - patternSize + 2) + " ");
                    j = table[j];
                }else{
                    j++;
                }
            }
        }

        if(cnt == 0){
            System.out.println("0");
        }else{
            System.out.println(cnt);
            System.out.println(sb.toString());
        }
    }

    public static int[] makeTable(String pattern){
        int patternSize = pattern.length();
        int[] table = new int[patternSize];

        int j = 0;
        for (int i = 1; i < patternSize; i++) {
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                j = table[j-1];
            }

            if(pattern.charAt(i) == pattern.charAt(j)){
                table[i] = ++j;
            }
        }
        return table;
    }
}