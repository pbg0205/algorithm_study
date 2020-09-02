package codeplus.basic.dp1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class sumOf123_5 {
	    static int[][] dp;
	    static final int div = 1000000009;
	    static final int limit = 100000; //limit: 정수 n의 최댓값
	    
	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
	        
	        
	        
	        dp = new int[limit+1][4]; //dp[i][j]: 정수 i를 만드는데 마지막 자리의 숫자는 j인 방법의 개수
	        dp[1][1] = dp[2][2] = dp[3][3] = dp[3][1] = dp[3][2] = 1;
	        for(int i = 4; i<=limit; i++) {
	            for(int j = 1; j<=3; j++) {
	                //j가 1이면, 정수 i-1를 만드는데 마지막 자리의 숫자는 2 또는 3인 방법의 개수의 합
	                if(j==1) dp[i][j] = dp[i-1][2] + dp[i-1][3];
	                //j가 2이면, 정수 i-2를 만드는데 마지막 자리의 숫자는 1 또는 3인 방법의 개수의 합 
	                else if(j==2) dp[i][j] = dp[i-2][1] + dp[i-2][3]; 
	                //j가 3이면, 정수 i-1를 만드는데 마지막 자리의 숫자는 1 또는 2인 방법의 개수의 합
	                else dp[i][j] = dp[i-3][1] + dp[i-3][2]; 
	                dp[i][j] %= div;
	            }
	        }
	        
	        int test_case = Integer.parseInt(br.readLine().trim()); //T: 테스트 케이스의 개수
	        
	        for(int tc = 1; tc<=test_case; tc++) {
	            int n = Integer.parseInt(br.readLine().trim()); //n: 입력값
	            int ans = 0; //ans(출력값): 정수 n을 1,2,3의 합으로 나타내는 방법의 수
	            for(int i = 1; i<=3; i++) {
	                ans += dp[n][i];
	                ans %= div;
	            }
	            System.out.println(ans);
	        }
	    }
}
