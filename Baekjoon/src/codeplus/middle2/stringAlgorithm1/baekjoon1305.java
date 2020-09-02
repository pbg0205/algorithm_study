package codeplus.middle2.stringAlgorithm1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * @Problem     광고(1305)
 * @Author      pbg0205
 * @Created by  09.02.20
 *
 */
public class baekjoon1305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String pattern = br.readLine();
        int[] table = makeTable(pattern);

        System.out.println(n - table[n-1]);
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
