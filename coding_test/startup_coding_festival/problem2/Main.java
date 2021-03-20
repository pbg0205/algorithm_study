package coding_test.startup_coding_festival.problem2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static int n;
    private static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String path = br.readLine();

        dfs(1, path);
        System.out.println(count);
    }

    private static void dfs(int location, String path) {
        if (location >= n) {
            if (location == n) {
                count++;
            }
            return;
        }

        if (path.charAt(location - 1) == '1') {
            dfs(location + 1, path);
            dfs(location + 2, path);
        }
    }
}
