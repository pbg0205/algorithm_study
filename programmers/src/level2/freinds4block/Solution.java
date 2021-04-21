package programmers.src.level2.freinds4block;

class Solution {
    private char[][] map;
    private int SQUARE_SIZE = 2;

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        initMap(m, n, board);

        while (true) {
            int cnt = checkBlock(m, n, map);
            if (cnt == 0) {
                break;
            }
            answer += cnt;

            dropBlocks(m, n, map);
        }

        return answer;
    }

    private void initMap(int m, int n, String[] board) {
        map = new char[m][n];

        for (int row = 0; row < m; row++) {
            map[row] = board[row].toCharArray();
        }
    }

    private int checkBlock(int rowSize, int colSize, char[][] map) {
        int cnt = 0;
        boolean[][] isChecked = new boolean[rowSize][colSize];

        for (int row = 0; row < rowSize - 1; ++row) {
            for (int col = 0; col < colSize - 1; ++col) {
                if (map[row][col] == '.') continue;
                checkSquare(row, col, map, isChecked);
            }
        }

        for (int row = 0; row < rowSize; ++row) {
            for (int col = 0; col < colSize; ++col) {
                if (isChecked[row][col]) {
                    cnt++;
                    map[row][col] = '.';
                }
            }
        }

        return cnt;
    }

    private void dropBlocks(int rowSize, int colSize, char[][] map) {
        for (int col = 0; col < colSize; ++col) {
            for (int row = rowSize - 1; row >= 0; --row) {
                if (map[row][col] != '.') {
                    continue;
                }

                for (int nowRow = row - 1; nowRow >= 0; --nowRow) {
                    if (map[nowRow][col] != '.') {
                        map[row][col] = map[nowRow][col];
                        map[nowRow][col] = '.';
                        break;
                    }
                }
            }
        }
    }

    private void checkSquare(int nowRow, int nowCol, char[][] map, boolean[][] isChecked) {
        char block = map[nowRow][nowCol];

        for (int row = nowRow; row < nowRow + SQUARE_SIZE; ++row) {
            for (int col = nowCol; col < nowCol + SQUARE_SIZE; ++col) {
                if (map[row][col] != block) {
                    return;
                }
            }
        }

        for (int row = nowRow; row < nowRow + SQUARE_SIZE; row++) {
            for (int col = nowCol; col < nowCol + SQUARE_SIZE; col++) {
                isChecked[row][col] = true;
            }
        }
    }
}
