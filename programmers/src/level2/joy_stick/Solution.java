package programmers.src.level2.joy_stick;

class Solution {
    private static int[] minArr;

    public int solution(String name) {
        int answer = 0;
        minArr = new int[name.length()];

        int index = 0;
        for (char alphabet : name.toCharArray()) {
            minArr[index++] = Math.min(alphabet - 'A', 'Z' - alphabet + 1);
        }


        int nowIndex = 0;

        while (true) {
            answer += minArr[nowIndex];
            minArr[nowIndex] = 0;

            int prev = 1;
            int next = 1;
            int prevIndex;
            int nextIndex;

            if (!isPlaying()) {
                break;
            }

            while (true) {
                prevIndex = nowIndex - prev >= 0 ?
                        nowIndex - prev : (minArr.length + (nowIndex - prev) % minArr.length);
                if (minArr[prevIndex] != 0) {
                    break;
                }
                prev += 1;
            }

            while (true) {
                nextIndex = nowIndex + next < minArr.length ?
                        nowIndex + next : (nowIndex + next) % minArr.length;
                if (minArr[nextIndex] != 0) {
                    break;
                }
                next += 1;
            }

            nowIndex = prev < next ? prevIndex : nextIndex;
            answer += Math.min(prev, next);
        }
        return answer;
    }

    private boolean isPlaying() {
        for (int number : minArr) {
            if (number != 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("BABAAAAB"));
    }
}
