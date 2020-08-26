package queue_study;

import java.util.LinkedList;
import java.util.Queue;

public class truck_bridge {
	public static void main(String[] args) {
		truck_bridge t = new truck_bridge();

		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7, 4, 5, 6 };

		System.out.println(t.solution(bridge_length, weight, truck_weights));
	}

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Queue<Integer> bridge = new LinkedList<>();
		int weight_now = 0;
		
		for(int i = 0; i < truck_weights.length; i++) {
			while(true) {
				if(bridge.isEmpty()) {
					bridge.offer(truck_weights[i]);
					weight_now += truck_weights[i];
					answer++;
					break;
				}
				
				if(bridge.size() == bridge_length){
					weight_now -= bridge.poll();
				}
				
				if(bridge.size() < bridge_length){
					if(weight_now + truck_weights[i] > weight) {
						bridge.offer(0);
						answer++;
					}else {
						bridge.offer(truck_weights[i]);
						weight_now += truck_weights[i];
						answer++;
						break;
					}
				}
			}
		}
		answer += bridge_length;
		
		return answer;
	}
}
