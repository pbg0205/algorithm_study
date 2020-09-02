package codeplus.middle1.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon11664 {
	
	static xyz[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new xyz[3];
		for (int i = 0; i < 3; i++) {
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
		
			arr[i] = new xyz(x, y, z);
		}
		
		double ans = Double.MAX_VALUE;
		
		int lx = arr[0].x;
		int rx = arr[1].x;
		
		int ly = arr[0].y;
		int ry = arr[1].y;

		int lz = arr[0].z;
		int rz = arr[1].z;
		
		while(true) {
			int mx = (lx + rx) / 2;
			int my = (ly + ry) / 2;
			int mz = (lz + rz) / 2;
			
			double l = Math.sqrt(Math.pow((lx-arr[2].x),2))
					+ Math.sqrt(Math.pow((ly-arr[2].y),2))
			 		+ Math.sqrt(Math.pow((lz-arr[2].z),2));
	
			double h = Math.sqrt(Math.pow((mx-arr[2].x),2))
					+ Math.sqrt(Math.pow((my-arr[2].y),2))
			 		+ Math.sqrt(Math.pow((mz-arr[2].z),2));
			
			double r = Math.sqrt(Math.pow((rx-arr[2].x),2))
					+ Math.sqrt(Math.pow((ry-arr[2].y),2))
			 		+ Math.sqrt(Math.pow((rz-arr[2].z),2));
			
			if(Math.abs(h) - ans <= 0.00000000001) {
				break;
			}
			
			if(h < ans) {
				ans = (int) h;
			}
			
			if(l > r) {
				lx = mx;
				ly = my;
				lz = mz;
			}else {
				rx = mx;
				ry = my;
				rz = mz;
			}
		}
	}
}

class xyz{
	int x;
	int y;
	int z;
	
	xyz(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}