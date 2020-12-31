package baekjoon2447;

import java.util.*;

class Main {

    private static char[][] starArray;
    private static final int THREE = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        starArray = new char[n][n];

        for (char[] rowArray : starArray) {
            Arrays.fill(rowArray, ' ');
        }

        recur_star(0, 0, n);

        for (char[] stars : starArray) {
            System.out.println(stars);
        }
    }

    private static void recur_star(int now_row, int now_col, int size) {
        int dividedNum;

        if(size == 1) {
            starArray[now_row][now_col] = '*';
            return;
        }

        dividedNum = size / THREE;

        for (int next_row = 0; next_row < THREE; next_row++) {
            for (int next_col = 0; next_col < THREE; next_col++) {
                if(next_row == 1 && next_col == 1) {
                    continue;
                }
                recur_star(now_row + dividedNum * next_row,
                        now_col + dividedNum * next_col,
                        dividedNum);
            }
        }
    }
}
