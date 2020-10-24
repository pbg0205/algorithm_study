package baekjoon1305;

import java.io.*;

/*
 * @Problem     광고(1305)
 * @Author      pbg0205
 * @Created by  09.02.20
 *
 */
class Main {
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
