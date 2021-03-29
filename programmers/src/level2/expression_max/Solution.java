package programmers.src.level2.expression_max;

import java.util.*;

public class Solution {
    static String[] operations;
    static long answer;
    static String exp;

    public static long solution(String expression) {
        exp = expression;
        List<String> operationPriorityList = new ArrayList<>();

        addOperations(expression, operationPriorityList);

        operations = new String[operationPriorityList.size()];

        for (int i = 0; i < operations.length; i++) {
            operations[i] = operationPriorityList.get(i);
        }

        answer = -1;

        backTracking(0);
        return answer;
    }

    private static void addOperations(String expression, List<String> operationPriorityList) {
        if (expression.contains("+")) {
            operationPriorityList.add("+");
        }
        if (expression.contains("-")) {
            operationPriorityList.add("-");
        }
        if (expression.contains("*")) {
            operationPriorityList.add("*");
        }
    }

    static void backTracking(int depth) {
        if (depth == operations.length) {
            long ret = calculate();
            answer = Math.max(ret, answer);
            return;
        }

        for (int i = depth; i < operations.length; i++) {
            swap(i, depth);
            backTracking(depth + 1);
            swap(i, depth);
        }
    }

    static void swap(int i, int j) {
        String temp = operations[i];
        operations[i] = operations[j];
        operations[j] = temp;
    }

    static long calculate() {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> postfixEquation = new ArrayList<>();
        Stack<String> operationStack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < operations.length; i++) {
            map.put(operations[i], i);
        }

        int len = exp.length();
        // 400 - 600
        for (int i = 0; i < len; i++) {
            String temp = Character.toString(exp.charAt(i));

            if (isOperator(temp)) {
                postfixEquation.add(sb.toString());
                sb.delete(0, sb.length());

                while (!operationStack.isEmpty() && map.get(temp) <= map.get(operationStack.peek())) {
                    postfixEquation.add(operationStack.pop());
                }
                operationStack.push(temp);
                continue;
            }

            sb.append(temp);
        }

        postfixEquation.add(sb.toString());

        while (!operationStack.isEmpty()) {
            postfixEquation.add(operationStack.pop());
        }

        Stack<Long> value = new Stack<>();

        for (String e : postfixEquation) {
            if (map.containsKey(e)) {
                long b = value.pop();
                long a = value.pop();
                if (e.equals("+")) {
                    value.push(a + b);
                }
                if (e.equals("-")) {
                    value.push(a - b);
                }
                if (e.equals("*")) {
                    value.push(a * b);
                }
            } else {
                value.push(Long.parseLong(e));
            }
        }
        return Math.abs(value.pop());
    }

    private static boolean isOperator(String temp) {
        return temp.equals("+") || temp.equals("-") || temp.equals("*");
    }
}
