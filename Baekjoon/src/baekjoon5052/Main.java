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
    private static StringBuilder sb  = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        checkResult(testCase);

        printResult();
    }

    private static void checkResult(int size) throws IOException {
        int numberOfTelephone;
        ArrayList<String> telephoneList;

        while(size-- > 0){
            numberOfTelephone = addIntByConsole();
            telephoneList = addListByConsole(numberOfTelephone);

            if(isConsistent(telephoneList)){
                sb.append("YES \n");
            }else{
                sb.append("NO \n");
            }
        }
    }

    private static boolean isConsistent(ArrayList<String> telephoneList) throws IOException {
        return checkConsitency(telephoneList);
    }

    private static boolean checkConsitency(ArrayList<String> telephoneList) {
        int listSize = telephoneList.size();
        Collections.sort(telephoneList);

        for (int i = 0; i < listSize - 1; i++) {
            String nowNumber = telephoneList.get(i);
            String nextNumber = telephoneList.get(i + 1);

            if(nextNumber.startsWith(nowNumber)){
                return false;
            }
        }

        return true;
    }

    private static int addIntByConsole(int value) throws IOException{
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
