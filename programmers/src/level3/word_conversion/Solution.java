package programmers.src.level3.word_conversion;

public class Solution {
    private static int min = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        if (begin.length() != target.length()) {
            return 0;
        }

        dfs(new boolean[words.length], begin, target, words, 0);

        if(min == Integer.MAX_VALUE) {
            min = 0;
        }

        return min;
    }

    private void dfs(boolean[] visited, String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            min = min > cnt ? cnt : min;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if(!visited[i] && checkWord(begin, words[i])) {
                visited[i] = true;
                dfs(visited, words[i], target, words, cnt +1);
                visited[i] = false;
            }
        }
    }

    private boolean checkWord(String begin, String target) {
        char[] beginArr = begin.toCharArray();
        char[] targetArr = target.toCharArray();

        int changeCount = 0;
        for (int i = 0; i < begin.length(); i++) {
            if(beginArr[i] != targetArr[i]) {
                changeCount++;
            }
        }

        return changeCount == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String begin = "hit";
        String target = "cog";
        String[] arr = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(solution.solution(begin, target, arr));
    }
}
