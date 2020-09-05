package sorting;

/*
 * @Problem     가장 큰 수(프로그래머스)
 * @Author      pbg0205
 * @Created by  09.05.20
 *
 */

import java.util.Arrays;
import java.util.Comparator;

public class studyProblem1 {
    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};

        studyProblem1 sol = new studyProblem1();

        System.out.println(sol.solution(numbers));
    }

    public String solution(int[] numbers) {
        String answer = "";

        String[] strArr = new String[numbers.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if(strArr[0].equals("0")){
            answer += "0";
            return answer;
        }

        for (int i = 0; i < strArr.length; i++) {
            answer += strArr[i];
        }

        return answer;
    }
}