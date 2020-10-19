package baekjoon1157;

import java.io.*;

/*
 * @problem     단어공부(1157)
 * @url         https://www.acmicpc.net/problem/1157
 * @author      pbg0205
 * @created by  10.19.20
 */
class Main {

    static final int ALPHABET_SIZE = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String value = br.readLine();
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = 0;
        int maxCount = 0;

        char[] valueCharArr = value.toCharArray();
        int[] alphaIndexArray = new int[ALPHABET_SIZE];

        for(char alphabet : valueCharArr){
            int alphabetIndex;

            if('a' <= alphabet && alphabet <='z'){
                alphabetIndex = alphabet -'a';
                alphaIndexArray[alphabetIndex]++;
            }

            if('A' <= alphabet && alphabet <='Z'){
                alphabetIndex = alphabet -'A';
                alphaIndexArray[alphabetIndex]++;
            }
        }

        for(int index = 0; index < ALPHABET_SIZE; index++){
            if(alphaIndexArray[index] > maxValue){
                maxValue = alphaIndexArray[index];
                maxIndex = index;
            }
        }

        for (int alphaIndex : alphaIndexArray){
            if(alphaIndex == maxValue){
                maxCount++;
            }
        }

        if(maxCount == 1) {
            System.out.println((char) (maxIndex + 'A'));
        }else{
            System.out.println("?");
        }
        br.close();
    }
}
