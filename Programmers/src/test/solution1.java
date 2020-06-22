package test;

public class solution1 {
    public int solution(int p) {
    	int answer = p;
    	
    	boolean beautiful_flag = true;
    	
    	while(beautiful_flag){
    		boolean same_flag = false;
        	int year = ++p;
        	int idx = 0;
        	int[] numArr = new int[(int)Math.log10(p) + 1];
        
	        for(;year > 0;year /= 10) {
	        	numArr[idx++] = (year % 10);
	        }
	        
	        for (int i = 0; i < numArr.length - 1; i++) {
				for(int j = i + 1; j < numArr.length; j++) {
					System.out.println();
					if(numArr[i] == numArr[j]) {
						same_flag = true;
					}
				}
			}
	        if(same_flag == false)	beautiful_flag = false;
        }
    	
    	answer = p;
        
        return answer;
    }
    
    public static void main(String[] args) {
		solution1 sol = new solution1();
		sol.solution(2015);
	}

}
