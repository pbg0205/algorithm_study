package String;

/*
 * @ Problem    이상한 문자 만들기
 * @ Url        https://programmers.co.kr/learn/courses/30/lessons/12930
 * @ Author     pbg0205
 * @ Created by 2021.01.20
 */

public class StrangeWord {
    public String solution(String s) {
        String answer = "";
        String[] strArr = s.split(" ", -1);

        for(int j = 0; j < strArr.length; j++) {
            char[] charArr =strArr[j].toCharArray();

            for (int i = 0; i < charArr.length; i++) {
                if(i % 2 == 0) {
                        charArr[i] = isLowerCase(charArr, i) ?
                                (char) (charArr[i] - 32) : charArr[i];//소문자 >> 대문자
                }

                if(i % 2 == 1){
                    charArr[i] = isUpperCase(charArr, i) ?
                            (char) (charArr[i] + 32) : charArr[i];//대문자 >> 소문자
                }
            }
            answer += String.copyValueOf(charArr);

            if(j < strArr.length -1){
                answer += " ";
            }
        }

        return answer;
    }

    private boolean isLowerCase(char[] charArr, int i) {
        return (charArr[i] >= 97 && charArr[i] <= 122);
    }

    private boolean isUpperCase(char[] charArr, int i) {
        return (charArr[i] >= 65 && charArr[i] <= 90);
    }
}
