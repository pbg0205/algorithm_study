package Pro_Level1;

import java.util.*;

class Solution {
	  public String solution(String s) {
	      char[] arr = s.toCharArray();
	      Arrays.sort(arr);
	      
	      return new StringBuilder(new String(arr)).reverse().toString();
	  }
  public static void main(String[] args) {
	String line = "Zbcdefg";
	
	Solution sol = new Solution();
	System.out.println(sol.solution(line));
	
  }
}