package level1.sum_of_matrix.inner_product;

public class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;

        int index = 0;
        while(index < a.length) {
            answer += a[index] * b[index];
            index++;
        }

        return answer;
    }
}
