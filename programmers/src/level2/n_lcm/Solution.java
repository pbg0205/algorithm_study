package programmers.src.level2.n_lcm;

public class Solution {
    public int solution(int[] arr) {
        int lcm = arr[0];

        for (int i =1; i < arr.length; i++) {
            lcm = getLcm(lcm, arr[i]);
        }

        return lcm;
    }

    private int getGcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    private int getLcm(int a, int b) {
        if((a <= 0) || (b <= 0)) {
            return -1;
        }

        return (a * b) / getGcd(a, b);
    }
}
