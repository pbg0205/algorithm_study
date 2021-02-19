package programmers.src.level2.normal_square;

/*
 * @Problem     멀쩡한 사각형
 * @Url         https://programmers.co.kr/learn/courses/30/lessons/62048
 * @Author      pbg0205@naver.com
 * @Created by  2021.02.19
 */

class Solution {
    public long solution(int w, int h) {
        long widthAsLong = w;
        long heightAsLong = h;

        return (widthAsLong * heightAsLong)
                - (widthAsLong + heightAsLong - gcd(widthAsLong, heightAsLong));
    }

    public long gcd(long width, long height) {
        long big = Math.max(width, height);
        long small = Math.min(width, height);

        while(small != 0) {
            long divided = big % small;
            big = small;
            small = divided;
        }

        return big;
    }
}
