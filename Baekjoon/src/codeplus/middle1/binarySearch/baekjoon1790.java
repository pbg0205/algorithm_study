package codeplus.middle1.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @Problem		{수 이어 쓰기2(1790)}
 * @Author		{pbg0205}
 * @Create by	{08.24.2020}
 * @Time		{PM 06:51}
 * 
*/
public class baekjoon1790 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		long finalNum = 0;
		long tmp = k;
		long cntLength = 1;
		long cntNum = 9;
		
        while (tmp > cntLength * cntNum) {
            tmp = tmp - (cntLength * cntNum);
            finalNum = finalNum + cntNum;
            cntLength++;
            cntNum *= 10;
        }
		
		finalNum = (finalNum + 1) + (tmp - 1) / cntLength;
		
		if(finalNum > n) {
			System.out.println(-1);
		}else {
            System.out.println(String.valueOf(finalNum).charAt((int) ((tmp - 1) % cntLength)));
		}
	}
}
