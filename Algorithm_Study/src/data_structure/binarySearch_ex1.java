package data_structure;

public class binarySearch_ex1 {
	public static int searchIdx(int[] a, int n, int key, int[] idx) {
		int key_count = 0;
		for (int a_i = 0; a_i < a.length; a_i++)	if(a[a_i] == key)	key_count++;	
		
		idx = new int[key_count];
		int idx_i = 0;
		for (int a_i = 0; a_i < a.length; a_i++)	if(a[a_i] == key)	idx[idx_i++] = a_i;	
		
		return idx[idx.length / 2];
	}

	public static void main(String[] args) {
		int[] a = {1, 9, 2, 9, 4, 6, 7, 9};
		int n = a.length;
		int[] idx = null;
		int key = 9;
		
		int search_answer = searchIdx(a, n, key, idx);
		System.out.println(search_answer);
	}
}
