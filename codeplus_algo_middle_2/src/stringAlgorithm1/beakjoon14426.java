package stringAlgorithm1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @Problem     접두사 찾기(14426)
 * @Author      pbg0205
 * @Created by  09.01.20
 *
 */

public class beakjoon14426 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;

        String[] parents = new String[n];
        String[] patterns = new String[m];

        for (int i = 0; i < n; i++) {
            parents[i] = br.readLine();
        }

        for (int i = 0; i < m; i++) {
            patterns[i] = br.readLine();
        }

        for (int i = 0; i < m; i++) {
            String pattern = patterns[i];
            for (int j = 0; j < n; j++) {
                String parent = parents[j];
                if(isContain(parent, pattern)){
                    cnt += 1;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }

    public static boolean isContain(String parent, String pattern){
        int patternSize = pattern.length();

        for (int i = 0; i < patternSize; i++) {
            if(pattern.charAt(i) == parent.charAt(i)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}
