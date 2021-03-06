package programmers.src.level2.max_or_min;

import java.util.Arrays;

class Solution {
    public String solution(String s) {

        String[] parsedArr = s.split(" ");
        int[] numbers = new int[parsedArr.length];

        for (int index = 0; index < numbers.length; index++) {
            numbers[index] = Integer.parseInt(parsedArr[index]);
        }

        Arrays.sort(numbers);

        return numbers[0] + " " + numbers[parsedArr.length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("1 2 3 4"));
    }
}
