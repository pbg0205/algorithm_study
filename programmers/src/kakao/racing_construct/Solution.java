package programmers.src.kakao.racing_construct;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static int size;
    private static int min;
    private static int direction;

    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = { 0, 1, 0,-1};

    public int solution(int[][] board) {
        int answer = 0;

        visited = new boolean[board.length][board.length];

        size = board.length;
        min = Integer.MAX_VALUE;
        direction = dx.length;

        BFS(board);
        // 직선의 갯수 + 코너의 갯수
        //BFS로 돌린다. -> 이전의 인덱스가 일치할 경우 직선, 아닐 경우 코너로 판단한다.

        return answer;
    }

    private void BFS(int[][] board) {
        Queue<Location> queue = new LinkedList<>();

        queue.offer(new Location(0, 0));

        while(!queue.isEmpty()) {
            Location location = queue.poll();

            if(isFinished(location)) {
                int cost = location.linear * 100 + location.curve * 500;
                min = cost < min ? min : cost;
            }

            for (int i = 0; i < direction; i++) {
                int nx = location.x + dx[i];
                int ny = location.y + dy[i];

                // 범위 외에 있고 돌이 있으면 이동하지 않는다. (예외)
                if(!isBoundary(nx, ny) || hasStone(board, nx, ny)) {
                    continue;
                }

                // 이동하는데 이전 인덱스와 같거나 -1이면 직선, 아니면 커브이다.
                if(isLinear(location, i) && !visited[nx][ny]) {
                    queue.offer(new Location(nx, ny, location.linear + 1, location.curve, i));
                    visited[nx][ny] = true;
                    continue;
                }

                if(isCurve(location, i) && !visited[nx][ny]) {
                    queue.offer(new Location(nx, ny, location.linear, location.curve + 1, i));
                    visited[nx][ny] = true;
                    continue;
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
        return (location.prev_index == index || index == -1);
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
    int linear;
    int curve;
    int prev_index;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        this.linear = 0;
        this.curve = 0;
        this.prev_index = -1;
    }

    public Location(int x, int y, int linear, int curve, int prev_index) {
        this.x = x;
        this.y = y;
        this.linear = linear;
        this.curve = curve;
        this.prev_index = prev_index;
    }
}