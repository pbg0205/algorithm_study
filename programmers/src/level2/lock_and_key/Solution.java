package programmers.src.level2.lock_and_key;

class Solution {

    // 2차원 배열을 90도 회전시켜주는 메서드
    public static int[][] turn(int[][] key) {
        int[][] ret = new int[key.length][key[0].length];

        for (int row = 0; row < ret.length; row++) {
            for (int col = 0; col < ret.length; col++) {
                // 오른쪽으로 90도 회전
                ret[row][col] = key[key.length - 1 - col][row];
            }
        }

        return ret;
    }

    // 자물쇠의 중간 부분이 모두 1인지 확인하는 메서드
    public static boolean chk(int[][] newLock) {
        int cnt = 0;
        int len = newLock.length / 3;
        for (int i = len; i < len * 2; i++) {
            for (int j = len; j < len * 2; j++) {
                if (newLock[i][j] == 1) cnt++;
            }
        }
        return cnt == len * len;
    }

    public boolean solution(int[][] key, int[][] lock) {
        int n = key.length;
        int m = lock.length;
        int[][] newLock = new int[m * 3][m * 3];

        // 새로만든 기존lock 크기*3의 배열의 중앙에 lock배열 삽입
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < m; col++) {
                newLock[row + m][col + m] = lock[row][col];
            }
        }

        // 4가지 방향 확인
        for (int t = 0; t < 4; t++) {
            key = turn(key); // 열쇠 회전

            // 시작점 탐색용 0,0 부터 n*2, n*2까지
            for (int a = 0; a < m * 2; a++) {
                for (int b = 0; b < m * 2; b++) {

                    // 자물쇠에 열쇠 끼우기
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            newLock[a + i][b + j] += key[i][j];
                        }
                    } // 자물쇠에 현재 열쇠 다 끼우기 완료

                    // 만약에 다 제대로 끼웠다면 원래 lock의 모든칸이 1이되어야함
                    if (chk(newLock)) return true;

                    // 자물쇠에서 열쇠 다시 빼기
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            newLock[a + i][b + j] -= key[i][j];
                        }
                    }

                }
            }
        }
        return false;
    }
}
