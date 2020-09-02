package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class coupon {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		ArrayList<coupons> al= new ArrayList<>();
		
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long season = Long.parseLong(st.nextToken());
			long normal = Long.parseLong(st.nextToken());
			System.out.println(season + " " + normal);
			System.out.println(new coupons(season, normal).getMaxCnt());
		}
		
	}
}

class coupons{
	long season;
	long normal;
	
	coupons(long season, long normal){
		this.season = season;
		this.normal = normal;
	}
	
	public long getMaxCnt() {
		
		long total = season + normal;
		long maxCnt = total / 12;
		long requiredSeason = maxCnt;
		
		if(requiredSeason - season / 5 > 0) {
			maxCnt = maxCnt - (requiredSeason - season/5);
		}	
			
		return maxCnt;
	}
}
