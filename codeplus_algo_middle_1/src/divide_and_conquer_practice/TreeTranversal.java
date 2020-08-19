package divide_and_conquer_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeTranversal {
	
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int[] inOrder;
	static int[] inOrder_idx;
	static int[] postOrder;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		inOrder = new int[n+1];
		inOrder_idx = new int[n+1];
		postOrder = new int[n+1];

		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		for (int idx = 1; idx <= n; idx++)
			inOrder[idx] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int idx = 1; idx <= n; idx++)
			postOrder[idx] = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= n; i++)	
			inOrder_idx[inOrder[i]] = i;
		
		getPreOrder(1, n, 1, n);
		System.out.println(sb.toString());
	}

	private static void getPreOrder(int in_start, int in_end, int post_start, int post_end) {
		if(in_start > in_end || post_start > post_end)
			return ;
		
		int root = postOrder[post_end];
		sb.append(root + " ");
		
		int rootIdx = inOrder_idx[root];
		int left = rootIdx - in_start;
		
		getPreOrder(in_start, rootIdx + 1, post_start, post_start + left - 1);
		getPreOrder(rootIdx + 1, in_end, post_start + left, post_end - 1);
	}
}


/*
 * 참고 문헌
 * - https://pangsblog.tistory.com/47
 * - https://ukyonge.tistory.com/161
 * 
 */