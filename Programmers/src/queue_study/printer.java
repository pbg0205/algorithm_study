package queue_study;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class printer {
	public static void main(String[] args) {
		printer p = new printer();
		int[] priorities = {2, 1, 3, 2};
		int location = 2;
		
		int[] priorities2 = {1, 1, 9, 1, 1, 1};
		int location2 = 0;
		
		
		
		System.out.println(p.solution(priorities2, location2));
		
	}
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<print> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int idx = 0; idx < priorities.length; idx++) {
        	int priority = priorities[idx];
        	q.offer(new print(idx, priority));
        	pq.offer(-priority); 
        }
        
        while(true) {
        	print p = q.poll();
        	
        	if(p.priority == -pq.peek()) {
        		answer++;
        		pq.poll();
        		
        		if(p.index == location) {
        			return answer;
        		}
        	}else {
        		q.add(new print(p.index, p.priority));
        	}
        }
    }
}
class print{
	int index;
	int priority;
	
	print(int index, int priority){
		this.index = index;
		this.priority = priority;
	}
}