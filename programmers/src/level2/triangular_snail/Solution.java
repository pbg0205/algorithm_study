package programmers.src.level2.triangular_snail;

class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int[][] temp = new int[n][n];

        int xPos = -1;
        int yPos = 0;
        int number = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n - i); j++) {
                if (i % 3 == 0) {
                    xPos++;
                }

                if (i % 3 == 1) {
                    yPos++;
                }

                if (i % 3 == 2) {
                    xPos--;
                    yPos--;
                }
                temp[xPos][yPos] = number++;
            }
        }

        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col <= row; col++) {
                answer[count++] = temp[row][col];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(4);

        for (int number : result) {
            System.out.printf("%d ", number);
        }
    }
}
