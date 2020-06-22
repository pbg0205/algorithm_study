package data_structure;

public class binarySearch {
	public static int binarySearch(int[] intArr, int n, int key) {
		int pl = 0;
		int pr = n - 1;
		
		do {
			int pc = (pl + pr) /2;
			
			if(intArr[pc] == key)	return intArr[pc];
			
			if(intArr[pc] < key)	pl = pc + 1;
			else			pr = pc-1;
			
			
		}while(pl <= pr);
		
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] intArr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int n = intArr.length;
		int key = 5;
		
		int search_answer = binarySearch(intArr, n, key);
		System.out.println(search_answer);
	}
}
