package programmers.src.level2.largest_square;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int rowLen = board.length;
        int colLen = board[0].length;

        if(rowLen <= 1 || colLen <= 1) {
            return 1;
        }

        for (int row = 1; row < rowLen; row++) {
            for (int col = 1; col < colLen; col++) {
                if(board[row][col] < 1) {
                    continue;
                }
                board[row][col] = Math.min(board[row - 1][col - 1],
                        Math.min(board[row - 1][col], board[row][col - 1])) + 1;
                answer = Math.max(answer, board[row][col]);
            }
        }

        return answer * answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        System.out.println(solution.solution(board));
    }
}
