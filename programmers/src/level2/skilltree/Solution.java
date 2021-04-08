package programmers.src.level2.skilltree;

/*
 * @Problem     스킬트리
 * @Url         https://programmers.co.kr/learn/courses/30/lessons/49993
 * @Author      pbg0205@naver.com
 * @Created by  2021.02.21
 */
public class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        int index = 0;
        while (index < skill_trees.length) {
            String skill_tree = skill_trees[index];
            String skill_clone = skill_tree;

            int size = skill_tree.length();
            for (int i = 0; i < size; i++) {
                String oneSkill = String.valueOf(skill_clone.charAt(i));
                if (!skill.contains(oneSkill)) {
                    skill_tree = skill_tree.replace(oneSkill, "");
                }
            }
            if (skill.indexOf(skill_tree) == 0) {
                answer++;
            }
            index++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        String skill = "CBD";

        System.out.println(solution.solution(skill, skill_trees));
    }
}
