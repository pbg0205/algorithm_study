package programmers.src.level1.new_id_recommand;

import java.util.Locale;

class Solution {
    public String solution(String new_id) {
        StringBuilder step2 = new StringBuilder();
         char[] arr = new_id.toLowerCase(Locale.ROOT).toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if(checkStep2(arr[i])) {
                step2.append(arr[i]);
            }
        }

        String step3 = step2.toString();
        while(step3.contains("..")) {
            step3 = step3.replace("..", ".");
        }

        String step4 = checkStep4(step3);
        String step5 = checkStep5(step4);
        String step6 = checkStep6(step5);
        String step7 = checkStep7(step6);

        return step7;
    }

    private String checkStep7(String step6) {
        while(step6.length() <= 2) {
            step6 += step6.substring(step6.length() - 1);
        }

        return step6;
    }

    private String checkStep6(String step5) {
        String step6 = step5.length() >= 16 ? step5.substring(0, 15) : step5;
        return step6.charAt(step6.length() - 1) == '.' ?
        step6.substring(0, step6.length() - 1) : step6;
    }

    private String checkStep5(String step4) {
        return step4.equals("") ? "a" : step4;
    }

    private String checkStep4(String step3) {
        String step4 = step3;

        if(step4.length() > 0 && step4.charAt(0) == '.') {
            step4 = step4.substring(1);
        }

        if(step4.length() > 0 && step4.charAt(step4.length() - 1) == '.') {
            step4 = step4.substring(0, step3.length() - 1);
        }

        return step4;
    }

    private boolean checkStep2(char c) {
        return isLowerCase(c) || isNumberic(c)
                || c == '.' || c == '-' || c == '_';
    }

    private boolean isLowerCase(char c) {
        return ('a' <= c) && (c <= 'z');
    }

    private boolean isNumberic(char c) {
        return ('0' <= c) && (c <= '9');
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String sample1 = "...!@BaT#*..y.abcdefghijklm3";
        String sample2 = "z-+.^.";
        String sample3 = "=.=";
        String sample4 = "123_.def";
        String sample5 = "abcdefghijklmn.p";

        System.out.println(solution.solution(sample3));
    }
}
//1. 대문자 -> 소문자
//2. 알파벳 소문자, 숫자,  빼기, 밑줄, 마침표 제거
//3. 2번이상 마침표 하나로 제거
//4. 마침표에 처음과 끝에 존재시 제거
//5. 빈 문자열이라면 a 추가
//6. 16자 이상 -> 15개 빼고 모두 제거
//7. new_id 길이가 2자이하, 마지막 무자를 3될때까지 반복
