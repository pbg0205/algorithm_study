package programmers.src.level2.tooth_brush;

import java.util.*;

public class Solution {

    private static final int BRUSH_PRICE = 100;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] result = new int[enroll.length];

        Map<String, String> parentMap = new HashMap<>();
        Map<String, Integer> myIndexMap = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
            myIndexMap.put(enroll[i], i);
        }

        for (int i = 0; i < seller.length; i++) {
            String nowSeller = seller[i];
            int totalProfit = amount[i] * BRUSH_PRICE;

            while(!nowSeller.equals("-") && totalProfit >= 1) {
                int parentProfit = totalProfit / 10;
                int nowProfit = totalProfit - parentProfit;
                int nowSellerIndex = myIndexMap.get(nowSeller);

                result[nowSellerIndex] += nowProfit;
                nowSeller = parentMap.get(nowSeller);
                totalProfit /= 10;

            }
        }

        return result;
    }
}
