package codeplus.middle1.divide_and_conquer_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
 * 별찍기11(1074)
 * - 분할정복을 이용해서 별찍기
 * - sysout으로 별찍을 시, 시간초과 주의
 * 
 */
public class star11 {
	   private static char[][] map;
	   
	    public static void main(String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        
	        int n = Integer.parseInt(br.readLine());
	        
	        map = new char[n][2 * n - 1];
	        for (int i = 0; i<n; i++)
	            for (int j = 0; j < 2 * n - 1; j++)
	                map[i][j] = ' ';
	        
	        drawStar(0, n-1, n);
	        
	        for (int i = 0; i<n; i++) {
	            for (int j = 0; j < 2*n-1; j++)
	                bw.write(map[i][j]);
	            bw.write("\n");
	        }
	        
	        br.close();
	        bw.flush();
	        bw.close();
	    }
	 
	    private static void drawStar(int x, int y, int n) {
	        if (n == 3) {
	            map[x][y] = '*';
	            map[x + 1][y - 1] = map[x + 1][y + 1] = '*';
	            map[x + 2][y - 2] = map[x + 2][y - 1] = map[x + 2][y] = map[x + 2][y + 1] = map[x + 2][y + 2] = '*';
	            return;
	        }
	 
	        drawStar(x, y, n / 2); 				   //윗 삼각형
	        drawStar(x + n / 2, y - n / 2, n / 2); //아래 왼쪽 삼각형
	        drawStar(x + n / 2, y + n / 2, n / 2); //아래 오른쪽 삼각형
	    }
}
