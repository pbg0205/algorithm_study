package programmers.src.kakao.racing_construct;

import java.util.*;

class Solution {
    private static int size;
    private static int min;
    private static int direction;

    private static int[][] map;
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = { 0, 1, 0,-1};

    public int solution(int[][] board) {

        size = board.length;
        min = Integer.MAX_VALUE;
        direction = dx.length;

        map = new int[board.length][board.length];

        BFS(board);

        return min;
    }

    private void BFS(int[][] board) {
        Queue<Location> queue = new LinkedList<>();

        queue.offer(new Location(0, 0));

        while(!queue.isEmpty()) {
            Location location = queue.poll();

            if(isFinished(location)) {
                min = Math.min(location.sum, min);
                continue;
            }

            for (int i = 0; i < direction; i++) {
                int nx = location.x + dx[i];
                int ny = location.y + dy[i];

                // 범위 외에 있고 돌이 있으면 이동하지 않는다. (예외)
                if(!isBoundary(nx, ny) || hasStone(board, nx, ny)) {
                    continue;
                }

                int nextFieldSum = location.sum;

                if(isLinear(location, i)) {
                    nextFieldSum = location.sum + 100;
                }else if(isCurve(location, i)) {
                    nextFieldSum = location.sum + 600;
                }

                if(map[nx][ny] == 0 || map[nx][ny] >= nextFieldSum) {
                    map[nx][ny] = nextFieldSum;
                    queue.offer(new Location(nx, ny, nextFieldSum, i));
                }
            }
        }
    }

    private boolean isFinished(Location location) {
        return (location.x == size - 1) && (location.y == size - 1);
    }

    public boolean isBoundary(int x, int y) {
        return (0 <= x && x < size) && (0 <= y && y < size);
    }

    public boolean hasStone(int[][] board, int x, int y) {
        return board[x][y] == 1;
    }

    public boolean isLinear(Location location, int index) {
        return (location.prev_index == index || location.prev_index == -1);
    }

    public boolean isCurve(Location location, int index) {
        return (location.prev_index != index);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] board = {
                {0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0},
                {0,0,0,0,1,0,0,0},
                {0,0,0,1,0,0,0,1},
                {0,0,1,0,0,0,1,0},
                {0,1,0,0,0,1,0,0},
                {1,0,0,0,0,0,0,0}
        };

        System.out.println(solution.solution(board));
    }
}

class Location {
    int x;
    int y;
    int sum;
    int prev_index;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        this.sum = 0;
        this.prev_index = -1;
    }

    public Location(int x, int y, int sum, int prev_index) {
        this.x = x;
        this.y = y;
        this.sum = sum;
        this.prev_index = prev_index;
    }
}
