package masters.week2.palindrome_number;

class Solution {
    public boolean isPalindrome(int x) {
        String number_str = String.valueOf(x);
        int len = number_str.length();

        if(len == 2) {
            return number_str.charAt(0) == number_str.charAt(1);
        }

        for (int i = 0; i < len / 2; i++) {
            if (number_str.charAt(i) != number_str.charAt(len - (i + 1))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int x = 10;

        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(x));
    }
}
