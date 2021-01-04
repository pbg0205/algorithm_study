package sorting;

import java.util.*;

class FailRatio {
    public static void main(String[] args) {
        int n = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        int n2 = 4;
        int[] stages2 = {4,1,2,3};

        FailRatio failRatio = new FailRatio();
        int[] answer = failRatio.solution(n, stages);

        for (int each : answer) {
            System.out.println(each);
        }
    }

    public int[] solution(int N, int[] stages) {
        Map<Integer, Integer> stageMap = new HashMap<>();
        int challengers = stages.length;
        Arrays.sort(stages);

        for (int stage : stages) {
            if (stageMap.containsKey(stage)) {
                int value = stageMap.get(stage);
                stageMap.put(stage, ++value);
            } else {
                stageMap.put(stage, 1);
            }
        }

        List<StageInfo> stageInfoList = new ArrayList<>();

        int noIndex = 1;
        for (Map.Entry<Integer, Integer> entry : stageMap.entrySet()) {
            int stage = entry.getKey();
            int numbers = entry.getValue();

            if (stage == noIndex) {
                stageInfoList.add(new StageInfo(stage, (double)numbers / challengers));
            }
            challengers = challengers - numbers;
        }

        Collections.sort(stageInfoList);

        for (StageInfo stageInfo : stageInfoList) {
            System.out.println(stageInfo);
        }

        int[] answer = new int[stageInfoList.size()];

        int index = 0;
        for (StageInfo stageInfo : stageInfoList) {
            answer[index++] = stageInfo.no;
        }

        return answer;
    }

    class StageInfo implements Comparable {
        private int no;
        private double failRatio;

        public StageInfo(int no, double failRatio) {
            this.no = no;
            this.failRatio = failRatio;
        }

        @Override
        public String toString() {
            return "StageInfo{" +
                    "stage=" + no +
                    ", failRatio=" + failRatio +
                    '}';
        }

        @Override
        public int compareTo(Object o) {
            StageInfo other = (StageInfo) o;

            if (failRatio != other.failRatio) {
                return -Double.compare(failRatio, other.failRatio);
            }else {
                return Integer.compare(no, other.no);
            }
        }
    }
}
