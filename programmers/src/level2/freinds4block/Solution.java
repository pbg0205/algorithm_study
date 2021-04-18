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

    private int checkBlock(int m, int n, char[][] map) {
        int cnt = 0;
        boolean[][] isChecked = new boolean[m][n];

        for (int i = 0; i < m - 1; ++i) {
            for (int j = 0; j < n - 1; ++j) {
                if (map[i][j] == '.') continue;
                checkSquare(i, j, map, isChecked);
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (isChecked[i][j]) {
                    cnt++;
                    map[i][j] = '.';
                }
            }
        }

        return cnt;
    }

    private void dropBlocks(int m, int n, char[][] map) {
        for (int col = 0; col < n; ++col) {
            for (int row = m - 1; row >= 0; --row) {
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

    private void checkSquare(int i, int j, char[][] map, boolean[][] isChecked) {
        char block = map[i][j];

        for (int row = i; row < i + SQUARE_SIZE; ++row) {
            for (int col = j; col < j + SQUARE_SIZE; ++col) {
                if (map[row][col] != block) {
                    return;
                }
            }
        }

        for (int row = i; row < i + SQUARE_SIZE; row++) {
            for (int col = j; col < j + SQUARE_SIZE; col++) {
                isChecked[row][col] = true;
            }
        }
    }
}
