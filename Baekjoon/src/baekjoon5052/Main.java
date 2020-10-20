package baekjoon5052;
/*
 * @problem     전화번호 목록(5052)
 * @url         https://www.acmicpc.net/problem/5052
 * @author      pbg0205
 * @created by  10.20.20
 */

import java.io.*;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            checkResult();
        }

        printResult();
    }

    private static void checkResult() throws IOException {
        int numberOfTelephone = addIntByConsole();
        ArrayList<String> telephoneList = addListByConsole(numberOfTelephone);

        if (isConsistent(telephoneList)) {
            sb.append("YES \n");
        } else {
            sb.append("NO \n");
        }
    }

    private static boolean isConsistent(ArrayList<String> telephoneList) throws IOException {
        return checkConsitency(telephoneList);
    }

    private static boolean checkConsitency(ArrayList<String> telephoneList) {
        int listSize = telephoneList.size();
        Collections.sort(telephoneList); //전화번호 길이 오름차순 정렬

        for (int i = 0; i < listSize - 1; i++) {
            String nowNumber = telephoneList.get(i);
            String nextNumber = telephoneList.get(i + 1);

            if (nextNumber.startsWith(nowNumber)) {
                return false;
            }
        }

        return true;
    }

    private static int addIntByConsole() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static ArrayList<String> addListByConsole(int numberOfTelephone) throws IOException {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < numberOfTelephone; i++) {
            list.add(br.readLine());
        }

        return list;
    }

    private static void printResult() {
        System.out.println(sb);
    }
}
