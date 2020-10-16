package baekjoon1316;

import java.io.*;

/*
 * @problem     그룹 단어 체커(1316)
 * @url         https://www.acmicpc.net/problem/1316
 * @author      pbg0205
 * @created by  10.16.20
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int GroupWordCount = 0;

        while(testCase-- > 0){
            String word = br.readLine();

            if(isGroupWord(word)){
                GroupWordCount++;
            }
        }

        System.out.println(GroupWordCount);

        br.close();
    }

    private static boolean isGroupWord(String word) {
        boolean[] alreadyAppear = new boolean[26];
        int prevAlphabet = 0;

        for (int index = 0; index < word.length(); index++) {
            int nowAlphabet = word.charAt(index);
            int alphabetIndex = nowAlphabet - 'a';

            if(prevAlphabet == nowAlphabet){
                continue;
            }

            if(alreadyAppear[alphabetIndex]){
                return false;
            }else{
                alreadyAppear[alphabetIndex] = true;
                prevAlphabet = nowAlphabet;
            }
        }

        return true;
    }
}
