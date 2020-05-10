package intermediate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.zip.InflaterInputStream;

public class Array1_view_d3 {
	public int viewCount(int testCase, String buildings) {
		int answer = 0;
		String[] building = buildings.split(" ");
		int[] buildingFloor = new int[building.length];
		
		for (int i = 0; i < building.length; i++) {
			buildingFloor[i] = Integer.parseInt(building[i]);
		}
		
		for(int i = 2; i < buildingFloor.length - 2 ; i++) { 
			int rightMax = buildingFloor[i-2];	int leftMax = buildingFloor[i+2];
			if(rightMax < buildingFloor[i-1]) {
				rightMax = buildingFloor[i-1];
			}
			
			if(leftMax < buildingFloor[i+1]) {
				leftMax = buildingFloor[i+1];
			}
			
			if(rightMax >= buildingFloor[i] || buildingFloor[i] <= leftMax) {
				continue;
			}
			
			if(rightMax - leftMax >= 0) {
				answer += buildingFloor[i] - rightMax;
			}else if(rightMax - leftMax < 0){
				answer += buildingFloor[i] - leftMax;
				
			}
		}
		
		
		
		return answer;
	}
	
	public static void main(String[] args) throws Exception, IOException {
		Array1_view_d3 lv1 = new Array1_view_d3();
		int index = 1;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			int test_case = Integer.parseInt(sc.nextLine());
			String buildings = sc.nextLine();
			System.out.println("#" + index++ + " " + lv1.viewCount(test_case, buildings));
		}
	}
}
