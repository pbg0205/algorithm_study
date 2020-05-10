package baekjoon_level5_8;

public class Pro_4673 {
	public int getDn(int n) {
		int dn = n;
		while( n > 0) {
			dn += n % 10;
			n /= 10;
		}
		return dn;
	}
	
	public boolean[] isNotSelfNum() {
		boolean[] isNotSelfNum = new boolean[10001];
		for (int i = 1; i <= 10000; i++) {
            int dn = getDn(i);
            if (dn <= 10000) {
                isNotSelfNum[dn] = true;             
            }
        }
         
        for (int i = 1; i < isNotSelfNum.length; ++i) {
            if (!isNotSelfNum[i]) {
                System.out.println(i);              
            }
        }
        return isNotSelfNum;
	}
	
	public static void main(String[] args) {
		Pro_4673 sol = new Pro_4673();
		sol.isNotSelfNum();
	}
}
