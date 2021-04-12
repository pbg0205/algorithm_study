package programmers.src.level3.match_pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    private static final int INF = 99999999;
    private static final int BOARD_SIZE = 4;

    private static final int[][] dxy = {{-1, 0}, {1, 0}, {0,-1}, {0, 1}};

    private int[][] Board;

    public int solution(int[][] board, int r, int c) {
        Board = board;

        return permutation(new Point(r, c, 0));
    }

    public int permutation(Point nowPoint) {
        int result = INF;
        //1. 원소가 1부터 6까지 주어지므로
        for (int num = 1; num <= 6; num++) {
            List<Point> cards = new ArrayList<>();

            //2. map을 탐색한다. -> 해당 num의 위치를 탐색한다.
            for (int row = 0; row < BOARD_SIZE; row++) {
                for (int col = 0; col < BOARD_SIZE; col++) {
                    if (Board[row][col] == num) {
                        cards.add(new Point(row, col, 0));
                    }
                }
            }

            //3. 카드가 비어있으면 skip
            if (cards.isEmpty()) {
                continue;
            }

            //4. 게임판에 숫자가 남아있을 경우, 0->1까지 최소거리/1->0까지 최소거리
            int one = bfs(nowPoint, cards.get(0))
                    + bfs(cards.get(0), cards.get(1)) + 2;

            int two = bfs(nowPoint, cards.get(1))
                    + bfs(cards.get(1), cards.get(0)) + 2;

            //5. 원상복귀
            for (int i = 0; i < 2; i++) {
                Board[cards.get(i).row][cards.get(i).col] = 0;
            }

            //6. 최소값을 탐색한다.
            result = Math.min(result, one + permutation(cards.get(1)));
            result = Math.min(result, two + permutation(cards.get(0)));

            for (int i = 0; i < 2; i++) {
                Board[cards.get(i).row][cards.get(i).col] = num;
            }
        }

        if (result == INF) {
            return 0;
        }

        return result;
    }

    private int bfs(Point from, Point to) {
        boolean[][] visitied = new boolean[BOARD_SIZE][BOARD_SIZE];
        Queue<Point> queue = new LinkedList<>();

        queue.add(from);

        while(!queue.isEmpty()) {
            Point current = queue.poll();

            if(current.row == to.row && current.col == to.col) {
                return current.cnt;
            }

            for (int i = 0; i < BOARD_SIZE; i++) {
                int nr = current.row + dxy[i][0];
                int nc = current.col + dxy[i][1];

                if(nr < 0 || nr > 3 || nc < 0 || nc > 3) {
                    continue;
                }

                if(!visitied[nr][nc]) {
                    visitied[nr][nc] = true;
                    queue.add(new Point(nr, nc, current.cnt + 1));
                }

                for (int j = 0; j < 2; j++) {
                    if(Board[nr][nc] != 0) {
                        break;
                    }
                    if(nr + dxy[i][0] < 0 || nr + dxy[i][0] > 3
                    || nc + dxy[i][1] < 0 || nc + dxy[i][1] > 3) {
                        break;
                    }
                    nr += dxy[i][0];
                    nc += dxy[i][1];
                }

                if(!visitied[nr][nc]) {
                    visitied[nr][nc] = true;
                    queue.add(new Point(nr, nc, current.cnt + 1));
                }
            }
        }

        return INF;
    }
}

class Point {
    int row;
    int col;
    int cnt;

    public Point(int row, int col, int cnt) {
        this.row = row;
        this.col = col;
        this.cnt = cnt;
    }
}
