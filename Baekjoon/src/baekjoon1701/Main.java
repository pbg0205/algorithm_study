package baekjoon1701;

/*
 * @Problem     Cubeditor(1701)
 * @Author      pbg0205
 * @Created by  09.01.20
 *
 */
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int strSize = str.length();
        int max = 0;

        for (int i = 0; i < strSize; i++) {
            max = Math.max(max, makeTable(str.substring(i, strSize)));
        }

        System.out.println(max);
    }

    public static int makeTable(String pattern){
        int patternSize = pattern.length();
        int[] table = new int[patternSize];
        int max = 0;

        int j = 0;
        for (int i = 1; i < patternSize; i++) {
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                j = table[j-1];
            }

            if(pattern.charAt(i) == pattern.charAt(j)){
                table[i] = ++j;
                max = Math.max(max, table[i]);
            }
        }

        return max;
    }
}
