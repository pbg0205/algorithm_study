package masters.week2.two_sum;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] answer;

        for (int left_idx = 0; left_idx < len; left_idx++) {
            answer = iterateRightIndex(nums, target, left_idx);

            if(answer != null) {
                return answer;
            }
        }
        return null;
    }

    private int[] iterateRightIndex(int[] nums, int target, int left_idx) {
        int[] answer = new int[2];

        for (int right_idx = left_idx + 1; right_idx < nums.length; right_idx++) {
            int sum = nums[left_idx] + nums[right_idx];

            if(sum == target) {
                answer[0] = left_idx;
                answer[1] = right_idx;
                return answer;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;

        Solution solution = new Solution();
        int[] answer = solution.twoSum(nums, target);

        for (int i : answer) {
            System.out.println(i);
        }
    }
}
