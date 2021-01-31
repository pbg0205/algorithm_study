package baekjoon16916;
/*
 * @Problem         부분문자열(16916)
 * @Author          pbg0205
 * @Created by      08.31.20
 * @Explain
 *  - KMP알고리즘을 이용한 탐색 문제.
 */

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String parent = br.readLine();
        String pattern = br.readLine();

        boolean isContain = KMP(parent, pattern);
        if(isContain){
            bw.write("1");
        }else{
            bw.write("0");
        }

        br.close();
        bw.flush();
        bw.close();
    }
    public static boolean KMP(String parent, String pattern){
        int[] table = makeTable(pattern);
        int parentSize = parent.length();
        int patternSize = pattern.length();

        int j = 0;
        for (int i = 0; i < parentSize; i++) {
            while(j > 0 && parent.charAt(i) != pattern.charAt(j)){
                j = table[j-1];
            }

            if(parent.charAt(i) == pattern.charAt(j)) {
                if (j == patternSize - 1) {
                    return true;
                } else {
                    j++;
                }
            }
        }

        return false;
    }

    public static int[] makeTable(String pattern){
        int patternSize = pattern.length();
        int[] table = new int[patternSize];

        int j = 0;
        for (int i = 1; i < patternSize; i++) {
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                j = table[j - 1];
            }

            if(pattern.charAt(i) == pattern.charAt(j)){
                table[i] = ++j;
            }
        }

        return table;
    }
}
