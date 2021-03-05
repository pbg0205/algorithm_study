package programmers.src.level2.right_bracket;

import java.util.Stack;

public class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] brackets = s.toCharArray();

        for (char bracket : brackets) {
            if (bracket == '(') {
                stack.push(bracket);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            if (stack.peek() == '(') {
                stack.pop();
            }
        }

        return !stack.isEmpty() ? false : true;
    }

    public static void main(String[] args) {
        String brackets = "()()";
        String brackets2 = "(())()";
        String brackets3 = ")()(";

        Solution solution = new Solution();
        System.out.println(solution.solution(brackets3));
    }
}
