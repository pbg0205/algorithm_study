package baekjoon_level5_8;

public class Pro_15596 {
	public long sum(int[] a) {
		long ans = 0;
		
		for(int i = 0 ; i < a.length ; i++) {
			ans += a[i];
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		Pro_15596 sol = new Pro_15596();
		int[] a = {1,2,3,4,5};
		long sumNum = sol.sum(a);
	}
}
