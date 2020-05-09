package intermediate;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Array1_flattern_D3 {

	public static void main(String[] args) {
		Array1_flattern_D3 sol = new Array1_flattern_D3();
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {
			int dump_num = Integer.parseInt(sc.nextLine());
			int[] box = new int[101];

			StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
			int idx = 1;
			while (st.hasMoreElements()) {
				box[idx++] = Integer.parseInt(st.nextToken());
			}

			int[] count_box = sol.getCountingSort(box);
			int left_idx = 0;
			int right_idx = 100;

			System.out.println("#" + i + " " + sol.getFlattern(count_box, dump_num, left_idx, right_idx));

		}
		sc.close();
	}

	public int getFlattern(int[] count_box, int dump_num, int left_idx, int right_idx) {
		int ans = -1;
		
		for (int i = 0; i <= dump_num; i++) {
			
			left_idx = getLeftIdx(count_box, left_idx);
			right_idx = getRightIdx(count_box, right_idx);
			
			count_box = getDump(count_box, left_idx, right_idx);
		}
		ans = right_idx - left_idx;
		return ans;
	}
	
	public int[] getCountingSort(int[] box) {
		int[] counts = new int[101];
		for (int i = 1; i <= 100; i++) {
			counts[box[i]]++;
		}

		return counts;
	}
	
	public int getLeftIdx(int[] count_box, int left_idx) {
		while (count_box[left_idx] == 0)
			left_idx++;
		return left_idx;
	}

	public int getRightIdx(int[] count_box, int right_idx) {
		while (count_box[right_idx] == 0)
			right_idx--;
		return right_idx;
	}

	public int[] getDump(int[] count_box, int left_idx, int right_idx) {
		count_box[right_idx]--;
		count_box[right_idx - 1]++;
		count_box[left_idx]--;
		count_box[left_idx + 1]++;

		return count_box;
	}
}
