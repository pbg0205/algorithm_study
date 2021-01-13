package reverse_integer;

class Solution {
    public int reverse(int x) {
        String answer = "";

        if(x < 0) {
            x = -x;
            answer += "-";
        }

        if(x % 10 == 0) {
            x /= 10;
        }

        while(x > 0) {
            int mod = x % 10;
            answer += mod;
            x /= 10;
        }

        if(isZero(answer) || isOutOfInteger(answer)){
            return 0;
        }

        return Integer.parseInt(answer);
    }

    private boolean isZero(String answer) {
        return (answer.equals("") || answer.equals("-"));
    }

    private boolean isOutOfInteger(String answer) {
        final int MAX_RANGE = Integer.MAX_VALUE;
        long temp = Long.parseLong(answer);
        return (temp > MAX_RANGE) || (temp < -MAX_RANGE);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int x = 123;
        int x_1 = -123;
        int x_2 = 120;

        System.out.println(solution.reverse(x_2));
    }
}
