package queue_study;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class scoville {
	public static void main(String[] args) {
		scoville s = new scoville();
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int[] scoville2 = {0, 0, 0, 0};
		int K = 7;
		int K2 = 0;
		System.out.println(s.solution(scoville2, K2));
		
	}
	
    public int solution(int[] scoville, int K) {
    	int answer = 0;
    	
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	for (int i = 0; i < scoville.length; i++)
			pq.offer(scoville[i]);
		
    	while(pq.size() > 1) {
    		if(pq.peek() >= K)
    			break;
    		
    		int low_first = pq.poll();
        	int low_second = pq.poll();
        	
        	int scoville_result = low_first + (low_second * 2);
        	pq.offer(scoville_result);
        	
        	answer++;
    	}
    	
    	if(pq.poll() >= K)
    		return answer;
    	
    	
    	return -1;
    }	
}
