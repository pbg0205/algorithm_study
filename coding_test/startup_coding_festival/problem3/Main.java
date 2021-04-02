package coding_test.startup_coding_festival.problem3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[][] map = new int[size][size];

        for (int row = 0; row < size; row++) {
            String line = br.readLine();
            for (int col = 0; col < size; col++) {
                map[row][col] = line.charAt(col) - '0';
            }
        }

        solution(map);
        int[] result = setResult(map);

        System.out.println("total: " + sum(result));

        for (int i = 1; i <= size; i++) {
            if(result[i] == 0) {
                continue;
            }
            System.out.printf("size[%d]: %d\n",i ,result[i]);
        }
    }

    private static int sum(int[] result) {
        int answer = 0;
        for (int i : result) {
            answer += i;
        }
        return answer;
    }

    private static int[] setResult(int[][] map) {
        int[] result = new int[51];

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col] == 0) {
                    continue;
                }

                for (int i = 1; i <= map[row][col]; i++) {
                    result[i]++;
                }
            }
        }

        return result;
    }

    public static void solution(int[][] board) {
        int rowLen = board.length;
        int colLen = board[0].length;

        for (int row = 1; row < rowLen; row++) {
            for (int col = 1; col < colLen; col++) {
                if (board[row][col] < 1) {
                    continue;
                }

                board[row][col] = Math.min(board[row - 1][col - 1],
                        Math.min(board[row - 1][col], board[row][col - 1])) + 1;
            }
        }
    }
}

// 0 1 2 2
// 1 1 2 2
// 2 2 2 3
