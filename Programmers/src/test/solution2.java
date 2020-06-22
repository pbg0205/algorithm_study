package test;

import java.util.LinkedList;
import java.util.Queue;

public class solution2 {
    public long solution(long n) {
        long answer = 0;
        
        Queue<Long> queue = new LinkedList<>();
        while(n > 0) {
        	queue.add(n % 2);
        	n /= 2;
        }
        
        long add = 1;
        
        while(!queue.isEmpty()) {
        	answer += queue.poll() * add;
        	add *= 3;
        }
        
        System.out.println(answer);
        
        return answer;
    }
    
    public static void main(String[] args) {
		solution2 sol = new solution2();
		sol.solution(4);
	}
}
