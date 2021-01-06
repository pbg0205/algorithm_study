package baekjoon1541;

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
        //return expression.split("^[0-9]+$");
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
        int temp = 0;
        int index = 1;

        for (String formula : formulas) {
            if(formula.equals("-")) {
                hasMinus = true;
                sum -= temp;
                temp = 0;
                temp += numbers[index++];
            }else {
                temp += numbers[index++];
            }
        }

        if(hasMinus) {
            sum -= temp;
        }else{
            sum += temp;
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
