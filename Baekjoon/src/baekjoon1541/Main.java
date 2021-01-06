package baekjoon1541;

/*
 * @Problem     잃어버린 괄호(1541)
 * @url         https://www.acmicpc.net/problem/1541
 * @author      pbg0205
 * @created by  2020.01.06
 */

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        int[] numbers = seperateNumber(expression);
        String[] formulas = seperateFormula(expression);

        print(numbers);
        print(formulas);
        System.out.println(greedy(numbers, formulas));

        scanner.close();
    }

    private static String[] seperateFormula(String expression) {
        List<String> formulaList = new ArrayList<>();

        for (int index = 0; index < expression.length() - 1; index++) {
            String temp = expression.substring(index, index+1);
            if(temp.equals("+") || temp.equals("-")) {
                formulaList.add(temp);
            }
        }

        String[] formulas = new String[formulaList.size()];
        return formulaList.toArray(formulas);
    }

    private static int[] seperateNumber(String exprresion) {
        String[] numbersAsStr = exprresion.split("[+-]");
        return Arrays.stream(numbersAsStr).mapToInt(Integer::parseInt).toArray();
    }

    private static int greedy(int[] numbers, String[] formulas) {
        boolean hasMinus = false;
        int sum = numbers[0];
        int formula_index = 0;

        for (int index = 1; index < numbers.length; index++) {
            if(formulas[formula_index++].equals("-")) {
                hasMinus = true;
            }
            sum = hasMinus ? sum - numbers[index] : sum + numbers[index];
        }

        return sum;
    }

    private static void print(String[] formulas) {
        for (String formula : formulas) {
            System.out.println(formula);
        }
    }

    private static void print(int[] numbers) {
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
