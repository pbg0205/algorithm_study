package bruteforce.programmers;

/*
 * @Problem     카펫(https://programmers.co.kr/learn/courses/30/lessons/42842)
 * @Author      pbg02025
 * @Created by  09.15.20
 *
 */


public class carpet {
    public static void main(String[] args) {
        carpet sol = new carpet();

        int brown01 = 10; int yellow01 = 2;
        int brown02 = 8;  int yellow02 = 1;
        int brown03 = 24; int yellow03 = 24;

        int[]answer = sol.solution(brown03, yellow03);
        System.out.println(answer[0] + " " +  answer[1]);
    }
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int x = 0;
        int y = 0;

        for (int i = 1; i <= yellow ; i++) {
            if(yellow % i == 0){
                y = yellow / i;
                x = yellow / y;
            }else{
                continue;
            }

            if(brown == (x + 2) * (y + 2) - yellow){
                answer[0] = x >= y ? x + 2 : y + 2;
                answer[1] = x >= y ? y + 2 : x + 2;
                return answer ;
            }
        }

        return answer;
    }
}
