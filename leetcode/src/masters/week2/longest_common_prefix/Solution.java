package masters.week2.longest_common_prefix;

import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (o1, o2) -> Integer.compare(o1.length(), o2.length()));

        int len = strs.length > 0 ? strs[0].length() : 0;
        String answer = "";

        for (int i = 0; i < len; i++) {
            boolean isPrefixAlphabet = true;
            for (int j = 0; j < strs.length; j++) {
                if (!isSameAlphabet(i, j, strs)) {
                    isPrefixAlphabet = false;
                    break;
                }
            }
            if (isPrefixAlphabet) {
                answer += strs[0].charAt(i);
            }else {
                break;
            }
        }

        return answer;
    }

    private boolean isSameAlphabet(int i, int j, String[] strs) {
        return (strs[0].charAt(i) == strs[j].charAt(i));
    }

    public static void main(String[] args) {
        String[] str = {"flower", "flow", "flight"};

        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(str));
    }
}
