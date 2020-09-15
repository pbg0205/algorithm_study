package bruteforce.programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @Problem     두 개 뽑아서 더하기(https://programmers.co.kr/learn/courses/30/lessons/68644)
 * @AUthor      pbg0205
 * @Created by  09.15.20
 *
 */
public class SumOfTwo {
    public static void main(String[] args) {
        SumOfTwo sol = new SumOfTwo();
        int[] numbers = {2,1,3,4,1};
        int[] numbers2 = {5, 0, 2, 7};
        int[] answer = sol.solution(numbers2);

        for (int result : answer) {
            System.out.println(result);
        }
    }
    public int[] solution(int[] numbers) {
        int[] answer;

        int numbersLen = numbers.length;
        Arrays.sort(numbers);
        Set<Integer> set = new HashSet<>();

        for (int idx_l = 0; idx_l < numbersLen - 1; idx_l++) {
            for (int idx_r = idx_l + 1; idx_r < numbersLen; idx_r++) {
                int sum = numbers[idx_l] + numbers[idx_r];
                if(!set.contains(sum)){
                    set.add(sum);
                }else{
                    continue;
                }
            }
        }

        answer = set.stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);

        return answer;
    }
}
