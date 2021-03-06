package baekjoon1541;

/*
 * @Problem     잃어버린 괄호(1541)
 * @url         https://www.acmicpc.net/problem/1541
 * @author      pbg0205
 * @created by  2020.01.06
 */

import java.util.Scanner;

// -> 구분을 하는 과정에서 타임 레이턴시가 발생한다.
// -> 바로 index를 참조해서 연산을 구현하면 메모리, 시간 복잡도면에서도 효율 개선된다.
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        System.out.println(greedy(expression));

        scanner.close();
    }

    private static int greedy(String expression) {
        char[] charArr = expression.toCharArray();
        boolean hasMinus = (charArr[0] == '-');
        int sum = 0;
        String temp = "";

        int index = hasMinus ? 1 : 0;
        while (index < charArr.length) {

            if (charArr[index] == '+' || charArr[index] == '-') {
                sum = hasMinus ? sum - toInt(temp) : sum + toInt(temp);
                temp = "";

                if(charArr[index] == '-') {
                    hasMinus = true;
                }
            } else {
                temp += charArr[index];
            }

            index++;
        }

        return hasMinus ? sum - toInt(temp) : sum + toInt(temp);
    }

    public static int toInt(String str) {
        return Integer.parseInt(str);
    }
}
