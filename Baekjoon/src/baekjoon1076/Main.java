package baekjoon1076;

/*
 * @ Problem    저항(1076)
 * @ Url        https://www.acmicpc.net/problem/1076
 * @ Author     pbg0205
 * @ Created by 2020.01.06
 */

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String[]> colorMap = initColorMap();

        String color;
        int count = 0;
        long result;
        String[] valueArr = new String[3];

        while (count < 3) {
            color = br.readLine();
            String[] colorInfo = colorMap.get(color);

            if (count < 2) {
                valueArr[count] = colorInfo[0];
            } else {
                valueArr[count] = colorInfo[1];
            }

            count++;
        }

        result = Long.parseLong(valueArr[0] + valueArr[1]) * Long.parseLong(valueArr[2]);
        System.out.println(result);

        br.close();
    }

    private static Map<String, String[]> initColorMap() {
        Map<String, String[]> colorMap = new HashMap<>();

        colorMap.put("black", new String[]{"0", "1"});
        colorMap.put("brown", new String[]{"1", "10"});
        colorMap.put("red", new String[]{"2", "100"});
        colorMap.put("orange", new String[]{"3", "1000"});
        colorMap.put("yellow", new String[]{"4", "10000"});
        colorMap.put("green", new String[]{"5", "100000"});
        colorMap.put("blue", new String[]{"6", "1000000"});
        colorMap.put("violet", new String[]{"7", "10000000"});
        colorMap.put("grey", new String[]{"8", "100000000"});
        colorMap.put("white", new String[]{"9", "1000000000"});

        return colorMap;
    }
}
