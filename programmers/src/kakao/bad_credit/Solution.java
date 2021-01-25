package kakao.bad_credit;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Solution {
    private Set<Set<String>> bannedSet;

    public int solution(String[] user_id, String[] banned_id) {
        bannedSet = new HashSet<>();
        backTracking(user_id, banned_id, new LinkedHashSet<>());
        return bannedSet.size();
    }

    private void backTracking(String[] user_id, String[] banned_id, Set<String> candidateSet) {
        if (candidateSet.size() == banned_id.length) {
            if (areBanned(candidateSet, banned_id)) {
                bannedSet.add(new HashSet<>(candidateSet));
            }
            return;
        }

        for (String user : user_id) {
            if (candidateSet.contains(user)) {
                continue;
            }

            candidateSet.add(user);
            backTracking(user_id, banned_id, candidateSet);
            candidateSet.remove(user);
        }
    }

    private boolean areBanned(Set<String> candidateSet, String[] banned_id) {
        int index = 0;

        for (String candidate : candidateSet) {
            if (!isSameName(candidate, banned_id[index++])) {
                return false;
            }
        }

        return true;
    }

    private boolean isSameName(String control, String compare) {
        if (control.length() != compare.length()) {
            return false;
        }

        for (int index = 0; index < control.length(); index++) {
            if (compare.charAt(index) == '*') {
                continue;
            }

            if (control.charAt(index) != compare.charAt(index)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};

        String[] user_id3 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id3 = {"fr*d*", "*rodo", "******", "******"};

        int answer = solution.solution(user_id3, banned_id3);
        System.out.println(answer);
    }
}