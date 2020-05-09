package intermediate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Array1_mode_D2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			int test_num = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int[] counts = new int[101];
			while (st.hasMoreElements()) {
				int score = Integer.parseInt(st.nextToken());
				counts[score]++;
			}

			int max_value = counts[0];
			int max_index = 0;
			for (int j = 0; j < counts.length; j++) {
				if (counts[j] >= max_value) {
					max_value = counts[j];
					max_index = j;
				}
			}
			System.out.println("#" + i + " " + max_index);
		}
	}

}
