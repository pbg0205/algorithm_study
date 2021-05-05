package programmers.src.level2.ground_pick;

public class Solution {

    private static int max = Integer.MIN_VALUE;
    private static final int COL_SIZE = 4;

    int solution(int[][] land) {
        boolean[] isVisited = new boolean[COL_SIZE];

        backTracking(0, 0, isVisited, land);

        return max;
    }

    private void backTracking(int row, int max_temp, boolean[] isVisited, int[][] land) {
        if (row >= land.length) {
            max = Math.max(max, max_temp);
            return;
        }

        for (int col = 0; col < COL_SIZE; col++) {
            if (isVisited[col]) {
                continue;
            }

            isVisited[col] = true;
            backTracking(row + 1, max_temp + land[row][col], isVisited, land);
            isVisited[col] = false;
        }
    }

    public static void main(String[] args) {
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};

        Solution solution = new Solution();
        System.out.println(solution.solution(land));
    }
}
