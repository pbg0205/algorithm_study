package programmers.src.level2.target_number;

public class Solution {
    private static int answer = 0;

    public int solution(int[] numbers, int target) {

        dfs(numbers, 0, target, 0);

        return answer;
    }

    public void dfs(int[] numbers, int sum, int target, int index) {
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        dfs(numbers, sum + numbers[index], target,index + 1);
        dfs(numbers, sum - numbers[index], target,index + 1);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int result = 3;

        Solution solution = new Solution();
        int answer = solution.solution(numbers, result);

        System.out.println(answer);
    }
}
