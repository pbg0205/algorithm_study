package HashMap;

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String> resultList = new ArrayList<>();

        for (String data : record) {
            String[] log = data.split(" ");
            if(log[0].equals("Enter")) {
                map.put(log[1], log[2]);
            }

            if(log[0].equals("Change")) {
                if(map.containsKey(log[1])) {
                    map.replace(log[1], log[2]);
                }
            }
        }

        for (String data : record) {
            String[] log = data.split(" ");
            if(log[0].equals("Enter")) {
                resultList.add(String.format("%s님이 들어왔습니다.", map.get(log[1])));
            }

            if(log[0].equals("Leave")) {
                resultList.add(String.format("%s님이 나갔습니다.", map.get(log[1])));
            }
        }

        String[] result = new String[resultList.size()];
        return resultList.toArray(result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
                "Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        String[] results = solution.solution(record);

        for (String result : results) {
            System.out.println(result);
        }
    }
}
