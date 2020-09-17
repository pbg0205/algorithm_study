package bruteforce.baekjoon;

import java.io.*;

/*
 * @Problem     집합(11723): https://www.acmicpc.net/problem/11723
 * @Author      pbg0205
 * @Created by  09.17.20
 * 
 */

public class baekjoon11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int n = toInt(br.readLine());

        int bitSet = 0;
        int element;

        while(n-- > 0){
            String[] commandLine = br.readLine().split(" ");
            String command = commandLine[0];

            if(isContainElement(commandLine)){
                element = toInt(commandLine[1]);

                if(command.equals("add")){
                    bitSet = add(bitSet, element);
                }

                if(command.equals("check")){
                    sb.append(check(bitSet, element) ? "1" : "0");
                    sb.append("\n");
                }

                if(command.equals("toggle")){
                    bitSet = toggle(bitSet, element);
                }

                if(command.equals("remove")) {
                    bitSet = remove(bitSet, element);
                }
            }

            if(command.equals("empty")){
                bitSet = getEmptySet();
            }

            if(command.equals("all")){
                bitSet = getAllElementSet();
            }
        }
        System.out.println(sb.toString());
    }
    /*element 존재 여부를 확인*/
    private static boolean isContainElement(String[] commandLine) {
        return commandLine.length >= 2;
    }
    /* all : 모든 요소(1,2...20)가 포함된 집합 반환*/
    private static int getAllElementSet() {
        return (1<<21) - 1;
    }
    /* empty : 공집합 반환*/
    private static int getEmptySet() {
        return 0;
    }
    /* remove : 집합 내 요소 반환*/
    private static int remove(int bitSet, int element) {
        if ((bitSet & (1<<element)) > 0){
            return bitSet & ~(1<<element);
        }
        return bitSet;
    }
    /*toggle : 집합에 요소가 존재하면 제거, 아니면 element 추가*/
    private static int toggle(int bitSet, int element) {
        if(check(bitSet, element)){
           return remove(bitSet, element);
        }
        return add(bitSet, element);
    }
    /*check : 집합에 요소 포함 여부 확인*/
    private static boolean check(int bitSet, int element) {
        return (bitSet & (1<<element)) > 0;
    }
    /*add : 집합 내 요소 미존재 시, 요소 추가 */
    private static int add(int bitSet ,int element){
        if((bitSet & (1<<element)) > 0){
            return bitSet;
        }

        return bitSet | (1<<element);
    }
    /*toInt : 문자열을 정수형으로 변환*/
    private static int toInt(String number) {
        return Integer.parseInt(number);
    }
}
