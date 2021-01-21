package greedy;



class MakingBigNumber {
    public String solution(String number, int k) {
        String answer = "";

        int max = Integer.MIN_VALUE;
        int N = number.length();
        int M = N - k;

        for (int j = 0; (1 << N) > j; j++) {
            StringBuilder temp = new StringBuilder();

            if (Integer.bitCount(j) == M) {
                for (int i = 0; i < N; i++) {
                    if (((1 << i) & j) > 0) {
                        temp.append(number.charAt(i));
                    }
                }
                int tempInt = Integer.parseInt(temp.toString());
                //System.out.println(tempInt);
                if(tempInt > max) {
                    max = tempInt;
                    answer = temp.toString();
                }

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        MakingBigNumber mb = new MakingBigNumber();
        String number = "1924";
        String number2 = "1231234";
        String number3 = "4177252841";
        String number4 = "9999";

        System.out.println(mb.solution(number, 2));
        System.out.println(mb.solution(number2, 3));
        System.out.println(mb.solution(number3, 4));
        System.out.println(mb.solution(number3, 9));
    }
}
