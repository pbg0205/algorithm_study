package data_structure;

public class binary_Search_ex05 {
	public static int binSearch(int[] a, int n, int key) {
		int pl = 0;
		int pr = n-1;
		int first_idx = n;
		
		do {
			int pc = (pl + pr) / 2;
			if(a[pc] == key) {
				for (int i = pc; i >= 0; i--)	if(a[i] == key)	first_idx = i;
				return first_idx;
			}
			
			if(a[pc] > key)	pr = pc - 1;
			else	pl = pc + 1;
		
			
		}while(pl <= pr);
		
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] intArr = {1,3,5,7,7,7,7,8,8,9,9};
		int n = intArr.length;
		int key = 7;
		
		System.out.println(binSearch(intArr, n, key));
		
	}
}
