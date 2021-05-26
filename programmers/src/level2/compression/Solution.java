package programmers.src.level2.compression;

import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String msg) {
        int indexNumber = 1; //색인 번호

        ArrayList<Integer> answerList = new ArrayList<>();
        HashMap<String, Integer> dictionary = new HashMap<>();

        for (char number = 'A'; number <= 'Z'; number++) {
            dictionary.put(number + "", indexNumber++);
        }

        int messageSize = msg.length();

        for (int index = 0; index < messageSize; index++) {
            int nowLength = 1;

            //1. 사전 추가 길이 탐색
            while (index + nowLength <= messageSize && dictionary.containsKey(msg.substring(index, index + nowLength))) {
                nowLength++;
            }

            //2. 만약 길이가 넘어갈 경우
            if (index + nowLength > messageSize) {
                answerList.add(dictionary.get(msg.substring(index)));
                break;
            }

            //3. 출력 목록에 추가(사전 추가 길이 -1)
            answerList.add(dictionary.get(msg.substring(index, index + nowLength - 1)));

            //4. 사전에 등록
            dictionary.put(msg.substring(index, index + nowLength), indexNumber++);

            //5. 위치 이동
            if (nowLength > 1) index += nowLength - 2;
        }
        return answerList;
    }
}
