package happy_number;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (true) {
            int temp = 0;
            while (n > 0) {
                temp += (int) Math.pow(n % 10, 2);
                n /= 10;
                System.out.println(temp);
            }

            n = temp;

            if(temp == 1) {
                return true;
            }

            if(set.contains(temp)) {
                break;
            } else {
                set.add(temp);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(1111111));
    }
}