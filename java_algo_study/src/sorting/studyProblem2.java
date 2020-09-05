package sorting;

import java.util.Arrays;


/*
 * @Problem     h-index(프로그래머스)
 * @Author      pbg0205
 * @Created by  09.06.20
 *
 */
public class studyProblem2 {
    public static void main(String[] args) {
        studyProblem2 sol = new studyProblem2();

        int[] citations = {3, 0, 6, 1, 5};
        int[] citations2 = {2, 0, 6, 1, 5};
        int[] citations3 = {4, 4, 4, 4, 5};

        System.out.println(sol.solution(citations2));
    }

    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if(citations[i] >= h){
                answer = h;
                break;
            }
        }

        return answer;
    }
}
