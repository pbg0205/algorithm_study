package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * @Problem     거스름돈(14916)
 * @Author      pbg0205
 * @Created by  09.08.20
 *
 */

public class bakjoon14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int numberOfCoin = 0;
        int min = Integer.MAX_VALUE;

        int fiveWon = 5;
        int twoWon = 2;

        int dividedByFive = n / fiveWon;
        boolean isDivided = false;

        do{
            int n_tmp = n - dividedByFive * fiveWon;
            if(n_tmp % 2 == 0){
                int dividedByTwo = n_tmp / twoWon;
                min = Math.min(min, dividedByFive + dividedByTwo);
                isDivided = true;
            }
        }while(--dividedByFive >= 0);


        if(isDivided){
            System.out.println(min);
        }else{
            System.out.println(-1);
        }

    }
}
