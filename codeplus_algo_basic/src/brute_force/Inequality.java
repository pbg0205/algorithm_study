package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Inequality {
	
	static int[] number;
	static boolean[] visited;
	static char[] bracket;
	static int[] output;
	
	static List<String> result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		
		result = new ArrayList<String>();
		visited = new boolean[10];
		bracket = new char[k];
		output = new int[k + 1];
		
		number = new int[10];
		for (int idx = 0; idx <= 9; idx++)	number[idx] = idx;
			
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int idx = 0; idx < k; idx++)
			bracket[idx] = st.nextToken().charAt(0);
		
		permutation(number, output, visited, 0, 10, k + 1);
		
		System.out.println(result.get(result.size() - 1));
		System.out.println(result.get(0));
		
		br.close();
	}
	
	static void permutation(int[] number, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
        	if(is_ok(output, bracket)) {
        		addSequence(output, r);
        	}
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = number[i];
                permutation(number, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
	}
	
    private static void addSequence(int[] arr, int r) {
        String temp = "";
    	for (int i = 0; i < r; i++)
            temp += (arr[i]);
    	result.add(temp);
    }
	
	private static boolean is_ok(int[] output, char[] bracket) {
		for (int i = 0; i < bracket.length; i++) {
			if (bracket[i] == '>') {
				if (output[i] > output[i + 1])
					continue;
				else
					return false;
			}
			if (bracket[i] == '<') {
				if (output[i] < output[i + 1])
					continue;
				else
					return false;
			}
		}
		return true;
	}

}
