package binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * @Problem		{좌표 정렬하기(11650)}
 * @Author		{pbg0205}
 * @Create by	{08.24.2020}
 * @Time		{PM 07:37}
 * 
*/
public class baekjoon11650 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Location> pq = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			pq.offer(new Location(x, y));
		}
		
		while(!pq.isEmpty()) {
			Location location = pq.poll();
			bw.write(String.valueOf(location.x + " " + location.y + "\n"));
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
class Location implements Comparable<Location>{
	int x;
	int y;
	
	Location(int x, int y){
		this.x = x;
		this.y = y;
	}

	/*
	 * @method명		comparTo
	 * @사용 방법		1. 비교하고 싶은 객체 혹은 변수를  매개변수에 추가.
	 * 				2. return value
	 * 					(1) 양수		: 자리 바꿈
	 * 					(2) 0 또는 음수	: 자리변경 X
	 */
	@Override
	public int compareTo(Location location) {
		if(this.x > location.x) {
			return 1;	/* 오름차순 정렬 시*/
		}else if(this.x == location.x){
			return (this.y > location.y )? 1 : -1;
		}else {
			return -1;
		}
	}
}
